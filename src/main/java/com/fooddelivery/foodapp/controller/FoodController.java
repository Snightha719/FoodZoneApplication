package com.fooddelivery.foodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.Entity.Restaurant;
import com.fooddelivery.foodapp.repository.RestaurantRepository;
import com.fooddelivery.foodapp.service.FoodService;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "http://localhost:4200")
public class FoodController {
	
	@Autowired
	FoodService fs;
	@Autowired
	RestaurantRepository rr;
	
	@GetMapping("/search")
    public List<Food> searchFoods(@RequestParam String query) {
        // Call the FoodService to search for foods based on the query
        return fs.searchFoods(query);
    }
	
	@PostMapping("/addfood")
	public Food addfood(@RequestBody Food f) {
		Optional<Restaurant> r = rr.findById(f.getRestaurant().getRid());
		Restaurant r1= r.get();
		f.setRestaurant(r1);
		return fs.addfood(f);
	}
	
	@GetMapping("/getfoodbyid/{id}")
	public Food getFoodById(@PathVariable int id) {
		return fs.getFoodById(id);
	}
	
	@PutMapping("/updatefood/{id}")
	public Food updateFoodById(@PathVariable int id, @RequestBody Food f) {
		Optional<Restaurant> opt = rr.findById(f.getRestaurant().getRid());
		Restaurant r1 = opt.get();
		f.setRestaurant(r1);
		return fs.updateFood(id, f);
	}
	
	@DeleteMapping("/deletefood/{id}")
	public boolean deleteFoodById(@PathVariable int id) {
		fs.deleteFood(id);
		return true;
	}
	
	@GetMapping("/getfoodbyrid/{r_id}")
	public List<Food> getFoodByRid(@PathVariable int r_id) {
		List<Food> l = fs.getAllFoodsByrid(r_id);
		return l;
	}
	
	@GetMapping("/getallfoods")
	public List<Food> getAllFoods(){
		List<Food> l1 = fs.getAllFoods();
		return l1;
	}
}