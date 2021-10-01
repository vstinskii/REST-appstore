package com.vitaliy.appstore.model.exceptions;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }

    public ApplicationNotFoundException(String message) {
        super(message);
    }

    public ApplicationNotFoundException(Throwable cause) {
        super(cause);
    }
}
