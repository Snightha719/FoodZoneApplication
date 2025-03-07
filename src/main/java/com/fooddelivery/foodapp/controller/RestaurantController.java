package com.fooddelivery.foodapp.controller;

import java.util.List;

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

import com.fooddelivery.foodapp.Entity.Restaurant;
import com.fooddelivery.foodapp.service.RestaurantService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService rs;
	
	@GetMapping("/restaurants/search")
    public List<Restaurant> searchRestaurants(@RequestParam String query) {
        // Call the RestaurantService to search for restaurants based on the query
        return rs.searchRestaurants(query);
    }
	
	@PostMapping("/addrestaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant r) {
		return rs.addrestaurant(r);
	}
	
	@GetMapping("/getresbyid/{rid}")
	public Restaurant getRestaurantById(@PathVariable int rid) {
		return rs.getRestaurantById(rid);
	}
	
	@PutMapping("/updateresbyid/{rid}")
	public Restaurant updateRestaurantById(@PathVariable int rid, @RequestBody Restaurant r) {
		return rs.updateRestaurantById(rid, r);
	}
	
	@DeleteMapping("/deleteresbyid/{rid}")
	public boolean deleteRestaurantById(@PathVariable int rid) {
		rs.deleteRestaurant(rid);
		return true;
	}
	
	@GetMapping("/getallrestaurants")
	public List<Restaurant> getAllRestaurants(){
		List<Restaurant> l = rs.getAllRestaurants();
		return l;
	}
}