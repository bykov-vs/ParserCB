package com.opencode.ParserCB.services.exceptions;

public class RegulationAccountTypeNotFoundException extends RuntimeException{
    public RegulationAccountTypeNotFoundException(){
        super("Regulation account type was not found!");
    }
}
