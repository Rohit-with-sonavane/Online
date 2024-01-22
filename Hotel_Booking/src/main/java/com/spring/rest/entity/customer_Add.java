package com.spring.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "custadd")
public class customer_Add {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cadd_id")
	@NotNull
	private int cadd_id;
	@NotEmpty
	private String pincode;
	private String landmark;
	private String area;
	@NotEmpty
	private String city;
	private String state;
	
	@JsonIgnoreProperties ("cadd")
	@OneToOne(mappedBy = "cadd")
	private user user;

	public int getCadd_id() {
		return cadd_id;
	}

	public void setCadd_id(int cadd_id) {
		this.cadd_id = cadd_id;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	

}
