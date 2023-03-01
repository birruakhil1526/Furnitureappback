package org.spring.course13sp3pc1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient()
public class Course13Sp3Pc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course13Sp3Pc1Application.class, args);
	}


}
