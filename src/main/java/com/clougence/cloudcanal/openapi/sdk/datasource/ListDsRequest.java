package com.clougence.cloudcanal.openapi.sdk.datasource;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 13:39:17
 */
@Getter
@Setter
public class ListDsRequest extends JsonRequest {

    private String deployType;

    private String hostType;

    private String lifeCycleState;

    private String type;
}
