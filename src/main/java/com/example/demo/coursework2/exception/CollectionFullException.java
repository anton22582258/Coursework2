package com.example.demo.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CollectionFullException extends RuntimeException {
    public CollectionFullException() {
    }

    public CollectionFullException(String message) {
        super(message);
    }

    public CollectionFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollectionFullException(Throwable cause) {
        super(cause);
    }

    public CollectionFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
