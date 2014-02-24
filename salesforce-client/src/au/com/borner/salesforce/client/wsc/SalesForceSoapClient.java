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

package au.com.borner.salesforce.client.wsc;

import com.sforce.soap.apex.*;
import com.sforce.soap.apex.RunTestsResult;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.metadata.*;
import com.sforce.soap.metadata.Package;
import com.sforce.soap.tooling.*;
import com.sforce.soap.tooling.LogCategory;
import com.sforce.soap.tooling.LogCategoryLevel;
import com.sforce.soap.tooling.LogInfo;
import com.sforce.soap.tooling.LogType;
import com.sforce.ws.ConnectorConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mark
 */
public class SalesForceSoapClient {

    private EnterpriseConnection enterpriseConnection;
    private MetadataConnection metadataConnection;
    private com.sforce.soap.apex.SoapConnection apexConnection;
    private com.sforce.soap.tooling.SoapConnection toolingConnection;

    public static void main(String[] args) throws Exception {
        SalesForceSoapClient client = new SalesForceSoapClient();
        client.login("mark.borner@zurich.com.au", "steven01", "xmakUlIARIWoa8KHLATy09bD");
        client.toolingExecuteAnonymous();
        client.getLogBody();
    }

    private void login(String username, String password, String securityToken) throws Exception {
        ConnectorConfig loginConfig = createConnectorConfig(username, password, securityToken);
        enterpriseConnection = com.sforce.soap.enterprise.Connector.newConnection(loginConfig);

        ConnectorConfig metadataConfig = createConnectorConfig(username, password, securityToken);
        metadataConfig.setSessionId(enterpriseConnection.getConfig().getSessionId());
        metadataConfig.setServiceEndpoint(enterpriseConnection.getConfig().getServiceEndpoint().replace("services/Soap/c", "services/Soap/m"));
        metadataConnection = com.sforce.soap.metadata.Connector.newConnection(metadataConfig);

        ConnectorConfig apexConfig = createConnectorConfig(username, password, securityToken);
        apexConfig.setSessionId(enterpriseConnection.getConfig().getSessionId());
        apexConfig.setServiceEndpoint(enterpriseConnection.getConfig().getServiceEndpoint().replace("services/Soap/c", "services/Soap/s"));
        apexConnection = com.sforce.soap.apex.Connector.newConnection(apexConfig);

        ConnectorConfig toolingConfig = createConnectorConfig(username, password, securityToken);
        toolingConfig.setSessionId(enterpriseConnection.getConfig().getSessionId());
        toolingConfig.setServiceEndpoint(enterpriseConnection.getConfig().getServiceEndpoint().replace("services/Soap/c", "services/Soap/T"));
        toolingConnection = com.sforce.soap.tooling.Connector.newConnection(toolingConfig);
    }

    private ConnectorConfig createConnectorConfig(String username, String password, String securityToken) {
        if (securityToken == null) securityToken = "";
        ConnectorConfig result = new ConnectorConfig();
        result.setCompression(true);
        result.setTraceMessage(true);
        result.setUsername(username);
        result.setPassword(password + securityToken);
        result.setAuthEndpoint("https://login.salesforce.com/services/Soap/c/29.0");
        return result;
    }

    // Apex Connector

    private void apexCompileClasses() throws Exception {
        // Compiles and saves class
        CompileClassResult[] results = apexConnection.compileClasses(new String[]{"public interface mark {}"});
        System.out.println("Results: " + Arrays.asList(results));
    }

    private void apexCompileAndTest() throws Exception {
        CompileAndTestRequest request = new CompileAndTestRequest();
        request.setClasses(new String[] { "public interface mark {}" });
        request.setCheckOnly(true);
        RunTestsRequest runTestsRequest = new RunTestsRequest();
        runTestsRequest.setAllTests(true);
        request.setRunTestsRequest(runTestsRequest);
        CompileAndTestResult result = apexConnection.compileAndTest(request);
        System.out.println("Result: " + result);
    }

    private void apexRunTests() throws Exception {
        RunTestsRequest runTestsRequest = new RunTestsRequest();
        runTestsRequest.setAllTests(true);
        RunTestsResult result = apexConnection.runTests(runTestsRequest);
        System.out.println(result);
    }

