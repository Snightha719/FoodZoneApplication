package com.fooddelivery.foodapp.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cartid;
	
	@OneToOne
	@JoinColumn(name = "c_id") 
	Customer cus;
	
	@ManyToMany
	@JoinTable(
		      name = "cart_food", 
		      joinColumns = @JoinColumn(name = "cart_id"), 
		      inverseJoinColumns = @JoinColumn(name = "f_id"))
	List<Food> f;
	
	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	

	public List<Food> getF() {
		return f;
	}

	public void setF(List<Food> f) {
		this.f = f;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartid, Customer cus, List<Food> f) {
		super();
		this.cartid = cartid;
		this.cus = cus;
		this.f = f;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", cus=" + cus + ", f=" + f + "]";
	}
}