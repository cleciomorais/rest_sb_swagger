package br.com.rest.sb.swagger.config;

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
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(
					  DocumentationType.SWAGGER_2)
//					  .select().apis(RequestHandlerSelectors.any()) //todos os controllers
					  .select().apis(RequestHandlerSelectors.basePackage("br.com.rest.sb.swagger") ) //todos os controllers DENTRO DO PACOTE/subpacotes
					  .paths(PathSelectors.any()) //todos os paths do controller
					  .build()
					  .apiInfo(apiInfo());
				
				
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfo("API Restfull - Swagger Documentation", 
							"API with: Java ; Springboot ; Dozzer ; Hateoas ; Flyway ; VO ; Content Negotiation ; Mysql 8 ; JUnit", 
							"V1", 
							"API Terms of Services url", 
							new Contact("Clecio Morais", "https://github.com/cleciomorais?tab=repositories", "cleciovmorais@gmail.com"),
							"API Licence description",
							"API Licence URL",  
							Collections.emptyList()
							);
		
	}
}
