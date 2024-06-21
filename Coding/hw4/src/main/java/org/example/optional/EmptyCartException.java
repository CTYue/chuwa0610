package org.example.optional;

public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}
