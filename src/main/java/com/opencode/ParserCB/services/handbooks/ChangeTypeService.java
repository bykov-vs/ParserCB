package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.ChangeType;
import com.opencode.ParserCB.repositories.handbooks.ChangeTypeRepo;
import com.opencode.ParserCB.services.exceptions.ChangeTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeTypeService {
    private final ChangeTypeRepo changeTypeRepo;

    public ChangeTypeService(ChangeTypeRepo changeTypeRepo) {
        this.changeTypeRepo = changeTypeRepo;
    }

    public void save(ChangeType changeType) {
        changeTypeRepo.save(changeType);
    }

    public void update(ChangeType changeType) {
        changeTypeRepo.save(changeType);
    }

    public ChangeType find(int id) throws ChangeTypeNotFoundException {
        return changeTypeRepo.findById(id).orElseThrow(ChangeTypeNotFoundException::new);
    }

    public List<ChangeType> findAll(){
        return changeTypeRepo.findAll();
    }

    public void delete(ChangeType changeType) {
        changeTypeRepo.delete(changeType);
    }

    public ChangeType findByCode(String code) {
        return changeTypeRepo.findByCode(code);
    }
}
