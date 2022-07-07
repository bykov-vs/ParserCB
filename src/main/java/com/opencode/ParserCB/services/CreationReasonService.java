package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.CreationReason;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.CreationReasonRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.CreationReasonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreationReasonService {
    private final CreationReasonRepo creationReasonRepo;

    public CreationReasonService(CreationReasonRepo creationReasonRepo) {
        this.creationReasonRepo = creationReasonRepo;
    }

    public void save(CreationReason creationReason) {
        creationReasonRepo.save(creationReason);
    }

    public void update(CreationReason creationReason) {
        creationReasonRepo.save(creationReason);
    }

    public CreationReason find(int id) throws CreationReasonNotFoundException {
        return creationReasonRepo.findById(id).orElseThrow(CreationReasonNotFoundException::new);
    }

    public List<CreationReason> findAll(){
        return creationReasonRepo.findAll();
    }

    public void delete(CreationReason creationReason) {
        creationReasonRepo.delete(creationReason);
    }
}
