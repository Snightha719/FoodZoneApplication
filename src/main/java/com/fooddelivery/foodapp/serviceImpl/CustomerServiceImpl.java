package com.fooddelivery.foodapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fooddelivery.foodapp.Entity.Customer;
import com.fooddelivery.foodapp.Entity.login;
import com.fooddelivery.foodapp.Exception.CustomerAlreadyExists;
import com.fooddelivery.foodapp.Exception.CustomerNotFound;
import com.fooddelivery.foodapp.repository.CustomerRepository;
import com.fooddelivery.foodapp.response.LoginMessage;
import com.fooddelivery.foodapp.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository cr;

	@Override
	public LoginMessage addCustomer(Customer c) {
		String msg = "";
		Customer c2 = cr.findByEmail(c.getEmail());
		if(c2!=null) {
			return new LoginMessage("Email already exists", false);
		}
			Customer c4 = cr.save(c);
			return new LoginMessage("User Registered Successfully", true);
		}

	@Override
	public Customer getCustomerById(int id) throws CustomerNotFound{
		Optional<Customer> opt = cr.findById(id);
		if(opt.isPresent()) {
		Customer cus1= opt.get();
		return cus1;
		}
		else {
			throw new CustomerNotFound(id);
		}
	}

	@Override
	public LoginMessage updateCustomer(int id, Customer c) {
		Optional<Customer> c2 = cr.findById(id);
		if(c2.isPresent()) {
			Customer c3 = c2.get();
			c3.setEmail(c.getEmail());
			c3.setName(c.getName());
			c3.setPassword(c.getPassword());
		Customer cus2 = cr.save(c);
		return new LoginMessage("Profile updated successfully", true);
		}
		else {
			return new LoginMessage("Customer Not Found", false);
		}
	}

	@Override
	public boolean deleteCustomerById(int id) throws CustomerNotFound{
		Optional<Customer> opt2 = cr.findById(id);
		if(opt2.isPresent()) {
			Customer c4 = opt2.get();
			cr.delete(c4);
			return true;
		}
		else {
			throw new CustomerNotFound(id);
		}
		}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> l = cr.findAll();
		return l;
	}

	@Override
	public LoginMessage loginCustomer(login l) {
		// TODO Auto-generated method stub
		String msg = "";
		Customer c = cr.findByEmail(l.getEmail());
		if(c!=null) {
			String password = l.getPassword();
			if(password.equals(c.getPassword())) {
				Optional<Customer> c1= cr.findOneByEmailAndPassword(l.getEmail(), l.getPassword());
						if(c1.isPresent()) {
							return new LoginMessage("Login success", true);
						}
						else {
							return new LoginMessage("Login Failed", false);
						}
			}
			else {
				return new LoginMessage("password dosen't match", false);
			}
		}
		else {
			return new LoginMessage("email dosen't exist", false);
						}
			}
}

//	@Override
//	public boolean authenticateCustomer(Customer customer) {
//	    Customer existingCustomer = cr.findByEmail(customer.getEmail());
//	    if (existingCustomer == null) {
//	        return false;
//	    }
//	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Create instance of PasswordEncoder
//	    return passwordEncoder.matches(customer.getPassword(), existingCustomer.getPassword());
//	}
