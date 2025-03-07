package com.fooddelivery.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.foodapp.Entity.Cart;
import com.fooddelivery.foodapp.Entity.Customer;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	Cart findCartByCus(Customer cus);

}