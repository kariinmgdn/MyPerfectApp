package com.example.myperfectapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fc56d38 (added swagger)
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
<<<<<<< HEAD
=======
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
>>>>>>> 250cd76 (Changed app structure)
=======
>>>>>>> fc56d38 (added swagger)
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
<<<<<<< HEAD
<<<<<<< HEAD
@EnableWebMvc
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.myperfectapp"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Endpoints for MyPerfectApp REST API")
<<<<<<< HEAD
                .build();
    }
=======
=======
@EnableWebMvc
>>>>>>> fc56d38 (added swagger)
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.myperfectapp"))
                .paths(PathSelectors.any())
                .build();
    }
<<<<<<< HEAD
>>>>>>> 250cd76 (Changed app structure)
=======

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Endpoints for Synonyms REST API")
=======
>>>>>>> b553233 (changed service class)
                .build();
    }
>>>>>>> fc56d38 (added swagger)
}
