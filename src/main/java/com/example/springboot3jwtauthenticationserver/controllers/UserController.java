package com.example.springboot3jwtauthenticationserver.controllers;


import com.example.springboot3jwtauthenticationserver.dto.UserSignUpRequest;
import com.example.springboot3jwtauthenticationserver.dto.UserUpdateRequest;
import com.example.springboot3jwtauthenticationserver.exceptions.Response;
import com.example.springboot3jwtauthenticationserver.models.User;
import com.example.springboot3jwtauthenticationserver.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Display the list of resources
     **/
    @GetMapping()
    ResponseEntity<Object> index() {
        try {
            List<User> data = this.userService.getUsers();
            return Response.Success(HttpStatus.OK, "List of users.", data);
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

    /**
     * Create new resource
     **/
    @PostMapping()
    ResponseEntity<Object> store(@Valid @RequestBody UserSignUpRequest reqBody) {
        try {
            Optional<User> availableWithEmail = this.userService.getUserByEmail(reqBody.getEmail());
            if (availableWithEmail.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("email", "Email already taken.");
                return Response.Error(HttpStatus.CONFLICT, "Email exist.", errors);
            }

            this.userService.createUser(reqBody);

            return Response.Success(HttpStatus.CREATED, "Users created.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

    /**
     * Display the specific resource
     **/
    @GetMapping("{id}")
    ResponseEntity<Object> show(@PathVariable(name = "id", required = true) Long id) {
        try {
            Optional<User> data = this.userService.getUserById(id);

            return Response.Success(HttpStatus.OK, "User information.", data);
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

    /**
     * Update specific resource
     **/
    @PutMapping("{id}")
    ResponseEntity<Object> update(@Valid @RequestBody UserUpdateRequest reqBody, @PathVariable(name = "id", required = true) Long id) {
        try {
            Optional<User> availableUser = this.userService.getUserById(id);
            if (!availableUser.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("user", "User not available.");
                return Response.Error(HttpStatus.NOT_FOUND, "Not found.", errors);
            }

            /** Check unique email **/
            Optional<User> uniqueEmail = this.userService.getUniqueEmailById(id, reqBody.getEmail());
            if (uniqueEmail.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("email", "Email already taken.");
                return Response.Error(HttpStatus.CONFLICT, "Email exist.", errors);
            }

            this.userService.updateUser(id, reqBody);
            return Response.Success(HttpStatus.OK, "User updated.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }

    /**
     * Destroy specific resource
     **/
    @DeleteMapping("{id}")
    ResponseEntity<Object> destroy(@PathVariable(name = "id", required = true) Long id) {
        try {
            Optional<User> availableUser = this.userService.getUserById(id);
            if (!availableUser.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("user", "User not available.");
                return Response.Error(HttpStatus.NOT_FOUND, "Not found.", errors);
            }

            this.userService.destroyUser(id);
            return Response.Success(HttpStatus.OK, "User destroyed.");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }
}
