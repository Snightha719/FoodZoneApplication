package com.fooddelivery.foodapp.Exception;

public class RestaurantNotFound extends RuntimeException{
	public RestaurantNotFound(int rid) {
		super ("Restaurant with id " + rid + " not found");
	}
}