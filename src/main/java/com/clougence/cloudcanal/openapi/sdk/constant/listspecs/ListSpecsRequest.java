package com.clougence.cloudcanal.openapi.sdk.constant.listspecs;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/17 17:45:46
 */
@Getter
@Setter
public class ListSpecsRequest extends JsonRequest {

    private String  dataJobType;

    private Boolean initialSync;

    private Boolean shortTermSync;
}
