package com.spring.rest.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hotel_details")
public class hotel_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int hotel_details_id;
	private String room_type;
	private String condition;
	
	//@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties("details")
	//@JsonBackReference
	private hotels hotel;

	@OneToMany(mappedBy = "hotel_detail",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("hotel_detail")
	//@JsonManagedReference
	private List<facilities> facility = new ArrayList<facilities>();
	
	public hotel_details() {
		super();
	}

	public hotel_details(@NotNull int hotel_details_id, String room_type, String condition, hotels hotel) {
		super();
		this.hotel_details_id = hotel_details_id;
		this.room_type = room_type;
		this.condition = condition;
		//this.hotels = hotels;
	}

	public int getHotel_details_id() {
		return hotel_details_id;
	}

	public void setHotel_details_id(int hotel_details_id) {
		this.hotel_details_id = hotel_details_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public hotels getHotel() {
		return hotel;
	}

	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}
	
	
	public List<facilities> getFacility() {
		return facility;
	}

	public void setFacility(List<facilities> facility) {
		this.facility = facility;
	}

	@Override
	public String toString() {
		return "hotel_details [hotel_details_id=" + hotel_details_id + ", room_type=" + room_type + ", condition="
				+ condition + ", hotels=" + hotel + "]";
	}
	
	
	

}
