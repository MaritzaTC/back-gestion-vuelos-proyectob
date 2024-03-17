package com.edu.udea.airline.config;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class OpenApiConfig {
    @Value("http://localhost:8080")
    private String devUrl;
    @Bean
    public OpenAPI api() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Info info = new Info()
                .title(" Flight management- REST API Documentation")
                .version("1.0")
                .description("REST API Documentation for Sprint 1 of the Code factory project.");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
