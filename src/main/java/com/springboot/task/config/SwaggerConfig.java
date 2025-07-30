package com.springboot.task.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "Springboot Task",
    version = "1.0",
    description = "Springboot Task API Documentation"
  )
)
public class SwaggerConfig {
}
