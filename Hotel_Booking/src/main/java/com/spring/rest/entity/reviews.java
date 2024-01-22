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

@Entity
@Table(name = "reviews")
public class reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int review_id;
	private String description;
	
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties("{review,hotel}")
	//@JsonIgnore
	//@JsonBackReference
	private hotels hotel;

	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("{review,customer}")
	//@JsonIgnore
	//@JsonBackReference
	private user customer;

	public reviews() {
		super();
	}

	public reviews(@NotNull int review_id, String description, hotels hotel, user customer) {
		super();
		this.review_id = review_id;
		this.description = description;
		//this.hotel = hotel;
		//this.customer = customer;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public hotels getHotel() {
		return hotel;
	}

	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}

	public user getCustomer() {
		return customer;
	}

	public void setCustomer(user customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "reviews [review_id=" + review_id + ", description=" + description + ", hotel=" + hotel + ", customer="
				+ customer + "]";
	}
	
	

}
