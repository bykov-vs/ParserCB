package com.opencode.ParserCB.services.exceptions;

public class RstrListNotFoundException extends RuntimeException{
    public RstrListNotFoundException(){
        super("Rstr list was not found!");
    }

}
