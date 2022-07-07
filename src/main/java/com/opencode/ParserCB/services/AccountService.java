package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.repositories.AccountRepo;
import com.opencode.ParserCB.services.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void save(Account account) {
        accountRepo.save(account);
    }

    public void update(Account account) {
        accountRepo.save(account);
    }

    public Account find(int id) throws AccountNotFoundException {
        return accountRepo.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    public List<Account> findAll(){
        return accountRepo.findAll();
    }

    public void delete(Account account) {
        accountRepo.delete(account);
    }
}
