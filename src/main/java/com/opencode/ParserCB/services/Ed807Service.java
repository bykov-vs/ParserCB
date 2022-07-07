package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf.Ed807;
import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.repositories.AccRstrRepo;
import com.opencode.ParserCB.repositories.Ed807Repo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import com.opencode.ParserCB.services.exceptions.Ed807NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ed807Service {
    private final Ed807Repo ed807Repo;

    public Ed807Service(Ed807Repo ed807Repo) {
        this.ed807Repo = ed807Repo;
    }

    public void save(Ed807 ed807) {
        ed807Repo.save(ed807);
    }

    public void update(Ed807 ed807) {
        ed807Repo.save(ed807);
    }

    public Ed807 find(int id) throws Ed807NotFoundException {
        return ed807Repo.findById(id).orElseThrow(Ed807NotFoundException::new);
    }

    public List<Ed807> findAll(){
        return ed807Repo.findAll();
    }

    public void delete(Ed807 ed807) {
        ed807Repo.delete(ed807);
    }
}
