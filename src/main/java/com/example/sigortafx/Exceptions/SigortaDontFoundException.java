package com.example.sigortafx.Exceptions;

public class SigortaDontFoundException extends RuntimeException{
    public SigortaDontFoundException() {
        super("Sigorta bulunamadı");
    }
}
