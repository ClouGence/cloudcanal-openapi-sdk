package com.clougence.cloudcanal.openapi.sdk.common.exception;

import com.clougence.cloudcanal.openapi.sdk.common.ErrorType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bucketli 2021/11/10 10:39:42
 */
@Getter
@Setter
public class ClientException extends Exception {

    private String    requestId;

    private String    errCode;

    private String    errMsg;

    private ErrorType errorType;

    private String    errorDescription;

    public ClientException(String errorCode, String errorMessage, String requestId, String errorDescription){
        this(errorCode, errorMessage);
        this.errorDescription = errorDescription;
        this.requestId = requestId;
    }

    public ClientException(String errCode, String errMsg, String requestId){
        this(errCode, errMsg);
        this.requestId = requestId;
        this.errorType = ErrorType.Client;
    }

    public ClientException(String errCode, String errMsg, Throwable cause){
        super(errCode + " : " + errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errorType = ErrorType.Client;
    }

    public ClientException(String errCode, String errMsg){
        super(errCode + " : " + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errorType = ErrorType.Client;
    }

    public ClientException(String message){
        super(message);
        this.errorType = ErrorType.Client;
    }

    public ClientException(Throwable cause){
        super(cause);
        this.errorType = ErrorType.Client;
    }
}
