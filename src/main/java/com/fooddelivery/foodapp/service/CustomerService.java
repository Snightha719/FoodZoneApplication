package com.fooddelivery.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.Entity.login;
import com.fooddelivery.foodapp.response.LoginMessage;
import com.fooddelivery.foodapp.serviceImpl.CustomerServiceImpl;

@Service
public interface CustomerService {
	
	public LoginMessage addCustomer(Customer c);
	
	public Customer getCustomerById(int id);
	
	public LoginMessage updateCustomer(int id, Customer c);
	
	public boolean deleteCustomerById(int id);
	
	public List<Customer> getAllCustomers();
	
	LoginMessage loginCustomer(login l);
	
//	public boolean authenticateCustomer(Customer customer);
}
