package com.example.project;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories("com.example.project.persistance")
@EntityScan("com.example.project.domain")
@CrossOrigin
@SpringBootApplication
public class ProjectApplication extends SpringBootServletInitializer implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProjectApplication.class);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Hello World from Application Runner");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	//This is used to consume RESTful webservices.

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}
// The above bean creation is for enabling CORS globally from this origin

}
/* The main class is extending SpringBootServletInitializer in order to support war file deployment.
The configure method is added to support this.

The main class is implementing ApplicationRunner interface in order to execute some code after the Spring Boot application started.
The code in run(ApplicationArguments arg0) method gets executed once the Spring Boot application gets started.
 */
