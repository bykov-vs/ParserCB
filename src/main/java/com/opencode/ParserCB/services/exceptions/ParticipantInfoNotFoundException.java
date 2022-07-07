package com.opencode.ParserCB.services.exceptions;

public class ParticipantInfoNotFoundException extends RuntimeException{
    public ParticipantInfoNotFoundException(){
        super("Participant info was not found!");
    }
}
