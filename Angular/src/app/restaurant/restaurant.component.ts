import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';


import { Router } from '@angular/router';
import { FoodService } from '../food/food.service';
import { RestaurantService } from './restaurant.service';
import { Restaurant } from './restaurant.model';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {
  restaurant$: Observable<any[]> = new Observable<any[]>();  // Observable of restaurants data
  foods$!: Observable<any[]>;  // Observable of foods data
  selectedRestaurantId: number | null = null;  // To store selected restaurant ID
  selectedRestaurantName: string = '';  // To store selected restaurant name
  isRestaurantGridVisible: boolean = true; 
  isFoodModalOpen: boolean = false;

  constructor(
    private restaurantService: RestaurantService,
    private foodService: FoodService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.restaurant$ = this.restaurantService.getAllRestaurants();  // Fetch all restaurants on init
  }

  showFoodDetails(rid: number): void {
    this.selectedRestaurantId = rid;
    this.foods$ = this.foodService.getFoodsByRestaurantId(rid);  // Fetch foods for selected restaurant
  }

  closeRestaurantGrid() {
    this.isRestaurantGridVisible = false; // Hide the restaurant grid when the close button is clicked
  }
  openFoodModal(rid: number): void {
    this.selectedRestaurantId = rid;
    this.foods$ = this.foodService.getFoodsByRestaurantId(rid); // Assuming you have a method to fetch foods
    this.isFoodModalOpen = true;
  }

  // Close the food modal
  closeFoodModal(): void {
    this.isFoodModalOpen = false;
  }
}
