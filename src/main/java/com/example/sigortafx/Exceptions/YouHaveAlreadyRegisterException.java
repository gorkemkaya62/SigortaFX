package com.example.sigortafx.Exceptions;

public class YouHaveAlreadyRegisterException extends RuntimeException{
    public YouHaveAlreadyRegisterException() {
        super("Bu sigorta kaydınız bulunmaktadır.");
    }
}
