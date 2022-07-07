package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.AccRstrList;
import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import com.opencode.ParserCB.repositories.AccRstrListRepo;
import com.opencode.ParserCB.repositories.AccountRepo;
import com.opencode.ParserCB.services.exceptions.AccRstrListNotFoundException;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccRstrListService {
    private final AccRstrListRepo accRstrListRepo;

    public AccRstrListService(AccRstrListRepo accRstrListRepo, AccountRepo accountRepo) {
        this.accRstrListRepo = accRstrListRepo;
    }

    public void save(AccRstrList accRstrList) {
        accRstrListRepo.save(accRstrList);
    }

    public void update(AccRstrList accRstrList) {
        accRstrListRepo.save(accRstrList);
    }

    public AccRstrList find(int id) throws AccountNotFoundException {
        return accRstrListRepo.findById(id).orElseThrow(AccRstrListNotFoundException::new);
    }

    public List<AccRstrList> findAll(){
        return accRstrListRepo.findAll();
    }

    public void delete(AccRstrList accRstrList) {
        accRstrListRepo.delete(accRstrList);
    }
}
