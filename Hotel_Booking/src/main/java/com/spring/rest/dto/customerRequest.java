package com.spring.rest.dto;

import com.spring.rest.entity.booking;
import com.spring.rest.entity.hotels;
import com.spring.rest.entity.payment;
import com.spring.rest.entity.user;

public class customerRequest {
	private booking book;
	private payment pay;
	public customerRequest(booking book, payment pay) {
		super();
		this.book = book;
		this.pay = pay;
	}
	public customerRequest() {
		super();
	}
	public booking getBook() {
		return book;
	}
	public void setBook(booking book) {
		this.book = book;
	}
	public payment getPay() {
		return pay;
	}
	public void setPay(payment pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		return "customerRequest [book=" + book + ", pay=" + pay + "]";
	}

	
	
	

}
