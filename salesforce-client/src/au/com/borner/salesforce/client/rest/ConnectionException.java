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

import au.com.borner.salesforce.client.rest.domain.ErrorsResponse;

/**
 * A Connection Exception is thrown when a communication error occurs
 *
 * @author mark
 */
public class ConnectionException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Errors: %s; HTTP Status: %d";

    public ConnectionException(ErrorsResponse errorsResponse, int statusCode, String defaultMessage) {
        super(errorsResponse == null ? String.format(MESSAGE_FORMAT, defaultMessage, statusCode)  : String.format(MESSAGE_FORMAT, errorsResponse.toString(), statusCode));
    }

    public ConnectionException() {
    }

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
