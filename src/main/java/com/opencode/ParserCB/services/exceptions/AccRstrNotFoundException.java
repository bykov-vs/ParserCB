package com.opencode.ParserCB.services.exceptions;

public class AccRstrNotFoundException extends RuntimeException{
    public AccRstrNotFoundException(){
        super("Acc rstr was not found!");
    }

}
