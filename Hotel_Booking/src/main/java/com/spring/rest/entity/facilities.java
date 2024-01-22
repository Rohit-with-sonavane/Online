package com.spring.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "facilities")
public class facilities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int facilities_id;
	private String facility;
	
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "hotel_details_id")
	@JsonIgnoreProperties("facility")
	//@JsonIgnore
	//@JsonBackReference
	private hotel_details hotel_detail;

	public facilities() {
		super();
	}

	public facilities(@NotNull int facilities_id, String facility, hotel_details hotel_detail) {
		super();
		this.facilities_id = facilities_id;
		this.facility = facility;
		//this.hotel_detail = hotel_detail;
	}

	public int getFacilities_id() {
		return facilities_id;
	}

	public void setFacilities_id(int facilities_id) {
		this.facilities_id = facilities_id;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public hotel_details getHotel_detail() {
		return hotel_detail;
	}

	public void setHotel_detail(hotel_details hotel_detail) {
		this.hotel_detail = hotel_detail;
	}

	@Override
	public String toString() {
		return "facilities [facilities_id=" + facilities_id + ", facility=" + facility + ", hotel_detail="
				+ hotel_detail + "]";
	}
	
	
	
	
	

}
