package com.shaibal.web.mvc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.shaibal.airline.management")
public class WebApplicationInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebApplicationInitializer.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplicationInitializer.class, args);
	}
}

