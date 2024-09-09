package com.project.EverestConsultancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Welcome to Everest Technologies",
				version = "1.0.0",
				description = "This is the Documentation for Everest Student Consultancy Rest API",
				termsOfService = "by chaitnaya",
				contact  = @Contact(
						name = "Sai Chaitanya",
						email = "saichaitanya9989@gmail.com"),
				license = @License(
						name = "license")))
public class EverestConsultancyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EverestConsultancyApplication.class, args);
	}

}
