package com.spring.rest.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "payment")
public class payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int payment_id;
	private String payment_type;
	private int amount;
	
	@JsonIgnoreProperties ("payment")
	@OneToOne(mappedBy = "payment",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private booking booking;
	
	@JsonIgnoreProperties ("payment")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipt_no")
	private receipt receipt;


	public payment() {
		super();
	}


	public payment(@NotNull int payment_id, String payment_type, int amount, com.spring.rest.entity.booking booking) {
		super();
		this.payment_id = payment_id;
		this.payment_type = payment_type;
		this.amount = amount;
		//this.booking = booking;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public booking getBooking() {
		return booking;
	}

	public void setBooking(booking booking) {
		this.booking = booking;
	}
	
	

	public receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "payment [payment_id=" + payment_id + ", payment_type=" + payment_type + ", amount=" + amount
				+ ", booking=" + booking + "]";
	}
	
	

}
