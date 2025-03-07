package com.fooddelivery.foodapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Cart;
import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.Entity.Food;
import com.fooddelivery.foodapp.Exception.CartAlreadyHasFood;
import com.fooddelivery.foodapp.Exception.CustomerNotFound;
import com.fooddelivery.foodapp.Exception.NoFoodInCart;
import com.fooddelivery.foodapp.repository.CartRepository;
import com.fooddelivery.foodapp.repository.CustomerRepository;
import com.fooddelivery.foodapp.repository.FoodRepository;
import com.fooddelivery.foodapp.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cr;
	@Autowired
	CustomerRepository cusr;
	@Autowired
	FoodRepository fr;
	
	@Override
	public Cart createCart(Cart cart) {
		return cr.save(cart);
	}
	
	@Override
	public Cart getCartBycartid(int cartid) {
		Optional<Cart> c = cr.findById(cartid);
		Cart c1 = c.get();
		return c1;
	}
	
	@Override
	public Cart getCartByCustomerId(int customerId) throws CustomerNotFound{
	    Optional<Customer> customer = cusr.findById(customerId);
	    if (customer.isPresent()) {
	        // Retrieve the customer's cart by customerId
	        Cart cart = cr.findCartByCus(customer.get());  // Assuming you have a method to get Cart by Customer
	        
	        return cart;
	    }
	    throw new CustomerNotFound(customerId);
	}


	@Override
	public Cart addFoodToCart(int cartid, int f_id) throws CartAlreadyHasFood{
		Optional<Food> f = fr.findById(f_id);
		Optional<Cart> c = cr.findById(cartid);
		Food f1 = f.get();
		Cart c1 = c.get();
//		c1.getF().add(f1);
		List<Food> list = new ArrayList();
		list.addAll(c1.getF());
		if(list.contains(f1)) {
			throw new CartAlreadyHasFood();
		}
		else {
		list.add(f1);
		c1.setF(list);
		cr.save(c1);
		return c1;
		}
	}

	@Override
	public boolean removeFoodFromCart(int cartid, int f_id) throws NoFoodInCart{
		Optional<Food> f = fr.findById(f_id);
		Optional<Cart> c = cr.findById(cartid);
		Food f1 = f.get();
		Cart c1 = c.get();
		List<Food> list = new ArrayList();
		list.addAll(c1.getF());
		if(list.contains(f1)) {
			list.remove(f1);
			c1.setF(list);
			cr.save(c1);
			return true;
		}
		else {
		throw new NoFoodInCart();
		}
	}

	@Override
	public List<Food> getAllFoodsFromCart(int cartid) throws NoFoodInCart{
		Optional<Cart> c = cr.findById(cartid);
//		if(c.isPresent()) {
		Cart c1 = c.get();
		List<Food> list = new ArrayList();
		list.addAll(c1.getF());
		if(list.isEmpty()) {
			throw new NoFoodInCart();
		}
//		}
		else {
		return list;
		}
	}
}