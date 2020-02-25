package com.learning.springboot.Exception;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
