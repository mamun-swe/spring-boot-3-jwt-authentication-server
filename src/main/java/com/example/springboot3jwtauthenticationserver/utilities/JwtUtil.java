package com.example.springboot3jwtauthenticationserver.utilities;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET = "your-secret-key";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static String generateToken(String username) {
        return username;
    }
}
