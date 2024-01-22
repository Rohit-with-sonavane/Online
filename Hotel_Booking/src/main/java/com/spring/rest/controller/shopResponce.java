package com.spring.rest.controller;

public class shopResponce {
	static enum Status{
		success,error;
	}
	private Status status;
	private Object data;
	private String error;
	
	public shopResponce(Status status, Object data, String error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public shopResponce() {
		super();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public static shopResponce success(Object data)
	{
		shopResponce res= new shopResponce(Status.success,data,null);
		return res;
	}
	
	public static shopResponce error(String error) {
		shopResponce res= new shopResponce(Status.error, null, error);
		return res;
	}
	
	
	

}
