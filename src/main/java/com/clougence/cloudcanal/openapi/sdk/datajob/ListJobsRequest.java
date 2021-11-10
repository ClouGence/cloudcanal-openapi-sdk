package com.clougence.cloudcanal.openapi.sdk.datajob;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 13:37:06
 */
@Getter
@Setter
public class ListJobsRequest extends JsonRequest {

    private String dataJobName;

    private String dataJobType;

    private String desc;

    private Long   sourceInstanceId;

    private Long   targetInstanceId;
}
