package com.spring.rest.dto;

public class bookingDTO {
	
	private int booking_id;
	private String room_type;
	private String check_in;
	private String check_out;
	private String status;
	private int cid;
	private int hid;
	public bookingDTO() {
		super();
	}
	public bookingDTO(int booking_id, String room_type, String check_in, String check_out, String status, int cid,
			int hid) {
		super();
		this.booking_id = booking_id;
		this.room_type = room_type;
		this.check_in = check_in;
		this.check_out = check_out;
		this.status = status;
		this.cid = cid;
		this.hid = hid;
	}
	
	
	public bookingDTO(int booking_id, String room_type, String check_in, String check_out, String status) {
		super();
		this.booking_id = booking_id;
		this.room_type = room_type;
		this.check_in = check_in;
		this.check_out = check_out;
		this.status = status;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	
	

}
