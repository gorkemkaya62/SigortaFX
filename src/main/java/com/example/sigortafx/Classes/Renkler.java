package com.example.sigortafx.Classes;

public class Renkler {
    private static final Renkler instance = new Renkler();
    public String Black     = "\u001b[30m" ;
    public String Red       = "\u001b[31m" ;
    public String Green     = "\u001b[32m" ;
    public String Yellow    = "\u001b[33m" ;
    public String Blue      = "\u001b[34m" ;
    public String Magenta   = "\u001b[35m" ;
    public String Cyan      = "\u001b[36m" ;
    public String White     = "\u001b[37m" ;
    public String Reset     = "\u001b[0m" ;

    public static Renkler getInstance() {
        return instance;
    }
}
