package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import com.opencode.ParserCB.entities.cbrf_reference.Srvcs;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.SrvcsRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.SrvcsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SrvcsService {
    private final SrvcsRepo srvcsRepo;

    public SrvcsService(SrvcsRepo srvcsRepo) {
        this.srvcsRepo = srvcsRepo;
    }

    public void save(Srvcs srvcs) {
        srvcsRepo.save(srvcs);
    }

    public void update(Srvcs srvcs) {
        srvcsRepo.save(srvcs);
    }

    public Srvcs find(int id) throws SrvcsNotFoundException {
        return srvcsRepo.findById(id).orElseThrow(SrvcsNotFoundException::new);
    }

    public List<Srvcs> findAll(){
        return srvcsRepo.findAll();
    }

    public void delete(Srvcs srvcs) {
        srvcsRepo.delete(srvcs);
    }

    public Srvcs findByCode(String code) {
        return srvcsRepo.findByCode(code);
    }
}
