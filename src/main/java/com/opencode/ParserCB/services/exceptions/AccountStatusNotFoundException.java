package com.opencode.ParserCB.services.exceptions;

public class AccountStatusNotFoundException extends RuntimeException{
    public AccountStatusNotFoundException(){
        super("Account Status was not found!");
    }
}
