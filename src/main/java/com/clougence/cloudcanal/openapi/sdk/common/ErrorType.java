package com.clougence.cloudcanal.openapi.sdk.common;

/**
 * @author bucketli 2021/11/10 13:00:42
 */
public enum ErrorType {
    // 客户端异常
    Client,

    // 服务端异常
    Server,

    // 限流
    Throttling,

    // default
    Unknown,
}
