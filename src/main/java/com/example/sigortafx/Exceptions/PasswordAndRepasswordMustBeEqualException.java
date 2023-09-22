package com.example.sigortafx.Exceptions;

public class PasswordAndRepasswordMustBeEqualException extends RuntimeException{
    public PasswordAndRepasswordMustBeEqualException() {
        super("Password and re-password must be equal");
    }
}
