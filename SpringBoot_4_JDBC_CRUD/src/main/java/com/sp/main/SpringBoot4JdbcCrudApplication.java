package com.sp.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sp.main.dao.UserDAO;
import com.sp.main.entity.User;

@SpringBootApplication
public class SpringBoot4JdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDAO userDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot4JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//---------------------INSERTION---------------------
		
//		User user = new User("Rakesh Kumar", "rakesh@gmail.com", "male", "Rafiganj");
//		boolean status = userDAO.insertUser(user);
//		if (status) {
//			System.out.println("Users Inserted Successfully..!");
//		} else {
//			System.out.println("Users not Inserted due to some reason..!");
//		}
		
		
		//------------------SELECT_ALL_USERS------------------------------
//		List<User> allUsers = userDAO.getAllUsers();
//		for(User user: allUsers) {
//			System.out.println("Name: "+user.getName());
//			System.out.println("Email: "+user.getEmail());
//			System.out.println("Gender: "+user.getGender());
//			System.out.println("City: "+user.getCity());
//			System.out.println("----------------------------------------");
//		}
		
		
		//--------------------UPDATION-------------------------------
		
//		User user =  new User("Mukesh Kumar", "dsvvmukesh@gmail.com", "male", "Rafiganj");
//		boolean status = userDAO.updateUser(user);
//		if (status) {
//			System.out.println("Updation Successfully..!");
//		} else {
//			System.out.println("Updation Failed..!");
//		}
		
		
		//--------------------UPDATION_2-------------------------------
		
		User user =  userDAO.getUserByEmail("rakesh@gmail.com");
		user.setCity("Patna");
		
		boolean status = userDAO.updateUser(user);
		if (status) {
			System.out.println("Updation Successfully..!");
		} else {
			System.out.println("Updation Failed..!");
		}
		
		//-------------------DELETION--------------------------------
		
//		boolean status = userDAO.deleteUser("dsvvmukesh@gmail.com");
//		if(status) {
//			System.out.println("Deletion Successfully..!");
//		} else {
//			System.out.println("Deletion Failed..!");
//		}
		
		//--------------------SELECTION_BY_EMAIL----------------------------
		
//		User user = userDAO.getUserByEmail("rakesh@gmail.com");
//		System.out.println("Name: "+user.getName());
//		System.out.println("Email: "+user.getEmail());
//		System.out.println("Gender: "+user.getGender());
//		System.out.println("City: "+user.getCity());
		
	}
}
