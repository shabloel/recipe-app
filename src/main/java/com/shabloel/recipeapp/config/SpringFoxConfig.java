package com.shabloel.recipeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;

/**
 * @author : christiaan.griffioen
 * @since :  23-6-2021, wo
 **/
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket recipeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()//gets a Docket instance (ApiSelectorBuilder)
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Recipe API")
                .version("1.0")
                .description("API for Recipes")
                .contact(new Contact("Chris Griffioen", "http://chrisgriffioen.com", "xyz@email.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
