package com.example.cabbookingapplication.exceptions;

public class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException() {
        super("Customer Id is invalid.");
    }
}
