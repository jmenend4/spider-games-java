package com.juan.spidergames.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.juan.spidergames.resources"))
				.paths(PathSelectors.ant("/api/**"))
				.build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Spider Games Persistence API", 
	      "Backend support for Spider Games persistence requirements.", 
	      "0.0.1", 
	      "https://github.com/jmenend4/spider-games-java/blob/main/README.md",
	      new Contact("Juan Menendez", "https://github.com/jmenend4", "jmenend4@gmail.com"), 
	      "License of API", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

}
