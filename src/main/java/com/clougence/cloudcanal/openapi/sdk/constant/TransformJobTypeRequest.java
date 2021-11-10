package com.clougence.cloudcanal.openapi.sdk.constant;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 13:31:41
 */
@Getter
@Setter
public class TransformJobTypeRequest extends JsonRequest {

    private String sourceType;

    private String targetType;
}
