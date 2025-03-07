package com.fooddelivery.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fooddelivery.foodapp.Entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
	List<Food> findByRestaurantRid(int r_id);
	
	 @Query("SELECT f.name FROM Food f WHERE f.restaurant.rid = :rid")
	    List<String> findNameByRid(@Param("rid") int r_id);

	List<Food> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String query, String query2);
}