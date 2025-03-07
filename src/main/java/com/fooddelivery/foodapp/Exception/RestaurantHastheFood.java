package com.fooddelivery.foodapp.Exception;

public class RestaurantHastheFood extends RuntimeException{
	public RestaurantHastheFood(String name) {
		super ("Restaurant has already the food named " + name);
	}
}