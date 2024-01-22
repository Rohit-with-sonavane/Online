package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.hotel_add;

@Repository
public interface hotel_addDao extends JpaRepository<hotel_add, Integer>{

}
