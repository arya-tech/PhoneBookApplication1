package com.phonebook.service;

import java.util.List;

import com.phonebook.entity.Contact;


public interface ContactService {
	
	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	

	
//	public boolean updateContact(Contact contact);
	
	
	public boolean deleteContactById(Integer contactId);

}
