package com.spring.rest.dto;

import java.sql.Date;

import com.spring.rest.entity.customer_Add;
import com.spring.rest.entity.user;

//import java.util.Date;


public class userDTO {
		private user u;
		private customer_Add cuss;
	
		
		public userDTO() {
			
			super();
		}


		public userDTO(user u, customer_Add cuss) {
			super();
			this.u = u;
			this.cuss = cuss;
		}


		public user getU() {
			return u;
		}


		public void setU(user u) {
			this.u = u;
		}


		public customer_Add getCuss() {
			return cuss;
		}


		public void setCuss(customer_Add cuss) {
			this.cuss = cuss;
		}


		@Override
		public String toString() {
			return "userDTO [u=" + u + ", cuss=" + cuss + "]";
		}

		
		
		

	}


