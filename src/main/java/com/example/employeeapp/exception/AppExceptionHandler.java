package com.example.employeeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException exception) {
        return new ResponseEntity<>(
                new ApiError(exception.getMessage(), LocalDateTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> handleNotFoundException(NotFountException exception) {
        return new ResponseEntity<>(
                new ApiError(exception.getMessage(), LocalDateTime.now()),
                HttpStatus.NOT_FOUND);
    }
}
