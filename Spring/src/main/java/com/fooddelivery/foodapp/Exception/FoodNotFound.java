package com.fooddelivery.foodapp.Exception;

public class FoodNotFound extends RuntimeException{
	public FoodNotFound(int id) {
		super ("food with id " + id + " not found");
	}
}