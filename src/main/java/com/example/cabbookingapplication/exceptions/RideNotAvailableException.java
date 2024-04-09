package com.example.cabbookingapplication.exceptions;


public class RideNotAvailableException extends Exception {
    public RideNotAvailableException() {
        super("The ride selected is not available, try again.");
    }
}
