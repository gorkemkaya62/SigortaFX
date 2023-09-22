package com.example.sigortafx.Exceptions;

public class AllFieldsCanNotBeNullException extends RuntimeException{
    public AllFieldsCanNotBeNullException() {
        super("All field must be full");
    }
}
