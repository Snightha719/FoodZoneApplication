import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  showLogin= true;
  name: string= '';
  email: string= '';
  password: string= '';

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
   
  }
  closeLogin(): void {
    this.showLogin = false;  // Close the login modal when clicking "Cancel"
  }
  
  save() {
    let bodyData = {
      "name": this.name,
      "email": this.email,
      "password": this.password
    };
    this.http.post("http://localhost:8080/customer/addCustomer", bodyData).subscribe((resultData: any)=>
    {
      if(resultData.message=== "Email already exists"){
      alert("Email already exists");
    }
    else{
      alert("Customer Registered Successfully")
    }
  });
  }

  
  // Custom validator to check if passwords match


}
