package com.fooddelivery.foodapp.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int rid;
	String name;
	String address;
	int phonenumber;
	String imageUrl;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Food> food;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Restaurant(int rid, String name, String address, int phonenumber, String imageUrl, List<Food> food) {
		super();
		this.rid = rid;
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.imageUrl = imageUrl;
		this.food = food;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", name=" + name + ", address=" + address + ", phonenumber=" + phonenumber
				+ ", imageUrl=" + imageUrl + ", food=" + food + "]";
	}
	
}