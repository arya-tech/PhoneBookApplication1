package com.phonebook.controller;

import java.net.http.HttpClient.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.constant.ApplicationConstant;
import com.phonebook.entity.Contact;
import com.phonebook.props.ApplicationProperties;
import com.phonebook.service.ContactService;

@Controller
public class ContactController {
	@Autowired(required = true)
	private ContactService contactService;
	
	@Autowired
	private ApplicationProperties appProperties;
	
	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		
		model.addAttribute("contact",new Contact());// return empty object to the view component
		// to bind the fields with attribute.
		
		return "index";
	}
	
	@PostMapping("/saveContact")
	public String handleSaveContactBtn(Contact contact,RedirectAttributes redirect) {
		Map<String, String> messages = appProperties.getMessages();
		
		String msgText=null;
		if(contact.getContactId()==null) {
			msgText=messages.get(ApplicationConstant.SUCCESS_MSG);
			
		}else {
			msgText=messages.get(ApplicationConstant.UPDATE_MSG);
		}
		contact.setActiveSw("Y");
		boolean saveContact = contactService.saveContact(contact);
		if(saveContact) {
			redirect.addFlashAttribute("succMsg", msgText);
			
		}else {
			redirect.addFlashAttribute("errMsg", messages.get(ApplicationConstant.FAILED_TO_SAVE));
		}
		
		return "redirect:/loadForm";
	}
	@GetMapping("/viewContacts")
	public String handleViewContactBtn(Model model) {
		List<Contact> allContacts=new ArrayList<>();
		allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		
		return "viewContacts";
	}
	
	@GetMapping("/edit")
	public String handleEditClick(@RequestParam("cid") Integer cid,Model model) {
		Contact conatct = contactService.getContactById(cid);
		model.addAttribute("contact", conatct);
		return "index";
	}
	
	@GetMapping("/delete")
	public String handleDeleteClick(@RequestParam("cid") Integer cid,Model model) {
		
		contactService.deleteContactById(cid);
		return "redirect:/viewContacts";
	}

}
