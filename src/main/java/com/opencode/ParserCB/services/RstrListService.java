package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf.RstrList;
import com.opencode.ParserCB.repositories.RstrListRepo;
import com.opencode.ParserCB.services.exceptions.RstrNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RstrListService {
    private final RstrListRepo rstrListRepo;

    public RstrListService(RstrListRepo rstrListRepo) {
        this.rstrListRepo = rstrListRepo;
    }

    public void save(RstrList rstrList) {
        rstrListRepo.save(rstrList);
    }

    public void update(RstrList rstrList) {
        rstrListRepo.save(rstrList);
    }

    public RstrList find(int id) throws RstrNotFoundException {
        return rstrListRepo.findById(id).orElseThrow(RstrNotFoundException::new);
    }

    public List<RstrList> findAll(){
        return rstrListRepo.findAll();
    }

    public void delete(RstrList rstrList) {
        this.rstrListRepo.delete(rstrList);
    }
}
