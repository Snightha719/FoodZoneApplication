package com.fooddelivery.foodapp.Exception;

public class CartAlreadyHasFood extends RuntimeException{
	public CartAlreadyHasFood() {
		super ("Food has been already added to the cart");
	}
}