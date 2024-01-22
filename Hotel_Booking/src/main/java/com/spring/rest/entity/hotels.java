package com.spring.rest.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="hotels")
public class hotels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hid")
	@NotNull
	private int hotel_id;
	@NotEmpty
	 @Column(name="hname")
	private String name;
	private float rating;
	@NotNull
	private double price;
	
//	@OneToOne(mappedBy = "hotel")
//   	private hotel_add hotel_address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_add_id")
	@JsonIgnoreProperties("hotel")
	private hotel_add hotel_address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	private manager manager;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties({"hotel","user"})
	//@JsonManagedReference
	private List<booking> booking = new ArrayList<booking>(); 
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("hotel")
	//@JsonManagedReference
	private List<hotel_details> details = new ArrayList<hotel_details>();
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("hotel")
	//@JsonManagedReference
	private List<hotel_images> image = new ArrayList<hotel_images>();
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL) 
	@JsonIgnoreProperties({"hotel","review"})
	//@JsonManagedReference
	private List<reviews> review = new ArrayList<reviews>();
	
	
	public hotels() {
		super();
	}


	public hotels(@NotNull int hotel_id, @NotEmpty String name, float rating, @NotNull double price) {
		super();
		this.hotel_id = hotel_id;
		this.name = name;
		this.rating = rating;
		this.price = price;
	}
	
	

	public hotels(@NotNull int hotel_id, @NotEmpty String name, float rating, @NotNull double price,
			hotel_add hotel_address, com.spring.rest.entity.manager manager) {
		super();
		this.hotel_id = hotel_id;
		this.name = name;
		this.rating = rating;
		this.price = price;
		this.hotel_address = hotel_address;
		this.manager = manager;
	}


	public int getId() {
		return hotel_id;
	}
	public void setId(int id) {
		this.hotel_id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

		

	public hotel_add getHotel_address() {
		return hotel_address;
	}


	public void setHotel_address(hotel_add hotel_address) {
		this.hotel_address = hotel_address;
	}
	


	public List<booking> getBooking() {
		return booking;
	}


	public void setBooking(List<booking> booking) {
		this.booking = booking;
	}
	


	public List<hotel_details> getDetails() {
		return details;
	}


	public void setDetails(List<hotel_details> details) {
		this.details = details;
	}
	
	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}


	public manager getManager() {
		return manager;
	}


	public void setManager(manager manager) {
		this.manager = manager;
	}

	public List<hotel_images> getImage() {
		return image;
	}


	public void setImage(List<hotel_images> image) {
		this.image = image;
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
//		return "hotels [hotel_id=" + hotel_id + ", name=" + name + ", rating=" + rating + ", price=" + price + "]";
//	}
//	
	
	
	
}
