package com.abhishek.poc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 2, 2018
 */
@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = { "com.abhishek.poc.repository" })
@EntityScan(basePackages = { "com.abhishek.poc.entity" })
@ComponentScan(value = "com.abhishek.poc.*")
@EnableSwagger2
public class Application {

	/**
	 * main method of application invoked by jvm at the time of deployment
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * This method was intend to define swagger definition for our controller
	 * classes
	 *
	 * @return
	 */
	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.abhishek.poc.controller")).build();
	}

}
