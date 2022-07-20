package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import com.opencode.ParserCB.repositories.handbooks.RegulationAccountTypeRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.RegulationAccountTypeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegulationAccountTypeService {
    private final RegulationAccountTypeRepo regulationAccountTypeRepo;

    public RegulationAccountTypeService(RegulationAccountTypeRepo regulationAccountTypeRepo) {
        this.regulationAccountTypeRepo = regulationAccountTypeRepo;
    }

    public void save(RegulationAccountType regulationAccountType) {
        regulationAccountTypeRepo.save(regulationAccountType);
    }

    public void update(RegulationAccountType regulationAccountType) {
        regulationAccountTypeRepo.save(regulationAccountType);
    }

    public RegulationAccountType find(int id) throws AccountNotFoundException {
        return regulationAccountTypeRepo.findById(id).orElseThrow(RegulationAccountTypeNotFoundException::new);
    }

    public List<RegulationAccountType> findAll(){
        return regulationAccountTypeRepo.findAll();
    }

    public void delete(RegulationAccountType regulationAccountType) {
        regulationAccountTypeRepo.delete(regulationAccountType);
    }

    public RegulationAccountType findByCode(String code) {
        return regulationAccountTypeRepo.findByCode(code);
    }
}
