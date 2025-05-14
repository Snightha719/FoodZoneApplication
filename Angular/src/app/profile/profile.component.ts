import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Customer } from '../customer/customer.model';
import { AuthService } from '../login/login.service';
  // Assuming you have a Customer model

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  customer: Customer | null = null;  // To store customer profile data
  isEditMode: boolean = false;  // Flag to toggle between view and edit modes
  updatedCustomer: Customer = new Customer();  // To hold updated customer data
  customerId: number | null = null;

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    this.getCustomerProfile();  // Fetch the profile data on initialization
  }

  // Method to fetch the customer profile data from the backend
  getCustomerProfile(): void {
    // this.customerId = this.authService.getCustomerId(); 
    // This is just an example, you can fetch the ID from the logged-in user
    this.customerId = 1;
    this.http.get<Customer>(`http://localhost:8080/customer/getCustomer/${this.customerId}`).subscribe((resultData: any) => {
      if (resultData) {
        this.customer = resultData;  // Store fetched customer data
        this.updatedCustomer = { ...resultData };  // Copy the data to updatedCustomer
      }
    });
  }

  // Method to handle editing mode
  toggleEditMode(): void {
    this.isEditMode = !this.isEditMode;  // Toggle edit mode
  }

  // Method to handle profile update
  updateProfile(): void {
    const customerId = 1;  // This is just an example, you can fetch the ID from the logged-in user
    this.http.put(`http://localhost:8080/customer/updateCustomer/${customerId}`, this.updatedCustomer).subscribe((resultData: any) => {
      if (resultData.message === 'Profile updated successfully') {
        alert('Profile updated successfully');
        this.customer = { ...this.updatedCustomer };  // Update the profile with the new data
        this.toggleEditMode();  // Exit edit mode after updating
      } else {
        alert('Error updating profile');
      }
    });
  }

  // Method to go back to the main page
  goBack(): void {
    this.router.navigate(['/mainhome']);  // Redirect to the main home page or any desired page
  }
}
