package com.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dao.hotel_addDao;
import com.spring.rest.dao.hotelimpl;

@RestController
public class hotel_add_controller {
	
	@Autowired
	private hotel_addDao hotel_add_dao;
	
	@Autowired
	private hotelimpl hotelDao;

}
