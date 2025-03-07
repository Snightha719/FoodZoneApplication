package com.fooddelivery.foodapp.Exception;

public class CustomerNotFound extends RuntimeException{
	public CustomerNotFound(int id) {
        super("Customer with ID " + id + " not found");
    }
}
