package com.revature.charityapprequestorms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		String [] origins = { "http://localhost:4200", "https://charity-requestor.herokuapp.com"};
		registry.addMapping("/**").allowedOrigins(origins)
				.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD").allowCredentials(true);
	}

}
