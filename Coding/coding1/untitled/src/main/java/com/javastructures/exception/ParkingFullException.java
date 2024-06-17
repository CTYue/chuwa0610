package com.javastructures.exception;

// throw an exception when parking lot is full
public class ParkingFullException extends Exception {
    public ParkingFullException(String message) {
        super(message);
    }
}
