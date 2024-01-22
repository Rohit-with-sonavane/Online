package com.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "receipt")
public class receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int receipt_no;
	private int amount;
	
	@JsonIgnoreProperties ("receipt")
	@OneToOne(mappedBy = "receipt")
	private payment payment;
	public receipt() {
		super();
	}
	public receipt(@NotNull int receipt_no, int amount, com.spring.rest.entity.booking booking) {
		super();
		this.receipt_no = receipt_no;
		this.amount = amount;
		//this.booking = booking;
	}
	public int getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(int receipt_no) {
		this.receipt_no = receipt_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public payment getPayment() {
		return payment;
	}
	public void setPayment(payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "receipt [receipt_no=" + receipt_no + ", amount=" + amount + ", payment=" + payment + "]";
	}
	
	
	
	
	

}
