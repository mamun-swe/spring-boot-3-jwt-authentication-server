package com.example.springboot3jwtauthenticationserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandeller {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        Map<String, Object> errorResponseMap = new HashMap<String, Object>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        errorResponseMap.put("status", HttpStatus.BAD_REQUEST);
        errorResponseMap.put("message", "Validation required.");
        errorResponseMap.put("errors", errors);

        return new ResponseEntity<Object>(errorResponseMap, HttpStatus.BAD_REQUEST);
    }
}
