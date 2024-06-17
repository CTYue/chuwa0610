package com.javastructures.exception;

// the exception will be thrown if the vehicle to be unparked cannot be found in the parking lot;
public class InvalidVehicleNumberException extends Exception {
    public InvalidVehicleNumberException(String s) {
        super(s);
    }
}
