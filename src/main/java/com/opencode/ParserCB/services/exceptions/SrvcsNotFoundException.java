package com.opencode.ParserCB.services.exceptions;

public class SrvcsNotFoundException extends RuntimeException{
    public SrvcsNotFoundException(){
        super("Srvcs was not found!");
    }
}
