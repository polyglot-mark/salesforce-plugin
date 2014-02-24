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

package au.com.borner.salesforce.plugin.template;

/**
 * An interface containing the file template names
 *
 * @author mark
 */
public interface FileTemplates {

    String APEX_CLASS_TEMPLATE = "ApexClass.cls";
    String APEX_INTERFACE_TEMPLATE = "ApexInterface.cls";
    String APEX_TRIGGER_TEMPLATE = "ApexTrigger.trigger";
    String APEX_TEST_CLASS_TEMPLATE = "ApexTestClass.cls";
    String APEX_ENUM = "ApexEnum.cls";
    String VISUALFORCE_PAGE_TEMPLATE = "VisualForcePage.page";
    String VISUALFORCE_COMPONENT_TEMPLATE = "VisualForceComponent.component";

}