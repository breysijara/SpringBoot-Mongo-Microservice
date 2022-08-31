package com.test.microservice.config.exception;

public class NotFoundException extends IntegrationException {

    private static final int HTTP_CODE = 404;

    public NotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
