package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.AccRstrList;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.services.exceptions.AccRstrNotFoundException;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccRstrService {
    private final AccRstrRepo accRstrRepo;

    public AccRstrService(AccRstrRepo accRstrRepo) {
        this.accRstrRepo = accRstrRepo;
    }

    public void save(AccRstr accRstr) {
        accRstrRepo.save(accRstr);
    }

    public void update(AccRstr accRstr) {
        accRstrRepo.save(accRstr);
    }

    public AccRstr find(int id) throws AccRstrNotFoundException {
        return accRstrRepo.findById(id).orElseThrow(AccRstrNotFoundException::new);
    }

    public List<AccRstr> findAll(){
        return accRstrRepo.findAll();
    }

    public void delete(AccRstr accRstr) {
        accRstrRepo.delete(accRstr);
    }
}
