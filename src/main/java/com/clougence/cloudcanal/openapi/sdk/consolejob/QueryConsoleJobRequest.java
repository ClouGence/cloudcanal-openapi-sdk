package com.clougence.cloudcanal.openapi.sdk.consolejob;

import com.clougence.cloudcanal.openapi.sdk.common.JsonRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 13:30:31
 */
@Getter
@Setter
public class QueryConsoleJobRequest extends JsonRequest {

    private Long consoleJobId;
}
