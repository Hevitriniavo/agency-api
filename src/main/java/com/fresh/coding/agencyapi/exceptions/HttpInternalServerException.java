package com.fresh.coding.agencyapi.exceptions;

public class HttpInternalServerException extends RuntimeException {
    public HttpInternalServerException(String message) {
        super(message);
    }
}
