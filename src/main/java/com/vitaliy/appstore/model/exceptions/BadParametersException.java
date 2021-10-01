package com.vitaliy.appstore.model.exceptions;

public class BadParametersException extends RuntimeException {

    public BadParametersException(String message) {
        super(message);
    }

    public BadParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadParametersException(Throwable cause) {
        super(cause);
    }
}
