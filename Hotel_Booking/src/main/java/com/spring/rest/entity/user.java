package com.spring.rest.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class user {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="cid")
	private int id;
	@NotNull
	@Column(name="cname")
	private String name;
	@NotNull
	@Email
	@Column(unique = true)
   
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.DATE)
	//@NotNull
	private Date dob;
	//@NotNull
	@Pattern(regexp = "[0-9]{10}")
	private String contact;
	//@NotNull
	@Size(min = 2)
	private String password;

	private String role;
	
	@JsonIgnoreProperties("user")
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "cadd_id")
	private customer_Add cadd;
	//@JsonIgnore
	//@JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties({"user","hotel","payment"})
	private List<booking> booking = new ArrayList<booking>(); 
	//@JsonIgnore
	//@JsonManagedReference
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties({"customer","hotel"})
	private List<reviews> review = new ArrayList<reviews>();
	
	public user() {
		super();
	}


//	public user(int id, @NotNull String name, @NotNull @Email String email, @NotNull Date dob,
//			@NotNull @Pattern(regexp = "[0-9]{10}") String contact, @NotNull @Size(min = 2) String password,
//			String role) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.dob = dob;
//		this.contact = contact;
//		this.password = password;
//		this.role = role;
//		
//	}

//	public user(int id, @NotNull String name, @NotNull @Email String email, @NotNull Date dob,
//			@NotNull @Pattern(regexp = "[0-9]{10}") String contact, @NotNull @Size(min = 2) String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.dob = dob;
//		this.contact = contact;
//		this.password = password;
//		this.role="customer";
//		
//	}

	


	public int getId() {
		return id;
	}

	public user(int id, @NotNull String name, @NotNull @Email String email, Date dob,
		@Pattern(regexp = "[0-9]{10}") String contact, @Size(min = 2) String password, String role, customer_Add cadd) {
	//super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.dob = dob;
	this.contact = contact;
	this.password = password;
	this.role = role;
	this.cadd = cadd;
}


	public void setId(int id) {
		this.id = id;
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


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	



	public customer_Add getCadd() {
		return cadd;
	}


	public void setCadd(customer_Add cadd) {
		this.cadd = cadd;
	}

	public List<booking> getBooking() {
		return booking;
	}


	public void setBooking(List<booking> booking) {
		this.booking = booking;
	}
	
	


	public List<reviews> getReview() {
		return review;
	}


	public void setReview(List<reviews> review) {
		this.review = review;
	}

//
//	@Override
//	public String toString() {
//		return "user [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", contact=" + contact
//				+ ", password=" + password + ", role=" + role + ", cadd=" + cadd + ", booking=" + booking + ", review="
//				+ review + "]";
//	}






	
}
