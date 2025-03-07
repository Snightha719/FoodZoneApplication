package com.fooddelivery.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.foodapp.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	public Restaurant findByphonenumber(int phonenumber);
	public Restaurant findByRid(int rid);
	public List<Restaurant> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String query, String query2);
}