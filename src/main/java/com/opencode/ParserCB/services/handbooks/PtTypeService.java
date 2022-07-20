package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.PtType;
import com.opencode.ParserCB.repositories.handbooks.PtTypeRepo;
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

    public PtType findByCode(String code) {
        return ptTypeRepo.findByCode(code);
    }
}
