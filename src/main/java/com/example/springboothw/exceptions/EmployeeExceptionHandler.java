package com.example.springboothw.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MessageException> handleException(EmployeeException exception) {
        MessageException message = new MessageException();
        message.setMessage(exception.getMessage());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}