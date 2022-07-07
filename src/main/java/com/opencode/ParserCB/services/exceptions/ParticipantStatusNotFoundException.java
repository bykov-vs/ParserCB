package com.opencode.ParserCB.services.exceptions;

public class ParticipantStatusNotFoundException extends RuntimeException{
    public ParticipantStatusNotFoundException(){
        super("Participant status was not found!");
    }
}
