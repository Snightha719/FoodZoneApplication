package com.fooddelivery.foodapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
// Handle CustomerAlreadyExists exception
	    @ExceptionHandler(CustomerAlreadyExists.class)
	    public ResponseEntity<Object> handleCustomerAlreadyExistsException(CustomerAlreadyExists ex) {
	        // Return a custom error response
	        String errorMessage = ex.getMessage(); // The message from the exception
	        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }

	    // Handle CustomerNotFound exception
	    @ExceptionHandler(CustomerNotFound.class)
	    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFound ex) {
	        String errorMessage = ex.getMessage(); // The message from the exception
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(RestaurantHastheFood.class)
	    public ResponseEntity<Object> handleRestauranthastheFoodException(RestaurantHastheFood rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(RestaurantAlreadyExists.class)
	    public ResponseEntity<Object> handleRestaurantAlreadyExistsException(RestaurantAlreadyExists rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(RestaurantNotFound.class)
	    public ResponseEntity<Object> handleRestaurantNotFoundException(RestaurantNotFound rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(FoodNotFound.class)
	    public ResponseEntity<Object> handleFoodNotFoundException(FoodNotFound rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(CartAlreadyHasFood.class)
	    public ResponseEntity<Object> handleCartAlreadyHasFoodException(CartAlreadyHasFood rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(NoFoodInCart.class)
	    public ResponseEntity<Object> handleNoFoodInCartException(NoFoodInCart rf) {
	    	String errorMessage = rf.getMessage();
	    	return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	    }

	    
	    // Handle other generic exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleGenericException(Exception ex) {
	        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
	        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}