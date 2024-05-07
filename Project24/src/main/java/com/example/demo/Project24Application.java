package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// Mark as a SpringBoot Application
@SpringBootApplication
public class Project24Application {
	// Main Method
	public static void main(String[] args) {
		// Run
		SpringApplication.run(Project24Application.class, args);
	}
	
	// CORS
//	@Bean
//	public CorsFilter corsFilter() {
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.addAllowedOriginPattern("*");
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("OPTIONS");
//	    config.addAllowedMethod("GET");
//	    config.addAllowedMethod("POST");
//	    config.addAllowedMethod("PUT");
//	    config.addAllowedMethod("DELETE");
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter(source);
//	}
}