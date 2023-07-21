package com.api.movies.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
            .info(new Info()
                .title("Movie API")
                .description("API criada para estudos")
                .version("1.0")
                .contact(new Contact()
                            .name("Vitor Melo")
                             .url("https://github.com/vitor-pm")
                            .email("vitormelo9913@gmail.com")));
    }
}
