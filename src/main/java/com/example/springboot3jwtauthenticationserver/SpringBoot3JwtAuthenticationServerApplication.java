package com.example.springboot3jwtauthenticationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@RestController
public class SpringBoot3JwtAuthenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3JwtAuthenticationServerApplication.class, args);
	}

	@GetMapping()
	public String index(){
		return "Welcome!";
	}

}
