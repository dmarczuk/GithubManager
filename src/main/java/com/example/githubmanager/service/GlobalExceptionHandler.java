package com.example.githubmanager.service;

import com.example.githubmanager.error.ErrorResponse;
import com.example.githubmanager.exception.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("${" + HttpStatus.NOT_FOUND.value() + "}", "${"+ e.getMessage() + "}");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
