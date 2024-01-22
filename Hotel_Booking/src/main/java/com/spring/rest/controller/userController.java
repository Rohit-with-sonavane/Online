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

import com.spring.rest.dao.userimpl;
import com.spring.rest.dto.userDTO;
import com.spring.rest.dto.userEditDTO;
import com.spring.rest.entity.hotels;
import com.spring.rest.entity.user;

@RestController
public class userController {
	
	@Autowired
    public userimpl userdao;

	//To get all users
   @GetMapping("/users")	
   public Map<String, Object> getallusers(){
	   Map<String, Object> result= new HashMap<>();
	 List<user> ulist=  userdao.findAll();
	System.out.println(ulist);
	 result.put("status", "success");
	 result.put("data",ulist);
	// System.out.println(result);
	   return result;
   }
   
   //To get one user and validation of user
   @GetMapping("/users/{email}/{password}")
   public Map<String, Object> getuserbyemail(@PathVariable("email") String email, @PathVariable("password") String pass){
	   Map<String, Object> result= new HashMap<>();
	   user cust= userdao.findByEmail(email);
	  // userDTO u=new userDTO(cust.getId(), cust.getName(), cust.getEmail(), cust.getDob(), cust.getContact(), cust.getRole());
	   if(cust.getPassword().equals(pass)) {
		   result.put("status", "success");
		   System.out.println(cust.toString());
			 result.put("data", cust);
			   return result;
	   }
	   else {
		   result.put("status", "error");
		   result.put("message","Invalid User");
	   }
	   return result;
   }
   
   //to register new user
   @PostMapping("/register")
   public Map<String, Object> adduser(@RequestBody userDTO u){
	   System.out.println("userDTO"+u);
	   Map<String ,Object> result= new HashMap<>();
	   try {
		   
	  user us= new user(u.getU().getId(),u.getU().getName(),u.getU().getEmail(),u.getU().getDob(),u.getU().getContact(),u.getU().getPassword(),"customer",u.getCuss());
	 // u.setU(us);
	  System.out.println(us.toString());
	  
	  user user = userdao.save(us);
	   result.put("status","success");
	   result.put("data", user);
	   //System.out.println("Login Successfull");
	   }catch(Exception e) {
		   e.printStackTrace();
		   result.put("status","error");
		   result.put("message", e.getMessage());
	   }
	   return result;
	   
   }
   
   //to update a user
   @PutMapping("/update/{cid}")
   public Map<String, Object> updateuser(@PathVariable("cid")int id, @RequestBody userEditDTO u){
	   System.out.println("controller:"+u.toString());
	   System.out.println("CID:"+id);
	   user us = userdao.findById(id).orElseThrow();
 	   Map<String ,Object> result= new HashMap<>();
 	   try {
 		   us.setId(id);
 		   us.setName(u.getName());
 		   us.setEmail(u.getEmail());
 		   us.setDob(u.getDob());
 		   us.setContact(u.getContact());
 		   us.setPassword(u.getPassword());
 		   user nu = userdao.save(us);
 		   System.out.println("us: "+nu);
 		  // userdao.save(us);
 		   result.put("Status", "success");
 		   result.put("data", u);
 	   }catch (Exception e) {
		e.printStackTrace();
		result.put("Status", "error");
		result.put("message", e.getMessage());
	}
 	   return result;
    } 
  
   // to delete user
   @DeleteMapping("/delete/{cid}")
   public Map<String,Object> deleteuser(@PathVariable("cid") int id){
	   Map<String, Object> result=new HashMap<>();
	   System.out.println("id "+id);
	   try {
	   userdao.deleteById(id);
	   result.put("status","success");
	   result.put("data",id );
	   }catch(Exception e) {
		   e.printStackTrace();
		   result.put("status","error");
		   result.put("message", e.getMessage());
	   
	   }
	   return result;
   }
   
 //To get one hotel 
   @GetMapping("/user/{id}")
   public Map<String, Object> gethotelbyid(@PathVariable("id") int id){
   Map<String, Object> result= new HashMap<>();
    Optional<user> u = userdao.findById(id);
    System.out.println(u);
    result.put("status", "success");
	 result.put("data",u);
	     return result;
   }
   
   
  
   

}//end of userController
