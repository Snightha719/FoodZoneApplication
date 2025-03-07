package com.fooddelivery.foodapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.Entity.Restaurant;
import com.fooddelivery.foodapp.Exception.FoodNotFound;
import com.fooddelivery.foodapp.Exception.RestaurantHastheFood;
import com.fooddelivery.foodapp.repository.FoodRepository;
import com.fooddelivery.foodapp.repository.RestaurantRepository;
import com.fooddelivery.foodapp.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	FoodRepository fr;
	@Autowired
	RestaurantRepository rr;

	@Override
	public Food addfood(Food f) throws RestaurantHastheFood{
		List<Food> r = fr.findByRestaurantRid(f.getRestaurant().getRid());
		List<String> l = fr.findNameByRid(f.getRestaurant().getRid());
		if(l.contains(f.getName())) {
			throw new RestaurantHastheFood(f.getName());
		}
		else {
			Food f1 = fr.save(f);
			return f1;
		}
	}

	@Override
	public Food getFoodById(int id) throws FoodNotFound{
		Optional<Food> opt = fr.findById(id);
		if(opt.isPresent()) {
		Food f2 = opt.get();
		return f2;
		}
		else {
			throw new FoodNotFound(id);
		}
	}

	@Override
	public Food updateFood(int id, Food f) throws FoodNotFound{
		Optional<Food> opt1= fr.findById(id);
//		Optional<Restaurant> opt2 = rr.findById(f.getRestaurant().getRid());
//		Restaurant r2 = opt2.get();
		if(opt1.isPresent()) {
		Food f3 = opt1.get();
		f3.setName(f.getName());
		f3.setPrice(f.getPrice());
//		f3.setRestaurant(r2);
		f3.setDescription(f.getDescription());
		f3.setType(f.getType());
		f3.setRestaurant(f.getRestaurant());
		f3.setImageUrl(f.getImageUrl());
		Food f4 = fr.save(f3);
		return f4;
		}
		else {
			throw new FoodNotFound(id);
		}
	}

	@Override
	public boolean deleteFood(int id) throws FoodNotFound{
		Optional<Food> opt3 = fr.findById(id);
		if(opt3.isPresent()) {
		Food f5 = opt3.get();
		fr.delete(f5);
		return true;
		}
		else {
			throw new FoodNotFound(id);
		}
	}

	@Override
	public List<Food> getAllFoodsByrid(int r_id) throws FoodNotFound{
		List<Food> l = fr.findByRestaurantRid(r_id);
		if(l.isEmpty()) {
			throw new FoodNotFound(r_id);
		}
		else {
		return l;
		}
	}
	
	@Override
	public List<Food> getAllFoods() {
		List<Food> l3 = fr.findAll();
		return l3;
	}
	
	@Override
	 public List<Food> searchFoods(String query) {
	        return fr.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
	    }
}