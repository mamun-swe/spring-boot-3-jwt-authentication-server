package com.example.springboot3jwtauthenticationserver.config;

import com.example.springboot3jwtauthenticationserver.filters.ApiKeyFilter;
import com.example.springboot3jwtauthenticationserver.filters.LoggingFilter;
import com.example.springboot3jwtauthenticationserver.interceptors.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TestInterceptor testInterceptor;

    @Autowired
    private LoggingFilter loggingFilter;

    @Autowired
    private ApiKeyFilter apiKeyFilter;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor((HandlerInterceptor) loggingFilter);
        interceptorRegistry.addInterceptor((HandlerInterceptor) apiKeyFilter);
    }
}
