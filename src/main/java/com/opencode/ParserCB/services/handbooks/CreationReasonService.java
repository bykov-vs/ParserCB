package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.CreationReason;
import com.opencode.ParserCB.repositories.handbooks.CreationReasonRepo;
import com.opencode.ParserCB.services.exceptions.CreationReasonNotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CreationReasonService {

    private CreationReasonRepo creationReasonRepo;

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

    public CreationReason findByCode(String code) {
        return creationReasonRepo.findByCode(code);
    }
}
