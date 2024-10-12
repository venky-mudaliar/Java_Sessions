package com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
