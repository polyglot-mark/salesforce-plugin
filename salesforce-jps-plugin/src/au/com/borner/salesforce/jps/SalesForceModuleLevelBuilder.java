/*
 * Copyright 2014 Mark Borner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.com.borner.salesforce.jps;

import au.com.borner.salesforce.client.rest.ConnectionManager;
import au.com.borner.salesforce.client.InstanceCredentials;
import au.com.borner.salesforce.client.rest.ToolingRestClient;
import au.com.borner.salesforce.client.rest.domain.*;
import au.com.borner.salesforce.client.wsc.SoapClient;
import au.com.borner.salesforce.util.FileUtilities;
import com.intellij.openapi.util.Pair;
import com.sforce.soap.apex.*;
import com.sforce.soap.apex.CodeCoverageResult;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.FileProcessor;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.*;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * The Salesforce Module Level Builder (aka Compiler)
 *
 * @author mark
 */
public class SalesForceModuleLevelBuilder extends ModuleLevelBuilder {

    private static final String EMPTY = "";

    public SalesForceModuleLevelBuilder() {
        super(BuilderCategory.TRANSLATOR);
    }

    @Override
    public ExitCode build(CompileContext context,
                          ModuleChunk chunk,
                          DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
                          OutputConsumer outputConsumer) throws ProjectBuildException, IOException {

        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Starting Salesforce Compiler"));
        SalesForceProjectSettings projectSettings = SalesForceProjectSettings.getSettings(context.getProjectDescriptor().getProject());

//        return compileUsingToolingAPI(context, dirtyFilesHolder);
        return compileUsingApexAPI(context, dirtyFilesHolder);
    }

    @Override
    public List<String> getCompilableFileExtensions() {
        return Arrays.asList("cls", "page", "trigger", "component");
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return "Salesforce Compiler";
    }

    // Apex API compile -------------------------------------------

    public ExitCode compileUsingApexAPI(final CompileContext context,
                                           DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) throws ProjectBuildException, IOException {

        // Step 1: log into Salesforce
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Logging into Salesforce"));
        InstanceCredentials instanceCredentials = new InstanceCredentials("Compile");
        instanceCredentials.setUsername(System.getProperty("username"));
        instanceCredentials.setPassword(System.getProperty("password"));
        instanceCredentials.setSecurityToken(System.getProperty("securityToken"));
        instanceCredentials.setEnvironment(System.getProperty("environment"));
        SoapClient soapClient = new SoapClient();
        soapClient.login(instanceCredentials, Boolean.getBoolean(System.getProperty("traceMessages")));


        // Step 2: get all source
        final Map<String, String> fileNameToUrlMap = new HashMap<String, String>();
        final List<String> classes = new ArrayList<String>();
        final List<String> triggers = new ArrayList<String>();
        dirtyFilesHolder.processDirtyFiles(new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
            @Override
            public boolean apply(ModuleBuildTarget target, File file, JavaSourceRootDescriptor root) throws IOException {
                fileNameToUrlMap.put(FileUtilities.filenameWithoutExtension(file.getName()), file.getAbsolutePath());
                if (file.getName().endsWith(".cls")) {
                    classes.add(FileUtils.readFileToString(file));
                } else if (file.getName().endsWith(".trigger")) {
                    triggers.add(FileUtils.readFileToString(file));
                }
                return true;
            }
        });

        // Step 3: compile
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Compiling"));
        CompileAndTestResult compileAndTestResult = soapClient.compile(classes, triggers);
        soapClient.logoff();

