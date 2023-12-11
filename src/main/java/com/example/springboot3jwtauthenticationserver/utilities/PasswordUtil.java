package com.example.springboot3jwtauthenticationserver.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

    public Boolean passwordCompare(String plain_password, String hash_password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (bcrypt.matches(plain_password, hash_password)) {
            return true;
        }
        return false;
    }
}
