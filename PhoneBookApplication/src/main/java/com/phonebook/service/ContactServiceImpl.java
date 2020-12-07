package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact saveObject = contactRepository.save(contact);
		if(saveObject!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findByActiveSw("Y");
	}

	@Override
	public Contact getContactById(Integer contactId) {
	 Optional<Contact> contact = contactRepository.findById(contactId);
	 if(contact.isPresent()) {
		 return contact.get();
	 }
	 return null;
	}

	/*
	 * @Override public boolean updateContact(Contact contact) { try { Contact
	 * updateContact = contactRepository.save(contact); return true;
	 * }catch(Exception e) { e.printStackTrace(); return false; } }
	 */

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			 Contact contact = contactRepository.findById(contactId).get();
			 contact.setActiveSw("N");
			contactRepository.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
