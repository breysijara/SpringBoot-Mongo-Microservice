package com.test.microservice.config.exception;

public class BadRequestException extends IntegrationException{

    private static final int HTTP_CODE = 400;

    public BadRequestException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
