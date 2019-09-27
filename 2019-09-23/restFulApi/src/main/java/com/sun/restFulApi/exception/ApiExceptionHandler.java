package com.sun.restFulApi.exception;


import com.sun.restFulApi.resource.ErrorResource;
import com.sun.restFulApi.resource.FieldResource;
import com.sun.restFulApi.resource.InvalidErrorResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 捕获全局异常
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public HttpEntity<?> handlerException(Exception e){
        logger.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceException.class)
    public HttpEntity<?> handleNotFound(ResourceException e) {
        ErrorResource errorResource = new ErrorResource(e.getMessage());
        logger.error(errorResource.toString());
        return new ResponseEntity<>(errorResource, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidException.class)
    public HttpEntity<?> handleInvalidRequest(InvalidException e) {
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            fieldResources.add(
                    new FieldResource(fieldError.getObjectName(),
                            fieldError.getField(),
                            fieldError.getCode(),
                            fieldError.getDefaultMessage())
            );
        }
        InvalidErrorResource invalidErrorResource = new InvalidErrorResource(e.getMessage(), fieldResources);
        logger.error(invalidErrorResource.toString());
        return new ResponseEntity<>(invalidErrorResource, HttpStatus.BAD_REQUEST);
    }


}
