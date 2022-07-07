package com.opencode.ParserCB.services.exceptions;

public class AccRstrListNotFoundException extends RuntimeException{
    public AccRstrListNotFoundException() {
        super("Acc Rstr List was not found!");
    }
}
