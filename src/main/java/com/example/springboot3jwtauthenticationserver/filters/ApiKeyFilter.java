package com.example.springboot3jwtauthenticationserver.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiKeyFilter extends OncePerRequestFilter {
    private static final String X_API_KEY = "12345678";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("x-api-key");

        if (apiKey != null && apiKey.equals(X_API_KEY)) {
            filterChain.doFilter(request, response);
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("x-api-key", "Given API Key isn't valid.");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid API Key");
        }
    }
}
