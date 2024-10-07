package com.michelleduso.todolist.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("To-Do List API")
                .version("1.0")
                .description("API para gerenciamento de tarefas"))
            .addSecurityItem(new SecurityRequirement().addList("Basic Authentication"))
            .components(new Components()
                .addSecuritySchemes("Basic Authentication",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")));
    }
}
