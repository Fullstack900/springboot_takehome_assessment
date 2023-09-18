package com.assessment.takehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TakeHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakeHomeApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("*")
						.allowedOrigins("*:5173");
				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}
}
