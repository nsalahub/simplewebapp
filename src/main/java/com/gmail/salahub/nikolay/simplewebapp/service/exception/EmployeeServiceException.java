package com.gmail.salahub.nikolay.simplewebapp.service.exception;

public class EmployeeServiceException extends RuntimeException {
    public EmployeeServiceException(String message, Throwable e) {
        super(message, e);
    }
}
