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
@Table(name="h_add")
public class hotel_add {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hadd_id")
	@NotNull
	private int hotel_add_id;
	
	@NotEmpty
	private String pincode;
	private String landmark;
	private String area;
	@NotEmpty
	private String city;
	private String state;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "hid")
//	private hotels hotel;
	@JsonIgnoreProperties ("hotel_address")
	@OneToOne(mappedBy = "hotel_address")
	private hotels hotel;
	
	
	
	public hotel_add() {
		super();
	}


	/*public hotel_add(@NotNull int hotel_add_id, @NotEmpty String pincode, String landmark, String area,
			@NotEmpty String city, String state) {
		super();
		this.hotel_add_id = hotel_add_id;
		this.pincode = pincode;
		this.landmark = landmark;
		this.area = area;
		this.city = city;
		this.state = state;
	}*/
	
	public hotel_add(@NotNull int hotel_add_id, @NotEmpty String pincode, String landmark, String area,
			@NotEmpty String city, String state) {
		super();
		this.hotel_add_id = hotel_add_id;
		this.pincode = pincode;
		this.landmark = landmark;
		this.area = area;
		this.city = city;
		this.state = state;
	}
	
	public int getHotel_add_id() {
		return hotel_add_id;
	}

	public hotels getHotel() {
		return hotel;
	}


	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}


	public void setHotel_add_id(int hotel_add_id) {
		this.hotel_add_id = hotel_add_id;
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
	



	
	
	
	
	
	

}
