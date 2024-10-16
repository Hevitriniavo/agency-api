package com.fresh.coding.agencyapi.exceptions;

public class BeanMappingException extends RuntimeException {
    public BeanMappingException(String message) {
        super(message);
    }

    public BeanMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
