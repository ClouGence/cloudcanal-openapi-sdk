package com.clougence.cloudcanal.openapi.sdk.common;

import com.google.gson.Gson;

/**
 * @author bucketli 2021/11/10 13:32:21
 */
public class JsonRequest {

    public String toJson() {
        return new Gson().toJson(this);
    }
}
