package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import com.opencode.ParserCB.entities.cbrf_reference.ParticipantStatus;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.ParticipantStatusRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.ParticipantStatusNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantStatusService {
    private final ParticipantStatusRepo participantStatusRepo;

    public ParticipantStatusService(ParticipantStatusRepo participantStatusRepo) {
        this.participantStatusRepo = participantStatusRepo;
    }

    public void save(ParticipantStatus participantStatus) {
        participantStatusRepo.save(participantStatus);
    }

    public void update(ParticipantStatus participantStatus) {
        participantStatusRepo.save(participantStatus);
    }

    public ParticipantStatus find(int id) throws ParticipantStatusNotFoundException {
        return participantStatusRepo.findById(id).orElseThrow(ParticipantStatusNotFoundException::new);
    }

    public List<ParticipantStatus> findAll(){
        return participantStatusRepo.findAll();
    }

    public void delete(ParticipantStatus participantStatus) {
        participantStatusRepo.delete(participantStatus);
    }

    public ParticipantStatus findByCode(String code) {
        return participantStatusRepo.findByCode(code);
    }
}
