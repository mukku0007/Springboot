package com.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sp.main.bean.Student;

@SpringBootApplication
public class SpringBoot2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentBean().displayDetails();
		System.out.println("==========================================");
		studentBean2().displayDetails();
	}
	
	@Bean
	public Student studentBean() {
		return new Student("Mukesh Kumar", 101, 92);
	}
	
	@Bean
	public Student studentBean2() {
		return new Student("Rakesh Kumar", 102, 95); 
	}

}
