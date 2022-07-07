package com.opencode.ParserCB.services.exceptions;

public class PtTypeNotFoundException extends RuntimeException{
    public PtTypeNotFoundException(){
        super("Pt type was not found!");
    }
}
