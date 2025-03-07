package com.fooddelivery.foodapp.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String description;
	int price;
	String type;
	String imageUrl;
	
	@ManyToOne(fetch = FetchType.EAGER)
//	@JsonIgnore //getting error while trying to save res details along with food
    @JoinColumn(name = "r_id") 
    private Restaurant restaurant;
	
	@ManyToMany(mappedBy = "f")
//	@JoinColumn(name = "cartid")
//	@JsonIgnore
    private List<Cart> cart;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

//	public List<Cart> getCart() {
//		return cart;
//	}
//
//	public void setCart(List<Cart> cart) {
//		this.cart = cart;
//	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	public Food(int id, String name, String description, int price, String type, String imageUrl, Restaurant restaurant,
			List<Cart> cart) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.imageUrl = imageUrl;
		this.restaurant = restaurant;
//		this.cart = cart;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", type="
				+ type + ", imageUrl=" + imageUrl + ", restaurant=" + restaurant + "]";
	}

	
}