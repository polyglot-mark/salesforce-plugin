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

package au.com.borner.salesforce.plugin.apex;

import com.intellij.icons.AllIcons;
import com.intellij.util.PlatformIcons;

import javax.swing.*;

/**
 * Created by mark
 */
public interface ApexIcons {

    Icon CLASS = PlatformIcons.CLASS_ICON;
    Icon INTERFACE = PlatformIcons.INTERFACE_ICON;
    Icon TRIGGER = PlatformIcons.FUNCTION_ICON;
    Icon PUBLIC = PlatformIcons.PUBLIC_ICON;
    Icon PROTECTED = PlatformIcons.PROTECTED_ICON;
    Icon PRIVATE = PlatformIcons.PRIVATE_ICON;
    Icon GLOBAL = PlatformIcons.WEB_ICON;
    Icon EXCEPTION = AllIcons.Nodes.ExceptionClass;
    Icon ENUM = AllIcons.Nodes.Enum;

    public interface FileType {
        Icon CLASS = AllIcons.FileTypes.Java;
        Icon TRIGGER = AllIcons.Nodes.Function;
    }
}
