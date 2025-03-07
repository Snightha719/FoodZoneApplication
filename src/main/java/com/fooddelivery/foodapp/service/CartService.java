package com.fooddelivery.foodapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Cart;
import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.Exception.CustomerNotFound;

@Service
public interface CartService {
	
	public Cart createCart(Cart cart);
	
	public Cart getCartBycartid(int cartid);
	
	public Cart addFoodToCart(int cartid, int f_id);
	
	public boolean removeFoodFromCart(int cartid, int f_id);
	
	public List<Food> getAllFoodsFromCart(int cartid);
	
	public Cart getCartByCustomerId(int customerId);
	
}