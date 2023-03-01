package org.spring.course14sp1pc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Course14Sp1Pc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Course14Sp1Pc1Application.class, args);
	}

}
