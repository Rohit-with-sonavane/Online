package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.booking;

@Repository
public interface bookingDao extends JpaRepository<booking, Integer>{

}
