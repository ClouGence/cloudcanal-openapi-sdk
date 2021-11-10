package com.clougence.cloudcanal.openapi.sdk.cluster;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 12:57:06
 */
@Getter
@Setter
public class ListClusterRequest extends JsonRequest {

    private String cloudOrIdcName;

    private String clusterDescLike;

    private String clusterNameLike;

    private String region;
}
