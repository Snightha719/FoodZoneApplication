package com.fooddelivery.foodapp.Exception;

public class NoFoodInCart extends RuntimeException{

	public NoFoodInCart() {
		super ("Food not found");
	}
}