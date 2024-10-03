package com.recruitment_questions.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS for all paths
            .allowedOrigins("http://localhost:4200") // Angular frontend URL
            .allowedMethods("*") // Allow all HTTP methods
            .allowedHeaders("*") // Allow all headers
            .allowCredentials(true); // Allow sending credentials
    }
}
