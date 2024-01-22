package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.user;

@Repository
public interface userimpl extends JpaRepository<user, Integer> {

	 user findByEmail(String email);
	

}
