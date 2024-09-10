package com.sp.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sp.main.bean.Student;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				studentBean().displayDetails();
				System.out.println("-----------------------------------------");
				studentBean2().displayDetails();
			}
		};
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
