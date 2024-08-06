package com.sangam.muscleplay.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("MusclePlay API")
                        .description("MusclePlay Application")
                        .version("V 0.0.1")
                );
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
    }


}
