package com.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dao.paymentDao;
import com.spring.rest.entity.booking;

@RestController
public class payment_controller {
	@Autowired
	public paymentDao paymentDao;
	
	
}
