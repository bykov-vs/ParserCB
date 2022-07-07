package com.opencode.ParserCB.services.exceptions;

public class RstrNotFoundException extends RuntimeException{
    public RstrNotFoundException(){
        super("Rstr was not found!");
    }
}
