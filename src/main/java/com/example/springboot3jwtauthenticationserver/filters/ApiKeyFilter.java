package com.example.springboot3jwtauthenticationserver.filters;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    /**
     * ENVIRONMENT X_API_KEY
     **/
    @Value("${apiKey}")
    private String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestApiKey = request.getHeader("x-api-key");

        if (requestApiKey == null || requestApiKey.isBlank() || requestApiKey.isEmpty()) {
            /** Set content type to JSON **/
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            /** Create a JSON response **/
            String message = "{\"message\": \"API Key.\",\"errors\": {\"x-api-key\": \"API Key is required.\"},\"status\": \"UNAUTHORIZED\"}";

            /** Write the JSON response to the output stream **/
            PrintWriter out = response.getWriter();
            out.write(message);
            out.flush();
        } else if (!requestApiKey.equals(this.apiKey)) {
            /** Set content type to JSON **/
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            /** Create a JSON response **/
            String message = "{\"message\": \"API Key.\",\"errors\": {\"x-api-key\": \"Invalid API Key.\"},\"status\": \"UNAUTHORIZED\"}";

            /** Write the JSON response to the output stream **/
            PrintWriter out = response.getWriter();
            out.write(message);
            out.flush();
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
