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
@Table(name = "hotel_images")
public class hotel_images {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int image_id;
	private String image_name;
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties("image")
	@JsonIgnore
	@JsonBackReference
	private hotels hotel;
	public hotel_images() {
		super();
	}
	public hotel_images(@NotNull int image_id, String image_name, hotels hotel) {
		super();
		this.image_id = image_id;
		this.image_name = image_name;
		//this.hotel = hotel;
	}
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public hotels getHotel() {
		return hotel;
	}
	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}
	
	
	@Override
	public String toString() {
		return "hotel_images [image_id=" + image_id + ", image_name=" + image_name + ", hotel=" + hotel + "]";
	}
	
	
	
	

}
