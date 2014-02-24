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

import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.ModuleChunk;
import org.jetbrains.jps.builders.DirtyFilesHolder;
import org.jetbrains.jps.builders.java.JavaSourceRootDescriptor;
import org.jetbrains.jps.incremental.*;
import org.jetbrains.jps.incremental.messages.BuildMessage;
import org.jetbrains.jps.incremental.messages.CompilerMessage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author mark
 */
public class SalesForceModuleLevelBuilder extends ModuleLevelBuilder {

    private Logger logger = Logger.getInstance(getClass());

    public SalesForceModuleLevelBuilder() {
        super(BuilderCategory.TRANSLATOR);
    }

    @Override
    public ExitCode build(CompileContext context,
                          ModuleChunk chunk,
                          DirtyFilesHolder<JavaSourceRootDescriptor, ModuleBuildTarget> dirtyFilesHolder,
                          OutputConsumer outputConsumer) throws ProjectBuildException, IOException {

        logger.warn("Testing 1 2 3");
        context.processMessage(new CompilerMessage(getPresentableName(), BuildMessage.Kind.WARNING, "Starting Salesforce Compile..."));
        SalesForceProjectSettings projectSettings = SalesForceProjectSettings.getSettings(context.getProjectDescriptor().getProject());
        context.processMessage(new CompilerMessage(getPresentableName(), BuildMessage.Kind.WARNING, "Using instance named: " + projectSettings.instanceName));
        return ExitCode.OK;
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
}
