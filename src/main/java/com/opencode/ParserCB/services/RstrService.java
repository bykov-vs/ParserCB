package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.Rstr;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.RstrRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.RstrNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RstrService {
    private final RstrRepo rstrRepo;

    public RstrService(RstrRepo rstrRepo) {
        this.rstrRepo = rstrRepo;
    }

    public void save(Rstr rstr) {
        rstrRepo.save(rstr);
    }

    public void update(Rstr rstr) {
        rstrRepo.save(rstr);
    }

    public Rstr find(int id) throws RstrNotFoundException {
        return rstrRepo.findById(id).orElseThrow(RstrNotFoundException::new);
    }

    public List<Rstr> findAll(){
        return rstrRepo.findAll();
    }

    public void delete(Rstr rstr) {
        rstrRepo.delete(rstr);
    }
}
