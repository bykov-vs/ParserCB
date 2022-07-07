package com.opencode.ParserCB.services.exceptions;

public class InfoTypeCodeNotFoundException extends RuntimeException{
    public InfoTypeCodeNotFoundException(){
        super("Info type code was not found!");
    }
}
