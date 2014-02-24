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

package au.com.borner.salesforce.plugin.util;

import com.intellij.ui.RowIcon;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Utility methods for Icon's
 *
 * Created by mark
 */
public abstract class IconUtilities {

    public static RowIcon createIconRow(@NotNull Icon first, @NotNull Icon second) {
        RowIcon rowIcon = new RowIcon(2);
        rowIcon.setIcon(first, 0);
        rowIcon.setIcon(second, 1);
        return rowIcon;
    }

}
