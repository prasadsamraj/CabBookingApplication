package com.example.cabbookingapplication.exceptions;

public class NoDriversAvailableException extends Exception {
    public NoDriversAvailableException() {
        super("No drivers available.");
    }
}
