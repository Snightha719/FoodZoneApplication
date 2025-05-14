import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer.model';  // Assuming you have a Customer model
import { tap, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  // Update this URL to your actual backend URL
  private apiUrl = 'http://localhost:8080/api/customers';  

  constructor(private http: HttpClient) { }

  // Method to fetch all customer details
  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.apiUrl}/getallcustomers`).pipe(
      tap((data) => console.log('Fetched customers:', data)),  // Logging the fetched data
      catchError((error) => {
        console.error('Error fetching customers:', error);  // Handling error
        throw error;
      })
    );
  }

  // Method to get a single customer by ID
  getCustomerProfile(id: number): Observable<Customer> {
    return this.http.get<Customer>(`${this.apiUrl}/${id}`).pipe(
      tap((data) => console.log('Fetched customer profile:', data)),  // Logging the fetched customer
      catchError((error) => {
        console.error('Error fetching customer profile:', error);  // Handling error
        throw error;
      })
    );
  }

  // Method to update customer details
  updateCustomerProfile(id: number, customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.apiUrl}/update/${id}`, customer).pipe(
      tap((data) => console.log('Updated customer profile:', data)),  // Logging the updated data
      catchError((error) => {
        console.error('Error updating customer profile:', error);  // Handling error
        throw error;
      })
    );
  }
}
