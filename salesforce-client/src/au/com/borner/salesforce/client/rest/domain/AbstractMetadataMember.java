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

package au.com.borner.salesforce.client.rest.domain;

/**
 * An abstract Metadata member which is the super class for all
 * Metadata Member classes
 *
 * @author mark
 */
public abstract class AbstractMetadataMember extends AbstractIdentifiableJSONObject {

    public AbstractMetadataMember(MetadataContainer metadataContainer) {
        super();
        put("MetadataContainerId", metadataContainer.getId());
    }

    public void setBody(String body) {
        put("Body", body);
    }

    public void setContentEntityId(String apexClassId) {
        put("ContentEntityId", apexClassId);
    }

}
