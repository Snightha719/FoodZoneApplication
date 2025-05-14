import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  // Example: Get customerId after login (this could be from the backend or token)
  getCustomerId(): number {
    // Fetch the customerId from localStorage/sessionStorage
    return parseInt(localStorage.getItem('customerId') || '0', 10);
  }

  // Example: Set customerId after login
  setCustomerId(customerId: number): void {
    localStorage.setItem('customerId', customerId.toString());
  }
}

