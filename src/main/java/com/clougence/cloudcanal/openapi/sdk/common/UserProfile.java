package com.clougence.cloudcanal.openapi.sdk.common;

import org.apache.commons.lang3.StringUtils;

import com.clougence.cloudcanal.openapi.sdk.common.exception.ClientException;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 11:22:12
 */
@Getter
@Setter
public class UserProfile {

    private String accessKey;

    private String secretKey;

    private String signature;

    private String apiHost;

    public UserProfile(String apiHost, String accessKey, String secretKey){
        this.apiHost = apiHost;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public CcClient genClient() throws ClientException {
        if (StringUtils.isBlank(apiHost)) {
            throw new ClientException("apiHost is empty.");
        }

        if (StringUtils.isBlank(accessKey) || StringUtils.isBlank(secretKey)) {
            throw new ClientException("accessKey or secretKey is empty.");
        }

        return new HttpCcClient(apiHost, accessKey, secretKey);
    }
}
