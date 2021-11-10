package com.clougence.cloudcanal.openapi.sdk.cluster;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 12:57:06
 */
@Getter
@Setter
public class ListClusterRequest {

    private String cloudOrIdcName;

    private String clusterDescLike;

    private String clusterNameLike;

    private String region;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
