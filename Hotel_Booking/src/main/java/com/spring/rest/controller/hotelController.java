package com.spring.rest.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dao.hotelimpl;
import com.spring.rest.dto.hotelDTO;
import com.spring.rest.dto.hotelEditDTO;
import com.spring.rest.dto.hotelFormDto;
import com.spring.rest.entity.hotels;
import com.spring.rest.entity.user;

@RestController
public class hotelController {
	
	@Autowired
    public hotelimpl hoteldao;
	
	//To get all hotels
	   @GetMapping("/hotels")	
	   public Map<String, Object> getallhotel(){
		   Map<String, Object> result= new HashMap<>();
		 List<hotels> hotelList=  hoteldao.findAll();
		System.out.println(hotelList);
		 result.put("status", "success");
		 result.put("data",hotelList);
		// System.out.println(result);
		   return result;
	   }
	   
	   
	   
	   //To get one hotel 
	   @GetMapping("/hotels/{id}")
	   public Map<String, Object> gethotelbyid(@PathVariable("id") int id){
	   Map<String, Object> result= new HashMap<>();
	    Optional<hotels> h= hoteldao.findById(id);
	    System.out.println(h);
	    result.put("status", "success");
		 result.put("data",h);
		     return result;
	   }
	   
	   
	   //To add new hotel for admin
	   @PostMapping("/addHotel")
	   public Map<String, Object> addhotel(@RequestBody hotelFormDto h){
		   System.out.println("hotelDTO"+h);
		   Map<String ,Object> result= new HashMap<>();
		   try {
			  // user us= new user(u.getU().getId(),u.getU().getName(),u.getU().getEmail(),u.getU().getDob(),u.getU().getContact(),u.getU().getPassword(),"customer",u.getCuss());
			   hotels nh = new hotels();
			   nh.setHotel_id(h.getHotel().getId());
			   nh.setName(h.getHotel().getName());
			   nh.setPrice(h.getHotel().getPrice());
			   nh.setRating(h.getHotel().getRating());
			   nh.setHotel_address(h.getAdd());
	
		hotels hotel= hoteldao.save(nh);
		 System.out.println(result);
		   result.put("status","success");
		   result.put("data", hotel);
		   }catch(Exception e) {
			   e.printStackTrace();
			   result.put("status","error");
			   result.put("message", e.getMessage());
		   }
		   return result;
		   
	   }
	   
	// to delete hotel
	   @DeleteMapping("/deleteHotel/{hid}")
	   public Map<String,Object> deletehotels(@PathVariable("hid") int id){
		   Map<String, Object> result=new HashMap<>();
		   System.out.println("id "+id);
		   try {
		   hoteldao.deleteById(id);
		   result.put("status","success");
		   result.put("data",id );
		   }catch(Exception e) {
			   e.printStackTrace();
			   result.put("status","error");
			   result.put("message", e.getMessage());
		   
		   }
		   return result;

}
	   
	   
	 //to update a hotel
	   @PutMapping("/hotel/{hid}")
	   public Map<String, Object> updatehotel(@PathVariable("hid")int id, @RequestBody hotelEditDTO h){
		   System.out.println("controller:"+h.toString());
		   System.out.println("HID:"+id);
		   hotels ho = hoteldao.findById(id).orElseThrow();
	 	   Map<String ,Object> result= new HashMap<>();
	 	   try {
	 		  
	 		   ho.setId(id);
	 		   ho.setRating(h.getRating());
	 		   ho.setPrice(h.getPrice());
	 		 
	 		  hotels  nh= hoteldao.save(ho);
	 		   result.put("Status", "success");
	 		   result.put("data", nh);
	 	   }catch (Exception e) {
			e.printStackTrace();
			result.put("Status", "error");
			result.put("message", e.getMessage());
		}
	 	   return result;
	    } 
	   
	   @GetMapping("/state")
		 public Map<String,Object> getHotelByState()
		 {
			 Map<String,Object> result= new HashMap<>();
			 try {
				List<hotels> hlist = hoteldao.findByState("Maharastra");
				 result.put("Status", "success");
				 result.put("data",hlist);
			 }catch (Exception e)
			 {
				 e.printStackTrace();
					result.put("Status", "error");
					result.put("message", e.getMessage()); 
			 }
			return result;
		 }
}
