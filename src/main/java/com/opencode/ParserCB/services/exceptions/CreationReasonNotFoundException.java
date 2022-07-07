package com.opencode.ParserCB.services.exceptions;

public class CreationReasonNotFoundException extends RuntimeException{
    public CreationReasonNotFoundException(){
        super("Creation reason was not found!");
    }

}
