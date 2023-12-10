package com.example.springboot3jwtauthenticationserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {
    /**
     * Success response only for status & message
     */
    public static ResponseEntity<Object> Success(HttpStatus status, String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("message", message);

        return new ResponseEntity<Object>(map, status);
    }

    /**
     * Success response with status, message & data
     */
    public static ResponseEntity<Object> Success(HttpStatus status, String message, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("message", message);
        map.put("data", data);

        return new ResponseEntity<Object>(map, status);
    }

    /**
     * Error response with status, message & errors
     */
    public static ResponseEntity<Object> Error(HttpStatus status, String message, Map<String, String> errors) {
        Map<String, String> errorMap = new HashMap<>();
        Map<String, Object> map = new HashMap<String, Object>();

        errors.forEach((fieldName, errorMessage) -> {
            errorMap.put(fieldName, errorMessage);
        });

        map.put("status", status);
        map.put("message", message);
        map.put("errors", errorMap);

        return new ResponseEntity<Object>(map, status);
    }

    /**
     * Error response for internal server error
     */
    public static ResponseEntity<Object> InternalServerError() {
        Map<String, String> errors = new HashMap<>();
        errors.put("server", "Something going wrong.");

        return new ResponseEntity<Object>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
