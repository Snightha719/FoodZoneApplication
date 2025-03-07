package com.fooddelivery.foodapp.Exception;

public class CustomerAlreadyExists extends RuntimeException{
	public CustomerAlreadyExists(String email) {
		super ("Customer with id " + email + " already exists");
	}

}