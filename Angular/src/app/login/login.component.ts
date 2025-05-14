import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  showLogin= true;
  
  constructor(private router: Router, private http: HttpClient) { }

  closeLogin(): void {
    this.showLogin = false;
  }

  // Method to handle the login form submission
  

  Login() {
    let bodyData = {
      email: this.email,
      password: this.password,
    };
    
    this.http.post("http://localhost:8080/customer/login", bodyData).subscribe((resultData: any) =>{
      if(resultData.message=== "Email dosen't exist")
      {
        alert("Email dosen't exist");
      }
      else if(resultData.message === "Login success")
      {
        alert("Login success");
        this.router.navigate(['/mainhome']);
      }
      else{
        alert("credentials are incorrect");
      }
    });
  }
  
}