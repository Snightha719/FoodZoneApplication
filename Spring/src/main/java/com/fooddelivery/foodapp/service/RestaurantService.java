package com.fooddelivery.foodapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.Entity.Restaurant;

@Service
public interface RestaurantService {
	
	public Restaurant addrestaurant(Restaurant r);
	
	public Restaurant getRestaurantById(int rid);
	
	public Restaurant updateRestaurantById(int rid, Restaurant r);
	
	public boolean deleteRestaurant(int rid);
	
	public List<Restaurant> getAllRestaurants();
	
	public List<Restaurant> searchRestaurants(String query);
}