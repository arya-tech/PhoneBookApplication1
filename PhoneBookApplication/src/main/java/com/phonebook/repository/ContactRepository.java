package com.phonebook.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {
	
	public List<Contact> findByActiveSw(String activeSw);

}
