package com.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		myClass().printMessage("Mukesh..!");
	}

	@Bean
	public MyClass myClass() {
		return new MyClass();
	}
}
