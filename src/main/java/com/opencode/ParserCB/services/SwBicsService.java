package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf.SwBics;
import com.opencode.ParserCB.repositories.AccountRepo;
import com.opencode.ParserCB.repositories.SwBicsRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.SwBicsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwBicsService {
    private final SwBicsRepo swBicsRepo;

    public SwBicsService(SwBicsRepo swBicsRepo) {
        this.swBicsRepo = swBicsRepo;
    }

    public void save(SwBics swBics) {
        swBicsRepo.save(swBics);
    }

    public void update(SwBics swBics) {
        swBicsRepo.save(swBics);
    }

    public SwBics find(int id) throws SwBicsNotFoundException {
        return swBicsRepo.findById(id).orElseThrow(SwBicsNotFoundException::new);
    }

    public List<SwBics> findAll(){
        return swBicsRepo.findAll();
    }

    public void delete(SwBics swBics) {
        swBicsRepo.delete(swBics);
    }
}
