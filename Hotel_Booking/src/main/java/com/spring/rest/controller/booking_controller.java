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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.dao.bookingDao;
import com.spring.rest.dao.hotelimpl;
import com.spring.rest.dao.userimpl;
import com.spring.rest.dto.bookingDTO;
import com.spring.rest.dto.customerRequest;
import com.spring.rest.entity.booking;
import com.spring.rest.entity.hotels;
import com.spring.rest.entity.user;


@RestController
public class booking_controller {
	
	@Autowired
	public bookingDao bookingDao;
	
	@Autowired
	public userimpl userDao;
	
	@Autowired
	public hotelimpl hotelDao;
	
	//get all bookings
	 @GetMapping("/bookings")	
	   public Map<String, Object> getallbookings(){
		   Map<String, Object> result= new HashMap<>();
		 List<booking> booking =  bookingDao.findAll();
		System.out.println(booking);
		 result.put("status", "success");
		 result.put("data",booking);
		// System.out.println(result);
		   return result;
	   }
	 
	 //To get one bookings
	   @GetMapping("/booking/{bid}")
	   public Map<String, Object> getbookingbyid(@PathVariable("bid") int id){
	   Map<String, Object> result= new HashMap<>();
	    Optional<booking> b= bookingDao.findById(id);
	    System.out.println(b);
	    result.put("status", "success");
		 result.put("data",b);
		     return result;
	   }
	   
	 //To add new booking for customer
	   @PostMapping("/addBooking/{cid}/{hid}")
	   public Map<String, Object> addBookig(@PathVariable("cid") int id,@PathVariable("hid") int hid,@RequestBody customerRequest book)
	   {
		   System.out.println(book);
		   Map<String ,Object> result= new HashMap<>();
//		   try {
//		// hotels hotel= new hotels(h.getId(),h.getName(),h.getRating(),h.getPrice());
//		 bookingDao.save(b);
//		   result.put("status","success");
//		   result.put("data", b);
//		   }catch(Exception e) {
//			   e.printStackTrace();
//			   result.put("status","error");
//			   result.put("message", e.getMessage());
//		   }
//		   return result;
		   
		   user u = userDao.findById(id).orElseThrow();
		  // book.setUser(u);
		   hotels h = hotelDao.findById(hid).orElseThrow();
		   booking b = new booking();
		   b.setBooking_id(book.getBook().getBooking_id());
		   b.setUser(u);
		   b.setHotel(h);
		   b.setRoom_type(book.getBook().getRoom_type());
		   b.setCheck_in(book.getBook().getCheck_in());
		   b.setCheck_out(book.getBook().getCheck_out());
		   b.setPayment(book.getPay());
		  // book.setHotel(h);
		 booking nb = bookingDao.save(b);
		   result.put("status","success");
		   result.put("data",nb);
		   return result;  
	   }
	   
	   @DeleteMapping("/delete/{bid}")
	   public Map<String,Object> deletebooking(@PathVariable("bid") int id){
		   Map<String, Object> result=new HashMap<>();
		   System.out.println("id "+id);
		   try {
		   bookingDao.deleteById(id);
		   result.put("status","success");
		   result.put("data",id );
		   }catch(Exception e) {
			   e.printStackTrace();
			   result.put("status","error");
			   result.put("message", e.getMessage());
		   
		   }
		   return result;
	   }
	   
	   

}
