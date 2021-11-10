package com.clougence.cloudcanal.openapi.sdk.common.exception;

import com.clougence.cloudcanal.openapi.sdk.common.ErrorType;

/**
 * @author bucketli 2021/11/10 12:24:24
 */
public class ServerException extends Exception {

    private String    requestId;

    private String    errCode;

    private String    errMsg;

    private ErrorType errorType;

    private String    errorDescription;

    public ServerException(String errorCode, String errorMessage, String requestId, String errorDescription){
        this(errorCode, errorMessage);
        this.errorDescription = errorDescription;
        this.requestId = requestId;
    }

    public ServerException(String errCode, String errMsg, String requestId){
        this(errCode, errMsg);
        this.requestId = requestId;
        this.errorType = ErrorType.Server;
    }

    public ServerException(String errCode, String errMsg, Throwable cause){
        super(errCode + " : " + errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errorType = ErrorType.Server;
    }

    public ServerException(String errCode, String errMsg){
        super(errCode + " : " + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.errorType = ErrorType.Server;
    }

    public ServerException(String message){
        super(message);
        this.errorType = ErrorType.Server;
    }

    public ServerException(Throwable cause){
        super(cause);
        this.errorType = ErrorType.Server;
    }
}
