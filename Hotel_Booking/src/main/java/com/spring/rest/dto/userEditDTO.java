package com.spring.rest.dto;

import java.sql.Date;

public class userEditDTO {
	private String name;
	private String email;
	private Date dob;
	private String contact;
	private String password;
	
	
	public userEditDTO() {
		super();
	}


	public userEditDTO(String name, String email, Date dob, String contact, String password) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.contact = contact;
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
