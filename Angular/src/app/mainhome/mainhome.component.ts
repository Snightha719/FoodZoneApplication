import { Component, OnInit } from '@angular/core';
import { FoodService } from '../food/food.service';
import { RestaurantService } from '../restaurant/restaurant.service';
import { CartService } from '../cart/cart.service';
import { Observable, of } from 'rxjs';


@Component({
  selector: 'app-mainhome',
  templateUrl: './mainhome.component.html',
  styleUrls: ['./mainhome.component.css']
})
export class MainhomeComponent implements OnInit {
  query: string = ''; // Binding the input field
  searchResults: any[] = [];  // Store the search results
  foods$: Observable<any[]> = of([]);
  isSearchActive: boolean = false;  // This controls the visibility of navbar and food grid
  noResultsFound: boolean = false;


  constructor(
    private foodService: FoodService,
    private restaurantService: RestaurantService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {}


  
  addToCart(foodId: number): void {
    this.cartService.addFoodToCart(foodId).subscribe(
      (response: any) => {
        console.log('Food added to cart', response);
        alert('Food added to cart!');
      },
      (error: any) => {
        console.error('Error adding food to cart', error);
        alert('Error adding food to cart!');
      }
    );
  }


  // Method for initiating the search
  onSearch() {
    this.isSearchActive = true;  // Set search state to active
    this.searchResults = []; // Clear previous search results
    this.noResultsFound = false; // Reset no results flag

    // Search for foods first
    this.searchFoods(this.query);

    // Then search for restaurants only if no food matches were found
    if (this.searchResults.length === 0) {
      this.searchRestaurants(this.query);
    }

    // If no results found in both foods and restaurants, show "No results"
    if (this.searchResults.length === 0) {
      this.noResultsFound = true;
    }
  }

  // Search Foods method
  searchFoods(query: string): void {
    if (query) {
      this.foodService.searchFoods(query).subscribe(
        (foods: any[]) => {
          const foodMatches = foods.filter(food => food.name.toLowerCase().includes(query.toLowerCase()));
          if (foodMatches.length > 0) {
            this.searchResults.push(...foodMatches);
          }
        },
        (error: any) => {
          console.error('Error searching foods:', error);
        }
      );
    }
  }

  // Search Restaurants method
  searchRestaurants(query: string): void {
    if (query) {
      this.restaurantService.searchRestaurants(query).subscribe(
        (restaurants: any[]) => {
          const restaurantMatches = restaurants.filter(restaurant => restaurant.name.toLowerCase().includes(query.toLowerCase()));
          if (restaurantMatches.length > 0) {
            this.searchResults.push(...restaurantMatches);
          }
        },
        (error: any) => {
          console.error('Error searching restaurants:', error);
        }
      );
    }
  }
}
