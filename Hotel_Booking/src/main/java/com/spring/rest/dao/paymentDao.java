package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entity.payment;

public interface paymentDao extends JpaRepository<payment, Integer>{

}
