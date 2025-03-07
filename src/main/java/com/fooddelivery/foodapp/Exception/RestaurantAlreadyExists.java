package com.fooddelivery.foodapp.Exception;

public class RestaurantAlreadyExists extends RuntimeException{
	public RestaurantAlreadyExists() {
		super ("restaurant with the provided phonenumber already exists");
	}
}