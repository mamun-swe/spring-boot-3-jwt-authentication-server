package com.example.springboot3jwtauthenticationserver.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Log the incoming request details
        System.out.println("Logging Filter - " +
                "Incoming request from " + request.getRemoteAddr() +
                " for " + ((HttpServletRequest) request).getRequestURI());

        // Proceed with the request chain
        chain.doFilter(request, response);
    }

    // Other methods of the Filter interface
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
