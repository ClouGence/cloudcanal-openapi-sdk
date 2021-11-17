package com.clougence.cloudcanal.openapi.sdk;

import com.clougence.cloudcanal.openapi.sdk.constant.ListSpecsRequest;
import com.clougence.cloudcanal.openapi.sdk.constant.ListSpecsResponse;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import com.clougence.cloudcanal.openapi.sdk.common.CcClient;
import com.clougence.cloudcanal.openapi.sdk.common.UserProfile;

/**
 * @author bucketli 2021/11/17 17:48:18
 */
public class ConstantApiTest {

    @Test
    public void testListSpecifications() {
        try {
            UserProfile profile = new UserProfile("127.0.0.1:8111", "your ak from cloudcanal", "your sk from cloudcanal");
            CcClient client = profile.genClient();
            ListSpecsRequest request = new ListSpecsRequest();
            request.setDataJobType("SYNC");
            String paramStr = request.toJson();
            String result = client.doJsonPost("/cloudcanal/console/api/v1/openapi/constant/listspecs", paramStr);
            System.out.println(result);
            ListSpecsResponse response = new Gson().fromJson(result, ListSpecsResponse.class);
            Assert.assertNotNull(response);
        } catch (Exception e) {
            throw new RuntimeException("api failed.", e);
        }
    }
}
