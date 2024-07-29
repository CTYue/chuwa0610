package com.jackpang.xhs.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author b1go
 * @date 7/3/22 10:30 PM
 */
@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION = "Authorization";
    @Value("${doc.openapi.dev-url}")
    private String devUrl;

    private Info apiInfo() {
        Contact contact = new Contact();
        contact.setName("jack");
        contact.setEmail("pjhao@126.com");
        contact.setUrl("url");
        Info info = new Info();
        info.setContact(contact);
        info.setTitle("RedBook REST APIs");
        info.setDescription("RedBook REST API Documentation");
        info.setVersion("1");
        info.termsOfService("Terms of service");
        info.license(new License().name("API license").url("API license URL"));
        return info;
    }

    @Bean
    public OpenAPI api() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");
        return new OpenAPI()
                .info(apiInfo())
                .addSecurityItem(new SecurityRequirement().addList(AUTHORIZATION))
                .components(new Components().addSecuritySchemes(AUTHORIZATION,
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                ))
                .servers(List.of(devServer));
    }


}
