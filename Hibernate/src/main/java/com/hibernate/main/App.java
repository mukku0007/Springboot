package com.hibernate.main;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hibernate.entities.Employee;
import com.mysql.cj.xdevapi.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
    	Employee emp1 = new Employee();
    	emp1.setId(101);
    	emp1.setName("Mukesh Kumar");
    	emp1.setGender("Male");
    	emp1.setcity("Noida");
    	
       Configuration configuration = new Configuration();
       configuration.configure("/com/hibernate/config/hibernate.cfg.xml");
       
       SessionFactory sessionFactory = (SessionFactory) configuration.buildSessionFactory();
       Session session = ((org.hibernate.SessionFactory) sessionFactory).openSession();
       Transaction transaction = (Transaction) session.beginTransaction();
       
       try {
		session.save(emp1);
		transaction.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
}
