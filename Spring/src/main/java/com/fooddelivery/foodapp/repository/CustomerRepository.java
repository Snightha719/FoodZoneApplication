package com.fooddelivery.foodapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fooddelivery.foodapp.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public Customer findByEmail(String email);
	
	Optional<Customer> findOneByEmailAndPassword(String email, String password);

}
