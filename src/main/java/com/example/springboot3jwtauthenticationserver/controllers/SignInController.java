package com.example.springboot3jwtauthenticationserver.controllers;

import com.example.springboot3jwtauthenticationserver.dto.SigningRequest;
import com.example.springboot3jwtauthenticationserver.exceptions.Response;
import com.example.springboot3jwtauthenticationserver.models.User;
import com.example.springboot3jwtauthenticationserver.services.UserService;
import com.example.springboot3jwtauthenticationserver.utilities.JwtUtil;
import com.example.springboot3jwtauthenticationserver.utilities.PasswordUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/signing")
public class SignInController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordUtil passwordUtil;
//    private JwtUtil jwtUtil;

    @PostMapping()
    ResponseEntity<Object> signing(@Valid @RequestBody SigningRequest reqBody) {
        try {
            /** find available user using email **/
            Optional<User> availableUser = this.userService.getUserByEmail(reqBody.getEmail());
            if (!availableUser.isPresent()) {
                Map<String, String> errors = new HashMap<>();
                errors.put("credentials", "Wrong credentials.");
                return Response.Error(HttpStatus.CONFLICT, "Failed.", errors);
            }

            /** Match plain password with hash password **/
            Boolean isPasswordMatches = this.passwordUtil.passwordCompare(reqBody.getPassword(), availableUser.get().getPassword());
            if (!isPasswordMatches) {
                Map<String, String> errors = new HashMap<>();
                errors.put("credentials", "Wrong credentials.");
                return Response.Error(HttpStatus.CONFLICT, "Failed.", errors);
            }

            /** JWT Access token will generate below **/
//            String accessToken = jwtUtil.generateToken(availableUser.get().getId(), availableUser.get().getName(), availableUser.get().getEmail());

            return Response.Success(HttpStatus.OK, "Successfully logged into account.", "Hello");
        } catch (Exception e) {
            return Response.InternalServerError();
        }
    }
}
