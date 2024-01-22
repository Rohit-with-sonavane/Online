package com.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="manager")
public class manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int manager_id;
	private String name;
	private String email;
	private String password;
	
	
	
	public manager() {
		super();
	}
    @JsonIgnore
	@JsonIgnoreProperties ("manager")
	@OneToOne(mappedBy = "manager")
	private hotels hotel;

	public manager(@NotNull int manager_id, String name, String email, String password) {
		super();
		this.manager_id = manager_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public hotels getHotel() {
		return hotel;
	}

	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "manager [manager_id=" + manager_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", hotel=" + hotel + "]";
	}
	
	

	

}
