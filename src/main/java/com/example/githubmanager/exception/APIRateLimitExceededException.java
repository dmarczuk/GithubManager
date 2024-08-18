package com.example.githubmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class APIRateLimitExceededException extends RuntimeException {
    public APIRateLimitExceededException(String message) {
        super(message);
    }
}
