package com.opencode.ParserCB.services.exceptions;

public class BicDirectoryEntryNotFoundException extends RuntimeException{
    public BicDirectoryEntryNotFoundException() {
        super("Bic Directory Entry was not found!");
    }
}
