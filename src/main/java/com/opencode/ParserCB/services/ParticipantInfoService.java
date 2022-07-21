package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.ParticipantInfo;
import com.opencode.ParserCB.repositories.ParticipantInfoRepo;
import com.opencode.ParserCB.services.exceptions.ParticipantInfoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantInfoService {
    private final ParticipantInfoRepo participantInfoRepo;

    public ParticipantInfoService(ParticipantInfoRepo participantInfoRepo) {
        this.participantInfoRepo = participantInfoRepo;
    }

    public void save(ParticipantInfo participantInfo) {
        participantInfoRepo.save(participantInfo);
    }

    public void update(ParticipantInfo participantInfo) {
        participantInfoRepo.save(participantInfo);
    }

    public ParticipantInfo find(int id) throws ParticipantInfoNotFoundException {
        return participantInfoRepo.findById(id).orElseThrow(ParticipantInfoNotFoundException::new);
    }

    public List<ParticipantInfo> findAll(){
        return participantInfoRepo.findAll();
    }

    public void delete(ParticipantInfo participantInfo) {
        participantInfoRepo.delete(participantInfo);
    }
}
