package com.spring.rest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="bookings")
public class booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bid")
	@NotNull
	private int booking_id;
	private String room_type;
	private String check_in;
	private String check_out;
	private String status;
	
	//@JsonBackReference
	@JsonIgnoreProperties ({"booking,review"})
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "id")
	private user user;
	
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties({"booking,manager,hotel_address,image,review"})
	//@JsonIgnore
	//@JsonBackReference
	private hotels hotel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	@JsonIgnoreProperties({"booking"})
	private payment payment;
	
	public booking() {
		super();
	}



	public booking(@NotNull int booking_id, String room_type, String check_in, String check_out, String status,
			com.spring.rest.entity.user user, hotels hotel, com.spring.rest.entity.payment payment) {
		super();
		this.booking_id = booking_id;
		this.room_type = room_type;
		this.check_in = check_in;
		this.check_out = check_out;
		this.status = status;
		this.user = user;
		this.hotel = hotel;
		this.payment = payment;
	}



	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	

	public hotels getHotel() {
		return hotel;
	}

	public void setHotel(hotels hotel) {
		this.hotel = hotel;
	}

	public payment getPayment() {
		return payment;
	}

	public void setPayment(payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "booking [booking_id=" + booking_id + ", room_type=" + room_type + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", status=" + status + ", user=" + user + "]";
	}
	
	
	
	

}
