package com.edu.udea.airline.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;
public class OpenApiConfig {
    public OpenAPI api() {

        return new OpenAPI();
    }
}
