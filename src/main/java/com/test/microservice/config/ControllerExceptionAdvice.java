package com.test.microservice.config;

import com.test.microservice.config.exception.ConflictException;
import com.test.microservice.config.exception.IntegrationException;
import com.test.microservice.config.exception.NotFoundException;
import com.test.microservice.dto.exception.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ExceptionDto notFoundException(NotFoundException e) {
        log.error("Ocurrió un error en la aplicación, HTTP_CODE: " + HttpStatus.NOT_FOUND);
        return buildExceptionDto(e);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    private ExceptionDto conflictException(ConflictException e) {
        log.error("Ocurrió un error en la aplicación, HTTP_CODE: " + HttpStatus.CONFLICT);
        return buildExceptionDto(e);
    }

    private ExceptionDto buildExceptionDto(IntegrationException e) {
        return ExceptionDto.builder().errorCode(e.getErrorCode()).errorMessage(e.getErrorMessage()).build();
    }
}
