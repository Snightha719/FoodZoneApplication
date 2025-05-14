import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, switchMap } from 'rxjs';

import { Food } from '../food/food.model';
import { Cart } from './cart.model';


@Injectable({
  providedIn: 'root'
})
export class CartService {

  private apiUrl = 'http://localhost:8080/cart';  // Your API URL

  constructor(private http: HttpClient) { }

  // Add food to the cart
  addFoodToCart(foodId: number): Observable<Cart> {
    // Get the customerId from localStorage
    const customerId = localStorage.getItem('customerId');  // Assuming the customerId is stored in localStorage

    if (!customerId) {
        throw new Error('Customer ID not found!');
    }

    // Get the cartId based on the customerId from the backend
    return this.http.get<Cart>(`${this.apiUrl}/getcartbycustomerid/${customerId}`).pipe(
        // Use the cartId to add the food to the cart
        switchMap((cart: Cart) => {
            const cartId = cart.cartid;

            // Now add the food to the cart using the cartId and foodId
            return this.http.post<Cart>(`${this.apiUrl}addfoodtocart/${cartId}/${foodId}`, {});
        })
    );
}


  // Get all foods from the cart
  getFoodsFromCart(cartId: number): Observable<Food[]> {
    return this.http.get<Food[]>(`${this.apiUrl}getallfoods/${cartId}`);
  }

  getCartByCustomerId(customerId: number): Observable<Cart> {
    return this.http.get<Cart>(`${this.apiUrl}getcartbycustomerid/${customerId}`);
  }

  deleteFoodFromCart(cartId: number, foodId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/deletefood/${cartId}/${foodId}`);
  }

  // You can also implement other cart-related API calls as needed
}
