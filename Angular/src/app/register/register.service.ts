import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

interface Customer {
  id: number;
  name: string;
  email: string;
}

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  private currentCustomerSubject: BehaviorSubject<Customer | null> = new BehaviorSubject<Customer | null>(null);
  public currentCustomer = this.currentCustomerSubject.asObservable();

  constructor() {}

  // Set customer data (for example after a successful login)
  setCustomer(customer: Customer): void {
    this.currentCustomerSubject.next(customer);
  }

  // Get the logged-in customer
  getCustomer(): Customer | null {
    return this.currentCustomerSubject.value;
  }

  // Get the logged-in customer ID
  getCustomerId(): number | null {
    const customer = this.getCustomer();
    return customer ? customer.id : null; // Return customer ID or null if not logged in
  }
}
