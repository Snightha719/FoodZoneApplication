package com.fooddelivery.foodapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Food;

@Service
public interface FoodService {
	
	public Food addfood(Food f);
	
	public Food getFoodById(int id);
	
	public Food updateFood(int id, Food f);
	
	public boolean deleteFood(int id);
	
	public List<Food> getAllFoodsByrid(int r_id);
	
	public List<Food> getAllFoods();
	
	public List<Food> searchFoods(String query);
}