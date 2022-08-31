package com.test.microservice.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IntegrationException extends RuntimeException {

    private static final int HTTP_CODE = 999;

    protected String errorCode;
    protected String errorMessage;
}
