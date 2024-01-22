package com.spring.rest.dto;

public class hotelDTO {
	
	private String name;
	private Float rating;
	private Double price;

	public hotelDTO() {
		super();
	}

	public hotelDTO( String name, Float rating, Double price) {
		super();
		
		this.name = name;
		this.rating = rating;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "hotelDTO [name=" + name + ", rating=" + rating + ", price=" + price +  "]";
	}

	
	
	
	
	
	
	

}
