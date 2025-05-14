import { Component, OnInit } from '@angular/core';
import { FoodService } from './food.service';
import { Food } from './food.model';
import { Observable } from 'rxjs';
import { CartService } from '../cart/cart.service';

@Component({
  selector: 'app-food',
  templateUrl: './food.component.html',
  styleUrls: ['./food.component.css']
})
export class FoodComponent implements OnInit {
  isFoodGridVisible: boolean = true; 
  foods$: Observable<any[]> = new Observable<any[]>();

  constructor(private foodService: FoodService, private cartService: CartService) {}

  ngOnInit(): void {
    this.foods$ = this.foodService.getAllFoods();  // Directly assign the observable to foods$
  }

  async addToCart(foodId: number): Promise<void> {
    try {
      const response = await this.cartService.addFoodToCart(foodId);  // Await the promise from the service
      console.log('Food added to cart', response);
      alert('Food added to cart!');
    } catch (error) {
      console.error('Error adding food to cart', error);
      alert('Error adding food to cart!');
    }
  }
  closeFoodGrid() {
    this.isFoodGridVisible = false;  // Hide the food grid when the cross button is clicked
  }
}
