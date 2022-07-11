package com.opencode.ParserCB.services.exceptions;

public class CodeAlreadyExistsException extends RuntimeException{
    public CodeAlreadyExistsException(){
        super("Code already exists!");
    }
}
