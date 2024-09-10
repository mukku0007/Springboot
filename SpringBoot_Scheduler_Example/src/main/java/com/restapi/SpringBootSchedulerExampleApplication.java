package com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //This annotation is used to enable scheduling 
public class SpringBootSchedulerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulerExampleApplication.class, args);
	}

}
