package com.fooddelivery.foodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.foodapp.Entity.Cart;
import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.repository.CustomerRepository;
import com.fooddelivery.foodapp.serviceImpl.CartServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartServiceImpl csi;
	@Autowired
	CustomerRepository cusr;
	
	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart cart) {
		Optional<Customer> opt = cusr.findById(cart.getCus().getId());
		Customer c1 = opt.get();
		cart.setCus(c1);
		return csi.createCart(cart);
	}

	@GetMapping("getcartbycustomerid/{c_id}")
		public Cart getCartByCusId(@PathVariable int c_id) {
			return csi.getCartByCustomerId(c_id);
		}
	
	@GetMapping("/getcartbycartid/{cartid}") 
	public Cart getCartByCartId(@PathVariable int cartid) {
		return csi.getCartBycartid(cartid);
	}
	
	@PostMapping("/addfoodtocart/{cartid}/{foodid}")
	public Cart addFoodToCart(@PathVariable int cartid, @PathVariable int foodid) {
		return csi.addFoodToCart(cartid, foodid);
	}
	
	@DeleteMapping("/deletefood/{cartid}/{foodid}")
	public boolean deleteFoodFromCart(@PathVariable int cartid, @PathVariable int foodid) {
		return csi.removeFoodFromCart(cartid, foodid);
	}
	
	@GetMapping("/getallfoods/{cartid}")
	public List<Food> getAllFoodsFromCart(@PathVariable int cartid) {
		return csi.getAllFoodsFromCart(cartid);
	}
	
}