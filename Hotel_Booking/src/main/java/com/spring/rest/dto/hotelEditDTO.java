package com.spring.rest.dto;

import com.spring.rest.entity.hotels;
import com.spring.rest.entity.manager;

public class hotelEditDTO {
	
	private double price;
	private float rating;

	
	public hotelEditDTO() {
		super();
	}


	public hotelEditDTO(double price, float rating) {
		super();
		this.price = price;
		this.rating = rating;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	
	

}
