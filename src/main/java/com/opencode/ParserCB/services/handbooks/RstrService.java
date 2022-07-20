package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.Rstr;
import com.opencode.ParserCB.repositories.handbooks.RstrRepo;
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

    public Rstr findByCode(String code) {
        return rstrRepo.findByCode(code);
    }
}
