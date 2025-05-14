import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';
import { Restaurant } from './restaurant.model';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  

  private apiUrl = 'http://localhost:8080/restaurant';  // Update URL if needed

  constructor(private http: HttpClient) { }

  getAllRestaurants(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getallrestaurants`).pipe(
      tap((data) => console.log('Fetched restaurants:', data)),
      catchError((error) => {
        console.error('Error fetching restaurants:', error);
        throw error;
      })
    );
  }
  searchRestaurants(query: string): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(`${this.apiUrl}/search?query=${query}`);
  }
}
