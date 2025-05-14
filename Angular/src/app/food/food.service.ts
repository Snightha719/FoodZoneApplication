import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, tap } from 'rxjs';
import { Food } from './food.model';

@Injectable({
  providedIn: 'root'
})
export class FoodService {


  private apiUrl = 'http://localhost:8080/api/foods';  // Update URL if needed

  constructor(private http: HttpClient) { }

  getAllFoods(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getallfoods`).pipe(
      tap((data) => console.log('Fetched foods:', data)),
      catchError((error) => {
        console.error('Error fetching foods:', error);
        throw error;
      })
    );
  }
  getFoodsByRestaurantId(rid: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getfoodbyrid/${rid}`);
  }
  
  searchFoods(query: string): Observable<Food[]> {
    return this.http.get<Food[]>(`${this.apiUrl}/search?query=${query}`);
  }
  
}
