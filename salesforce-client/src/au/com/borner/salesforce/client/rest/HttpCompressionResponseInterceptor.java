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

package au.com.borner.salesforce.client.rest;

import org.apache.http.*;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * @author mark
 */
public class HttpCompressionResponseInterceptor implements HttpResponseInterceptor {

    private static final String GZIP = "gzip";
    private static final String DEFLATE = "deflate";

    @Override
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                HeaderElement[] codecs = contentEncoding.getElements();
                for (HeaderElement codec : codecs) {
                    if (codec.getName().equalsIgnoreCase(GZIP)) {
                        response.setEntity(new GzipDecompressingEntity(response.getEntity()));
                        return;
                    }
                    if (codec.getName().equalsIgnoreCase(DEFLATE)) {
                        response.setEntity(new DeflateDecompressingEntity(response.getEntity()));
                        return;
                    }
                }
            }
        }
    }

}
