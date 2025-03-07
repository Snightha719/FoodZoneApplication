package com.fooddelivery.foodapp.response;

public class LoginMessage {
	String message;
	boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LoginMessage(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public LoginMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginMessage [message=" + message + ", status=" + status + "]";
	}
	
	
}