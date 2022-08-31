package com.test.microservice.config.exception;

public class ConflictException extends IntegrationException {

    private static final int HTTP_CODE = 409;

    public ConflictException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
