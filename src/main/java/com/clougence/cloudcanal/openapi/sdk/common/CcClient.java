package com.clougence.cloudcanal.openapi.sdk.common;

import com.clougence.cloudcanal.openapi.sdk.common.exception.ClientException;
import com.clougence.cloudcanal.openapi.sdk.common.exception.ServerException;

/**
 * @author bucketli 2021/11/10 09:52:01
 */
public interface CcClient {

    String doJsonPost(String uri, String content) throws ClientException, ServerException;
}
