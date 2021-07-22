package com.liv2train.config;


import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Liv2Train API",
	      "API for minimum viable product of Liv2Train.",
	      "1.0",
	      "Terms of service",
	      new Contact("Mohd Shazan", "https://www.linkidin/in/mohd-shazan", "shahzan1999@gmail.com"),
	      "License of API",
	      "API",
	      Collections.emptyList());
	}
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.liv2train.controller")).paths(PathSelectors.any())
	      .paths(PathSelectors.any())
	      .build();
	}

}