    // Metadata Connector

    private byte[] metadataRetrieve(boolean apexClasses, boolean apexTriggers, boolean visualForcePages, boolean visualForceComponents) throws Exception {
        RetrieveRequest request = new RetrieveRequest();
        com.sforce.soap.metadata.Package _package = new Package();
        List<PackageTypeMembers> packageTypeMembers = new ArrayList<PackageTypeMembers>();
        if (apexClasses) {
            packageTypeMembers.add(createPackageTypeMembers("ApexClass", "*"));
        }
        if (apexTriggers) {
            packageTypeMembers.add(createPackageTypeMembers("ApexTrigger", "*"));
        }
        if (visualForcePages) {
            packageTypeMembers.add(createPackageTypeMembers("ApexPage", "*"));
        }
        if (visualForceComponents) {
            packageTypeMembers.add(createPackageTypeMembers("ApexComponent", "*"));
        }
        _package.setTypes(packageTypeMembers.toArray(new PackageTypeMembers[packageTypeMembers.size()]));
        request.setUnpackaged(_package);
        request.setApiVersion(29.0);
        AsyncResult asyncResult = metadataConnection.retrieve(request);
        while (!asyncResult.isDone()) {
            try { Thread.sleep(500); } catch (Exception e) { /* do nothing */ }
            asyncResult = metadataConnection.checkStatus(new String[] { asyncResult.getId() })[0];
        }
        RetrieveResult result = metadataConnection.checkRetrieveStatus(asyncResult.getId());
        return result.getZipFile();
    }

    private PackageTypeMembers createPackageTypeMembers(String name, String... members) {
        PackageTypeMembers result = new PackageTypeMembers();
        result.setName(name);
        result.setMembers(members);
        return result;
    }

    private void metadataDeploy(byte[] zipFile) throws Exception {
        DeployOptions deployOptions = new DeployOptions();
        deployOptions.setCheckOnly(true);
        deployOptions.setRunAllTests(true);
        AsyncResult asyncResult = metadataConnection.deploy(zipFile, deployOptions);
        while (!asyncResult.isDone()) {
            try { Thread.sleep(500); } catch (Exception e) { /* do nothing */ }
            asyncResult = metadataConnection.checkStatus(new String[] { asyncResult.getId() })[0];
        }
        DeployResult deployResult = metadataConnection.checkDeployStatus(asyncResult.getId(), true);
        System.out.println("Result : " + deployResult);
    }

    // Tooling Connector

    public void toolingExecuteAnonymous() throws Exception {
        LogInfo logInfo = new LogInfo();
        logInfo.setCategory(LogCategory.All);
        logInfo.setLevel(LogCategoryLevel.Finest);
        LogInfo[] logInfos = { logInfo };
        toolingConnection.setDebuggingHeader(logInfos, LogType.Detail);
        com.sforce.soap.tooling.ExecuteAnonymousResult result = toolingConnection.executeAnonymous("System.debug('Hello World');");
        System.out.println("Result: " + result);
    }

    public void getLog() throws Exception {
        QueryResult result = toolingConnection.query("select Id, LogUserId, LogLength, Request, Operation, Application, Status, StartTime, Location from ApexLog");
        System.out.println("Result: " + result);
    }

    private static final String FILE_DOWNLOAD = "/servlet/servlet.FileDownload?file=";
    public void getLogBody() throws Exception {
//        String accessToken = sessionProvider.getAccessToken();
//        String apiEndpoint = sessionProvider.getApiEndpoint();
//
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet get = new HttpGet(apiEndpoint + FILE_DOWNLOAD + id);
//
//// set the cookie
//        HttpContext context = new BasicHttpContext();
//        CookieStore cookieStore = new BasicCookieStore();
//        BasicClientCookie cookie = new BasicClientCookie("sid", accessToken);
//
//        try {
//            cookie.setDomain((new URI(apiEndpoint)).getHost());
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//            return null;
//        }
//        cookie.setPath("/");
//
//        cookieStore.addCookie(cookie);
//        context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//
//        logger.trace("ToolingApi.getFile id: " + id);
//
//        HttpResponse response = httpclient.execute(get, context);
    }



}
