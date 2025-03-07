package com.fooddelivery.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//import org.springframework.web.service.annotation.PutExchange;
import com.fooddelivery.foodapp.Entity.login;

import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.response.LoginMessage;
import com.fooddelivery.foodapp.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer c) {
		LoginMessage lm = cs.addCustomer(c);
		return ResponseEntity.ok(lm);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody login l) {
		LoginMessage lm = cs.loginCustomer(l);
		return ResponseEntity.ok(lm);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		try {
            Customer c = cs.getCustomerById(id);
            return ResponseEntity.status(HttpStatus.OK).body(c);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<LoginMessage> updateCustomerById(@PathVariable int id,@RequestBody Customer c) {
		try {
            LoginMessage updatedCustomer = cs.updateCustomer(id, c);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
		try {
            cs.deleteCustomerById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
	}
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> l = cs.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(l);
	}
}