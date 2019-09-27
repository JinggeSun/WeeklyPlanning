package com.sun.restFulApi.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

/**
 * @author zcm
 */
public class InvalidException extends RuntimeException{

    @Getter
    private Errors errors;


    public InvalidException(String message, Errors errors){
        super(message);
        this.errors = errors;
    }

    public InvalidException(Errors errors){
        this.errors = errors;
    }

}
