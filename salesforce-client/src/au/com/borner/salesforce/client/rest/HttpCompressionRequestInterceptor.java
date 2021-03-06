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

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * @author mark
 */
public class HttpCompressionRequestInterceptor implements HttpRequestInterceptor {

    private static final String ACCEPT_ENCODING = "Accept-Encoding";
    private static final String ENCODING = "gzip,deflate";

    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        if (!request.containsHeader(ACCEPT_ENCODING)) {
            request.addHeader(ACCEPT_ENCODING, ENCODING);
        }
    }

}
