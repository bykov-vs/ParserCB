package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.XchTypeRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XchTypeService {
    private final XchTypeRepo xchTypeRepo;

    public XchTypeService(XchTypeRepo xchTypeRepo) {
        this.xchTypeRepo = xchTypeRepo;
    }

    public void save(XchType xchType) {
        xchTypeRepo.save(xchType);
    }

    public void update(XchType xchType) {
        xchTypeRepo.save(xchType);
    }

    public XchType find(int id) throws AccountNotFoundException {
        return xchTypeRepo.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public List<XchType> findAll(){
        return xchTypeRepo.findAll();
    }

    public void delete(XchType xchType) {
        xchTypeRepo.delete(xchType);
    }
}
