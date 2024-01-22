package com.spring.rest.dto;

import com.spring.rest.entity.hotel_add;
import com.spring.rest.entity.hotels;
import com.spring.rest.entity.manager;

public class hotelFormDto {
	private hotels hotel;
	private hotel_add add;
	
	public hotelFormDto() {
		super();
	}

	public hotelFormDto(hotels hotel, hotel_add add) {
		super();
		this.hotel = hotel;
		this.add = add;
		
	}

	public hotels getHotel() {
		return hotel;
	}

	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}

	public hotel_add getAdd() {
		return add;
	}

	public void setAdd(hotel_add add) {
		this.add = add;
	}

	
	@Override
	public String toString() {
		return "hotelFormDto [hotel=" + hotel + ", add=" + add + "]";
	}

	
	

}
