package com.opencode.ParserCB.services.exceptions;

public class SwBicsNotFoundException extends RuntimeException{
    public SwBicsNotFoundException(){
        super("Sw bics was not found!");
    }
}
