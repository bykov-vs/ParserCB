package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.Handbook;
import com.opencode.ParserCB.repositories.handbooks.HandbookRepo;
import com.opencode.ParserCB.repositories.handbooks.HandbookRepositoryFactory;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HandbookService<T extends Handbook> {

    private HandbookRepo<T> handbookRepo;

    public HandbookService(ApplicationContext context, String handbook) {
        this.handbookRepo = (HandbookRepo<T>) HandbookRepositoryFactory.getRepository(context, handbook);
    }

    public void save(T entity) {
        handbookRepo.save(entity);
    }

    public void update(T entity) {

        handbookRepo.save(entity);
    }

    public T find(int id) throws AccountNotFoundException {
        return handbookRepo.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public List<T> findAll() {
        return handbookRepo.findAll();
    }

    public void delete(T entity) {
        handbookRepo.delete(entity);
    }

    public T findByCode(String code) {
        return handbookRepo.findByCode(code);
    }
}
