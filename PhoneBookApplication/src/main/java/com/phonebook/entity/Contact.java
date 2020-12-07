package com.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_NUM")
	private Long contactNumber;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="ACTIVE_SW")
	private String activeSw;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

}