        // Step 4: check results
        if (compileAndTestResult.getSuccess()) {
            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.INFO, "Compilation was successful"));
            RunTestsResult runTestsResult = compileAndTestResult.getRunTestsResult();
            for (CodeCoverageResult codeCoverageResult : runTestsResult.getCodeCoverage()) {
                if (codeCoverageResult.getNumLocationsNotCovered() == 0) {
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.INFO, codeCoverageResult.getName() + " coverage: 100%"));
                } else {
                    double percentNotCovered = codeCoverageResult.getNumLocations() / codeCoverageResult.getNumLocationsNotCovered();
                    double percentCovered = 1 - percentNotCovered;
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.INFO, codeCoverageResult.getName() + " coverage: " + String.format("%.2f", percentCovered)));
                }
            }
            for (CodeCoverageWarning codeCoverageWarning : runTestsResult.getCodeCoverageWarnings()) {
                String fileName = fileNameToUrlMap.get(codeCoverageWarning.getName());
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.WARNING, codeCoverageWarning.getMessage(), fileName, -1, -1, -1, -1, -1));
            }
            return ExitCode.OK;
        } else {
            for (CompileClassResult compileClassResult : compileAndTestResult.getClasses()) {
                String filePath = fileNameToUrlMap.get(compileClassResult.getName());
                if (!compileClassResult.isSuccess()) {
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, compileClassResult.getProblem(), filePath, -1, -1, -1, compileClassResult.getLine(), compileClassResult.getColumn()));
                }
                for (String warning : compileClassResult.getWarnings()) {
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.WARNING, warning, filePath, -1, -1, -1, 1, 0));
                }
            }
            for (CompileTriggerResult compileTriggerResult : compileAndTestResult.getTriggers()) {
                String filePath = fileNameToUrlMap.get(compileTriggerResult.getName());
                if (!compileTriggerResult.isSuccess()) {
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, compileTriggerResult.getProblem(), filePath, -1, -1, -1, compileTriggerResult.getLine(), compileTriggerResult.getColumn()));
                }
            }
            return ExitCode.ABORT;
        }
    }

    // Tooling API compile ----------------------------------------

    public ExitCode compileUsingToolingAPI(final CompileContext context,
                                           DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder) throws ProjectBuildException, IOException {

        // Step 1: login to Salesforce
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Logging into Salesforce"));
        InstanceCredentials instanceCredentials = new InstanceCredentials("Compile");
        instanceCredentials.setUsername(System.getProperty("username"));
        instanceCredentials.setPassword(System.getProperty("password"));
        instanceCredentials.setSecurityToken(System.getProperty("securityToken"));
        instanceCredentials.setEnvironment(System.getProperty("environment"));
        SoapClient soapClient = new SoapClient();
        soapClient.login(instanceCredentials, Boolean.getBoolean(System.getProperty("traceMessages")));
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.setSessionDetails(soapClient.getSessionId(), soapClient.getServiceHost());
        final ToolingRestClient toolingRestClient = new ToolingRestClient(connectionManager);

        // Step 2: create Metadata container
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Creating Metadata Container"));
        String containerId = UUID.randomUUID().toString().replaceAll("-", "");
        final MetadataContainer metadataContainer = toolingRestClient.createSObject(new MetadataContainer(containerId));

        // Step 3: upload all the modified files into the Metadata container
        final Map<String, String> fileNameToUrlMap = new HashMap<String, String>();
        dirtyFilesHolder.processDirtyFiles(new FileProcessor<JavaSourceRootDescriptor, ModuleBuildTarget>() {
            @Override
            public boolean apply(ModuleBuildTarget target, File file, JavaSourceRootDescriptor root) throws IOException {
                fileNameToUrlMap.put(FileUtilities.filenameWithoutExtension(file.getName()), file.getAbsolutePath());
                uploadSource(file, metadataContainer, context, toolingRestClient);
                return true;
            }
        });

        // Step 4: invoke the Salesforce compiler
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Requesting Async Compile"));
        ContainerAsyncRequest containerAsyncRequest = new ContainerAsyncRequest(metadataContainer);
        containerAsyncRequest.setCheckOnly(false);
        containerAsyncRequest.setRunTests(true);
        containerAsyncRequest = toolingRestClient.createSObject(containerAsyncRequest);
        int retryCount = 0;
        // TODO: make these parameters configurable because large amount of source files will take longer to compile!
        while ((containerAsyncRequest.getState() == null || containerAsyncRequest.getState().equals(ContainerAsyncRequest.State.Queued)) && ++retryCount < 60) {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // ignore
            }
            containerAsyncRequest = toolingRestClient.getSObject(containerAsyncRequest, ContainerAsyncRequest.class);
        }

        // Step 5: check result
        if (containerAsyncRequest.getState() == null || containerAsyncRequest.getState().equals(ContainerAsyncRequest.State.Queued)) {
            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, "Compile has timed out"));
            soapClient.logoff();
            return ExitCode.ABORT;
        }

        ExitCode exitCode = ExitCode.OK;
        switch (containerAsyncRequest.getState()) {
            case Completed:
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.INFO, "Compilation was successful"));
                break;
            case Error:
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, "A compiler error occurred " + containerAsyncRequest.getErrorMsg()));
                exitCode = ExitCode.ABORT;
                break;
            case Failed:
                List<CompilerError> compilerErrors = containerAsyncRequest.getCompilerErrors();
                if (compilerErrors.size() == 0) {
                    context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, "Compilation failed"));
                } else {
                    for (CompilerError compilerError : compilerErrors) {
                        String filePath = fileNameToUrlMap.get(compilerError.getName());
                        Pair<Integer,Integer> location = compilerError.getLocation();
                        if (location == null) {
                            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, compilerError.getProblem(), filePath, -1, -1, -1, compilerError.getLine(), 0));
                        } else {
                            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, compilerError.getProblem(), filePath, -1, -1, -1, location.first, location.second));
                        }
                    }
                }
                exitCode = ExitCode.ABORT;
                break;
            case Invalidated:
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.WARNING, "The compilation was invalidated by the server"));
                exitCode = ExitCode.CHUNK_REBUILD_REQUIRED;
                break;
            case Aborted:
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.WARNING, "The compilation was aborted"));
                exitCode = ExitCode.CHUNK_REBUILD_REQUIRED;
                break;
            default:
                context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, "An unknown error occurred"));
                exitCode = ExitCode.ABORT;
                break;
        }

        // Step 6: Delete metadata container and logoff
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Deleting Metadata Container"));
        toolingRestClient.deleteSObject(metadataContainer);
        soapClient.logoff();
        return exitCode;

    }

    public void uploadSource(@NotNull File file, @NotNull MetadataContainer metadataContainer, @NotNull CompileContext context, @NotNull ToolingRestClient toolingRestClient) {
        AbstractMetadataMember member;
        if (file.getName().endsWith(".cls")) {
            member = new ApexClassMember(metadataContainer);
        } else if (file.getName().endsWith(".trigger")) {
            member = new ApexTriggerMember(metadataContainer);
        } else if (file.getName().endsWith(".page")) {
            member = new VisualForcePageMember(metadataContainer);
        } else if (file.getName().endsWith(".component")){
            member = new VisualForceComponentMember(metadataContainer);
        } else {
            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.WARNING, "Unknown file type: " + file.getAbsolutePath()));
            return;
        }

        Pair<String,SourceFileMetaData> filePair;
        try {
            filePair = FileUtilities.getFileContents(file);
        } catch (Exception exception) {
            context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.ERROR, "Unable to read local file: " + file.getName()));
            return;  // TODO: throw exception?
        }
        member.setBody(filePair.getFirst());
        member.setContentEntityId(filePair.getSecond().getId());
        toolingRestClient.createSObject(member);
        context.processMessage(new CompilerMessage(EMPTY, BuildMessage.Kind.PROGRESS, "Uploading " + file.getName()));
    }

}
