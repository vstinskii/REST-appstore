package com.vitaliy.appstore.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

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

    @ExceptionHandler
    public ResponseEntity<ApplicationStackTrace> handleBadRequestException(NumberFormatException e) {

        ApplicationStackTrace stackTrace = new ApplicationStackTrace();

        stackTrace.setStatus(HttpStatus.BAD_REQUEST.value());
        stackTrace.setMessage("This request can only contain numbers");
        stackTrace.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stackTrace, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationStackTrace> handleBadParametersException(BadParametersException e) {

        ApplicationStackTrace stackTrace = new ApplicationStackTrace();

        stackTrace.setStatus(HttpStatus.BAD_REQUEST.value());
        stackTrace.setMessage(e.getMessage());
        stackTrace.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stackTrace, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ApplicationStackTrace> handleMethodArgumentNotValidException(ConstraintViolationException e) {

        ApplicationStackTrace stackTrace = new ApplicationStackTrace();

        stackTrace.setStatus(HttpStatus.BAD_REQUEST.value());

        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message.append(violation.getMessage().concat(";"));
        }

        stackTrace.setMessage(message.toString());
        stackTrace.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(stackTrace, HttpStatus.BAD_REQUEST);
    }
}
