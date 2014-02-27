package au.com.borner.salesforce.plugin.compiler;

import au.com.borner.salesforce.client.rest.domain.*;
import au.com.borner.salesforce.plugin.apex.filetypes.ApexClassFileType;
import au.com.borner.salesforce.plugin.apex.filetypes.ApexTriggerFileType;
import au.com.borner.salesforce.plugin.service.ClientFactoryService;
import au.com.borner.salesforce.plugin.visualforce.filetypes.VisualForceComponentFileType;
import au.com.borner.salesforce.plugin.visualforce.filetypes.VisualForcePageFileType;
import au.com.borner.salesforce.util.FileUtilities;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileScope;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.compiler.TranslatingCompiler;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.Chunk;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This compiler gets invoked if the user un-ticks "Use External Build" in the Compiler settings
 *
 * SourceGeneratingCompiler -> SourceInstrumentingCompiler -> TranslatingCompiler ->  ClassInstrumentingCompiler -> ClassPostProcessingCompiler -> PackagingCompiler -> Validator
 *
 * Note: do not define this bean in the plugin.xml - otherwise it will be called twice for each compilation!
 *
 * @author mark
 */
public class SalesForceCompiler implements TranslatingCompiler {

    private final ClientFactoryService clientFactoryService;

    public SalesForceCompiler(Project project) {
        clientFactoryService = ServiceManager.getService(project, ClientFactoryService.class);
    }

    @Override
    public boolean isCompilableFile(VirtualFile file, CompileContext context) {
        return ApexClassFileType.INSTANCE.getDefaultExtension().equals(file.getExtension()) ||
                ApexTriggerFileType.INSTANCE.getDefaultExtension().equals(file.getExtension()) ||
                VisualForcePageFileType.INSTANCE.getDefaultExtension().equals(file.getExtension()) ||
                VisualForceComponentFileType.INSTANCE.getDefaultExtension().equals(file.getExtension());
    }

    @Override
    public void compile(CompileContext context, Chunk<Module> moduleChunk, VirtualFile[] files, OutputSink sink) {

        String containerId = UUID.randomUUID().toString().replaceAll("-", "");
        MetadataContainer metadataContainer = new MetadataContainer(containerId);
        metadataContainer = clientFactoryService.getToolingClient().createSObject(metadataContainer);

        Map<String, String> fileNameToUrlMap = new HashMap<String, String>(files.length);

        int fileCount = 0;
        for (VirtualFile file : files) {

            // Update progress indicator
            double progressFraction = ++fileCount / files.length;
            context.getProgressIndicator().setFraction(progressFraction);
            context.getProgressIndicator().setText("Processing " + file.getNameWithoutExtension());

            fileNameToUrlMap.put(file.getNameWithoutExtension(), file.getUrl());

            AbstractMetadataMember member;
            if (file.getFileType() instanceof ApexClassFileType) {
                member = new ApexClassMember(metadataContainer);
            } else if (file.getFileType() instanceof ApexTriggerFileType) {
                member = new ApexTriggerMember(metadataContainer);
            } else if (file.getFileType() instanceof VisualForcePageFileType) {
                member = new VisualForcePageMember(metadataContainer);
            } else {
                member = new VisualForceComponentMember(metadataContainer);
            }

            Pair<String,SourceFileMetaData> filePair;
            try {
                filePair = FileUtilities.getFileContents(file);
            } catch (Exception exception) {
                context.addMessage(CompilerMessageCategory.ERROR, "Unable to read local file", null, -1, -1);
                return;
            }

            member.setBody(filePair.getFirst());
            member.setContentEntityId(filePair.getSecond().getId());
            clientFactoryService.getToolingClient().createSObject(member);
        }

        context.getProgressIndicator().setIndeterminate(true);
        context.getProgressIndicator().setText("Compiling");

        ContainerAsyncRequest containerAsyncRequest = new ContainerAsyncRequest(metadataContainer);
        containerAsyncRequest = clientFactoryService.getToolingClient().createSObject(containerAsyncRequest);
        while (containerAsyncRequest.getState() == null || containerAsyncRequest.getState().equals(ContainerAsyncRequest.State.Queued)) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // ignore
            }
            containerAsyncRequest = clientFactoryService.getToolingClient().getSObject(containerAsyncRequest, ContainerAsyncRequest.class);
        }

        switch (containerAsyncRequest.getState()) {
            case Completed:
                context.addMessage(CompilerMessageCategory.INFORMATION, "Compilation was successful", null, -1, -1);
                break;
            case Error:
                context.addMessage(CompilerMessageCategory.ERROR, "A compiler error occurred " + containerAsyncRequest.getErrorMsg(), null, -1, -1);
                break;
            case Failed:
                List<CompilerError> compilerErrors = containerAsyncRequest.getCompilerErrors();
                if (compilerErrors.size() == 0) {
                    context.addMessage(CompilerMessageCategory.ERROR, "Compilation failed", null, -1, -1);
                } else {
                    for (CompilerError compilerError : compilerErrors) {
                        String fileUrl = fileNameToUrlMap.get(compilerError.getName());
                        context.addMessage(CompilerMessageCategory.ERROR, compilerError.getProblem(), fileUrl, compilerError.getLine(), 1);
                    }
                }
                break;
            case Invalidated:
                context.addMessage(CompilerMessageCategory.ERROR, "The compilation was invalidated by the server - please try again", null, -1, -1);
                break;

            case Aborted:
                context.addMessage(CompilerMessageCategory.ERROR, "The compilation was aborted - please try again", null, -1, -1);
                break;

            default:
                context.addMessage(CompilerMessageCategory.ERROR, "An unknown error occurred", null, -1, -1);
                break;

        }

        context.addMessage(CompilerMessageCategory.INFORMATION, "Deleting Metadata Container", null, -1, -1);
        clientFactoryService.getToolingClient().deleteSObject(metadataContainer);
    }

    @NotNull
    @Override
    public String getDescription() {
        return "SalesForce Compiler";
    }

    @Override
    public boolean validateConfiguration(CompileScope scope) {
        return true;
    }

}
