package com.fooddelivery.foodapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Restaurant;
import com.fooddelivery.foodapp.Exception.RestaurantAlreadyExists;
import com.fooddelivery.foodapp.Exception.RestaurantNotFound;
import com.fooddelivery.foodapp.repository.RestaurantRepository;
import com.fooddelivery.foodapp.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository rr;

	@Override
	public Restaurant addrestaurant(Restaurant r) throws RestaurantAlreadyExists{
		Restaurant res = rr.findByphonenumber(r.getPhonenumber());
		if(res==null) {
		rr.save(r);
		return r;
		}
		else {
			throw new RestaurantAlreadyExists();
		}
	}

	@Override
	public Restaurant getRestaurantById(int rid) throws RestaurantNotFound{
		Optional<Restaurant> opt = rr.findById(rid);
		if(opt.isPresent()) {
			Restaurant r1 = opt.get();
		return r1;
		}
		else {
			throw new RestaurantNotFound(rid);
		}
	}

	@Override
	public Restaurant updateRestaurantById(int rid, Restaurant r) throws RestaurantNotFound{
		Optional<Restaurant> opt1 = rr.findById(rid);
		if(opt1.isPresent()) {
			Restaurant r2 = opt1.get();
		r2.setAddress(r.getAddress());
//		r2.setFood(r.getFood());
		r2.setName(r.getName());
		r2.setPhonenumber(r.getPhonenumber());
		rr.save(r2);
		return r2;
		}
		else {
			throw new RestaurantNotFound(rid);
		}
	}

	@Override
	public boolean deleteRestaurant(int rid) throws RestaurantNotFound{
		Optional<Restaurant> opt3 = rr.findById(rid);
		if(opt3.isPresent()) {
			Restaurant r = opt3.get();
		rr.delete(r);
		return true;
		}
		else {
			throw new RestaurantNotFound(rid);
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> l = rr.findAll();
		return l;
	}
	
	@Override
	public List<Restaurant> searchRestaurants(String query) {
        return rr.findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(query, query);
    }
}