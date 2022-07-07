package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.PtType;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.PtTypeRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.PtTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PtTypeService {
    private final PtTypeRepo ptTypeRepo;

    public PtTypeService(PtTypeRepo ptTypeRepo) {
        this.ptTypeRepo = ptTypeRepo;
    }

    public void save(PtType ptType) {
        ptTypeRepo.save(ptType);
    }

    public void update(PtType ptType) {
        ptTypeRepo.save(ptType);
    }

    public PtType find(int id) throws PtTypeNotFoundException {
        return ptTypeRepo.findById(id).orElseThrow(PtTypeNotFoundException::new);
    }

    public List<PtType> findAll(){
        return ptTypeRepo.findAll();
    }

    public void delete(PtType ptType) {
        ptTypeRepo.delete(ptType);
    }
}
