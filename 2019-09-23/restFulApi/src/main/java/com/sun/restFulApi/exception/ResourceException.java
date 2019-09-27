package com.sun.restFulApi.exception;

import java.util.function.Supplier;

/**
 *
 * @author zcm
 */
public class ResourceException extends RuntimeException{

    public ResourceException(String message){
        super(message);
    }

}
