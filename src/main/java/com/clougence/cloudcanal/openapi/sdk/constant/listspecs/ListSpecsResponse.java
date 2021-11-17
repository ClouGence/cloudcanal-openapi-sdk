package com.clougence.cloudcanal.openapi.sdk.constant.listspecs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/17 17:52:09
 */
@Getter
@Setter
public class ListSpecsResponse {

    private String              code;

    private String              msg;

    private List<DataJobSpecDO> data;
}
