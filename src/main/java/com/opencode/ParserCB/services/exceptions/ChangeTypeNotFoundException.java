package com.opencode.ParserCB.services.exceptions;

public class ChangeTypeNotFoundException extends RuntimeException{
    public ChangeTypeNotFoundException(){
        super("Change type was not found!");
    }
}
