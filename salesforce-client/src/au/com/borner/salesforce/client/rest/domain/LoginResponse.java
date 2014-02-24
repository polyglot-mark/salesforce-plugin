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

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * A Login response JSON object
 *
 * @author mark
 */
public class LoginResponse extends AbstractJSONObject {

    private static final String ALGORITHM = "HMACSHA256";

    public LoginResponse(String json) throws JSONException {
        super(json);
    }

    public String getIdUrl() {
        // see below for what we can get with an id
        return getString("id");
    }

    public String getIssuedAt() {
        return getString("issued_at");
    }

    public String getInstanceUrl() {
        return getString("instance_url");
    }

    public String getSignature() {
        return getString("signature");
    }


    public String getInstanceHost() {
        return getInstanceUrl().replace("https://", "");
    }

    public String getToken() {
        return getString("access_token");
    }

    public void verify(String consumerSecret) {
        SecretKey hmacKey = null;
        try {
            byte[] key = consumerSecret.getBytes();
            hmacKey = new SecretKeySpec(key, ALGORITHM);
            Mac mac = Mac.getInstance(ALGORITHM);
            mac.init(hmacKey);
            byte[] digest = mac.doFinal((getIdUrl() + getIssuedAt()).getBytes());
            byte[] decode_sig = new Base64(true).decode(getSignature());
            if (! Arrays.equals(digest, decode_sig)) {
                throw new SecurityException("Signature could not be verified!");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException(String.format("Algorithm not found while trying to verifying signature: algorithm=%s; message=%s", ALGORITHM, e.getMessage()), e);
        } catch (InvalidKeyException e) {
            throw new SecurityException(String.format("Invalid key encountered while trying to verify signature: key=%s; message=%s", hmacKey, e.getMessage()), e);
        }    }

    /*
    {
	"id":"https://login.salesforce.com/id/00D50000000IZ3ZEAW/00550000001fg5OAAQ",
	"asserted_user":true,
	"user_id":"00550000001fg5OAAQ",
	"organization_id":"00D50000000IZ3ZEAW",
	"username":"user@example.com",
	"nick_name":"user1.2950476911907334E12",
	"display_name":"Sample User",
	"email":"user@example.com",
	"status":{
		"created_date":"2010-11-08T20:55:33.000+0000",
		"body":"Working on OAuth 2.0 article"
	},
	"photos":{
		"picture":"https://c.na1.content.force.com/profilephoto/005/F",
		"thumbnail":"https://c.na1.content.force.com/profilephoto/005/T"
	},
	"urls":{
		"enterprise":"https://na1.salesforce.com/services/Soap/c/{version}/00D50000000IZ3Z",
		"metadata":"https://na1.salesforce.com/services/Soap/m/{version}/00D50000000IZ3Z",
		"partner":"https://na1.salesforce.com/services/Soap/u/{version}/00D50000000IZ3Z",
		"rest":"https://na1.salesforce.com/services/data/v{version}/",
		"sobjects":"https://na1.salesforce.com/services/data/v{version}/sobjects/",
		"search":"https://na1.salesforce.com/services/data/v{version}/search/",
		"query":"https://na1.salesforce.com/services/data/v{version}/query/",
		"recent":"https://na1.salesforce.com/services/data/v{version}/recent/",
		"profile":"https://na1.salesforce.com/00550000001fg5OAAQ"
	},
	"active":true,
	"user_type":"STANDARD",
	"language":"en_US",
	"locale":"en_US",
	"utcOffset":-28800000,
	"last_modified_date":"2011-01-14T23:28:01.000+0000"
}

     */
}
