package com.chuwa.redbook.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UniqueConstraintViolationException extends RuntimeException {
    private String fieldName;
    private String fieldValue;

    public UniqueConstraintViolationException(String fieldName, String fieldValue) {
        super(String.format("Duplicate value '%s' for field '%s'", fieldValue, fieldName));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }


    // Static helper methods to extract field name and value from the exception
    public static String extractDuplicateFieldFromException(DataIntegrityViolationException ex) {
        // Example logic to extract the field name from the exception message
        String message = ex.getMostSpecificCause().getMessage();
        if (message.contains("title")) {
            return "title";
        } else if (message.contains("content")) {
            return "content";
        } else if (message.contains("description")) {
            return "description";
        }
        return "unknown";
    }

    public static String extractDuplicateValueFromException(DataIntegrityViolationException ex) {
        // Example logic to extract the field value from the exception message
        // This is a placeholder and should be adjusted based on your actual exception message format
        String message = ex.getMostSpecificCause().getMessage();
        String value = message.split("'")[1]; // Extracting value between quotes
        return value;
    }
}
