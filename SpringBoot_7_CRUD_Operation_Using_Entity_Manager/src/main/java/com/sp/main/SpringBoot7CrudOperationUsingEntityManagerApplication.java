package com.sp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot7CrudOperationUsingEntityManagerApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot7CrudOperationUsingEntityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Happy Coding..!");
	}
	
	public void createContact() {
		Contact contact = new  Contact();
		contact.setName("Mukesh Kumar");
		contact.setEmail("mukesh@gmail.com");
		contact.setAddress("Noida");
		
		contactRepository.save(contact);
		
	}
}
