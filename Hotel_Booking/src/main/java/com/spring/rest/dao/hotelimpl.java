package com.spring.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.hotels;

@Repository
public interface hotelimpl extends JpaRepository<hotels, Integer>{

	@Query(value = "select * from hotels Left Join h_add  On hotels.hotel_add_id = h_add.hadd_id where state = %:string%",nativeQuery = true)
	//@Query(value = "SELECT * FROM hotels h inner join h.h_add add where add.state = %:string%", nativeQuery = true)
	List<hotels> findByState(String string);
	
	//@Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
}
