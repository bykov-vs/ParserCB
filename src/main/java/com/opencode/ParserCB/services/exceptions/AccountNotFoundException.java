package com.opencode.ParserCB.services.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(){
        super("Account was not found!");
    }
}
