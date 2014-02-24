package au.com.borner.salesforce.plugin.service;

import au.com.borner.salesforce.client.rest.domain.APIVersionResult;

import java.util.*;

/**
 * Versions Service which queries the Salesforce instance for the
 * available API versions and caches them for future use
 *
 * @author mark
 */
public class VersionsService  {

    private final ClientFactoryService clientFactoryService;

    private List<APIVersionResult> apiVersionResults;
    private APIVersionResult latestVersion;

    public VersionsService(ClientFactoryService clientFactoryService) {
        this.clientFactoryService = clientFactoryService;
    }

    public List<APIVersionResult> getApiVersions() {
        if (apiVersionResults == null) {
            apiVersionResults = clientFactoryService.getDataClient().getVersions();
            Collections.sort(apiVersionResults, new Comparator<APIVersionResult>() {
                @Override
                public int compare(APIVersionResult o1, APIVersionResult o2) {
                    return o1.getAPIVersion().compareTo(o2.getAPIVersion());
                }
            });
            latestVersion = apiVersionResults.get(apiVersionResults.size() - 1);
        }
        return apiVersionResults;
    }

    public APIVersionResult getLatestVersion() {
        if (latestVersion == null) {
            getApiVersions();
        }
        return latestVersion;
    }


}
