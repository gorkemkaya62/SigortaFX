package com.example.sigortafx.Exceptions;

public class EmailMustBeTypeEmailException extends RuntimeException{
    public EmailMustBeTypeEmailException() {
        super("You have to enter type of email (@gmail, @hotmail...)");
    }
}
