import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FoodService } from '../food/food.service';
import { CartService } from './cart.service';
import { Food } from '../food/food.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  foods$!: Observable<Food[]>;  // Observable of foods data
  selectedFoodId: number | null = null;  // To store selected food ID
  cartId!: number;
  foodsInCart: any[] = [];
  
  constructor(
    private foodService: FoodService,
    private cartService: CartService
  ) { }

  ngOnInit(): void {
    this.foods$ = this.foodService.getAllFoods();  // Fetch all foods on init
  }

  showFoodDetails(foodId: number): void {
    this.selectedFoodId = foodId;
    // You can implement functionality to fetch and display more detailed food information if necessary
  }

  addToCart(foodId: number): void {
    this.cartService.addFoodToCart(foodId).subscribe(
      (cart) => {
        alert('Food added to cart!');
        // Optionally update the UI or show the updated cart contents
      },
      (error) => {
        alert('Error adding food to cart!');
        console.error(error);
      }
    );
  }
  deleteFoodFromCart(foodId: number): void {
    this.cartService.deleteFoodFromCart(this.cartId, foodId).subscribe(
      () => {
        this.foodsInCart = this.foodsInCart.filter(food => food.id !== foodId); // Remove food from UI
      },
      error => {
        console.error('Error deleting food from cart', error);
      }
    );
  }
}
