package com.example.ECommerceApplication.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "E-Commerce Application API",
                version = "1.0",
                description = "Documentation for E-Commerce Application.",
                contact = @Contact(name = "Fagun Saraswat", email = "saraswatfagun@example.com")
        ),
        servers = @Server(url = "http://localhost:8080", description = "Local Server"),
        tags = {
                @Tag(name = "User Management", description = "Operations related to user management"),
                @Tag(name = "Admin Operations", description = "Operations for admin users")
        }
)
public class SwaggerConfig {
}