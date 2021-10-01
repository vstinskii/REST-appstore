package com.vitaliy.appstore.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApplicationStackTrace> handleApplicationNotFoundException(ApplicationNotFoundException e) {

        ApplicationStackTrace stackTrace = new ApplicationStackTrace();

        stackTrace.setStatus(HttpStatus.NOT_FOUND.value());
        stackTrace.setMessage(e.getMessage());
        stackTrace.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stackTrace, HttpStatus.NOT_FOUND);
    }


}
