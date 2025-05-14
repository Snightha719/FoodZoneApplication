import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AboutComponent } from './about/about.component';
import { FoodComponent } from './food/food.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { MainhomeComponent } from './mainhome/mainhome.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './profile/profile.component';
import { CustomerComponent } from './customer/customer.component';
import { CartComponent } from './cart/cart.component';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {path: 'mainhome', component: MainhomeComponent},
  {path: 'about', component:AboutComponent},
  {path: 'food', component:FoodComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'restaurant', component: RestaurantComponent},
  {path: 'profile', component:ProfileComponent},
  {path: 'cart', component:CartComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    AboutComponent,
    FoodComponent,
    RestaurantComponent,
    MainhomeComponent,
    ProfileComponent,
    CustomerComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
