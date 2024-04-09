package com.example.cabbookingapplication.exceptions;

public class CustomerAlreadyRegisteredException extends Exception{
    public CustomerAlreadyRegisteredException() {
        super("Customer with same phone number already registered.");
    }
}
