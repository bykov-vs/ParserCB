package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf_reference.Handbook;
import com.opencode.ParserCB.repositories.HandbookRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HandbookService<T extends Handbook> {

    private final HandbookRepo<T> handbookRepo;

    public void save(T entity) {
        handbookRepo.save(entity);
    }

    public void update(T entity) {
        handbookRepo.save(entity);
    }

    public T find(int id) throws AccountNotFoundException {
        return handbookRepo.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public List<T> findAll(){
        return handbookRepo.findAll();
    }

    public void delete(T entity) {
        handbookRepo.delete(entity);
    }

    public T findByCode(String code) {
        return handbookRepo.findByCode(code);
    }
}
