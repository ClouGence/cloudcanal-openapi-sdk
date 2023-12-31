package com.clougence.cloudcanal.openapi.sdk;

import org.junit.Test;

import com.clougence.cloudcanal.openapi.sdk.cluster.ListClusterRequest;
import com.clougence.cloudcanal.openapi.sdk.common.CcClient;
import com.clougence.cloudcanal.openapi.sdk.common.UserProfile;

/**
 * @author bucketli 2021/11/10 11:44:05
 */
public class ClusterApiTest {

    @Test
    public void testListCluster() {
        try {
            UserProfile profile = new UserProfile("127.0.0.1:8111", "your ak from cloudcanal", "your sk from cloudcanal");
            CcClient client = profile.genClient();
            ListClusterRequest request = new ListClusterRequest();
            String paramStr = request.toJson();
            String result = client.doJsonPost("/cloudcanal/console/api/v1/openapi/cluster/listclusters", paramStr);
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException("api failed.", e);
        }
    }
}
