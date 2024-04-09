package com.example.cabbookingapplication.exceptions;

public class DriverAlreadyRegisteredException extends Exception{
    public DriverAlreadyRegisteredException() {
        super("Driver with same phone number already registered.");
    }
}
