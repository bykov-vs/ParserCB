package com.opencode.ParserCB.services.exceptions;

public class XchTypeNotFoundException extends RuntimeException{
    public XchTypeNotFoundException(){
        super("Xch type was not found!");
    }
}
