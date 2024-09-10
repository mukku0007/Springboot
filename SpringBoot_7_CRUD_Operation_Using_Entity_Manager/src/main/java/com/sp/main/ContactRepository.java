package com.sp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ContactRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(Contact contact) {
		entityManager.persist(contact);
	}
}
