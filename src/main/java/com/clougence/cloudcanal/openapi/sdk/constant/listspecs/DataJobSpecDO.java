package com.clougence.cloudcanal.openapi.sdk.constant.listspecs;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/17 17:52:50
 */
@Getter
@Setter
public class DataJobSpecDO {

    private Long   id;

    private String specKind;

    private String specKindCn;

    private String spec;

    private String description;

    private int    fullMemoryMb;

    private int    increMemoryMb;

    private int    checkMemoryMb;
}
