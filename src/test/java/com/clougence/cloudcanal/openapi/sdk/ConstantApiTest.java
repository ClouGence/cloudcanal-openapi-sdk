package com.clougence.cloudcanal.openapi.sdk;

import com.clougence.cloudcanal.openapi.sdk.constant.listspecs.ListSpecsRequest;
import com.clougence.cloudcanal.openapi.sdk.constant.listspecs.ListSpecsResponse;
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
            UserProfile profile = new UserProfile("127.0.0.1:8111", "akpv341h03z9e111322l4m233abj0ov6flk27539p5l2dkd807up2t967as4e8f", "skd7h61t62gxh3tv4sd1816nk0610u785u669b3mq0mg92avx1y47512yv15v6e");
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
