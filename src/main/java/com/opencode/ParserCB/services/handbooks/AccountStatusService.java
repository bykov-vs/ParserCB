package com.opencode.ParserCB.services.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import com.opencode.ParserCB.repositories.handbooks.AccountStatusRepo;
import com.opencode.ParserCB.services.exceptions.AccountStatusNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountStatusService {

    private final AccountStatusRepo accountStatusRepo;

    public AccountStatusService(AccountStatusRepo accountStatusRepo) {
        this.accountStatusRepo = accountStatusRepo;
    }

    public void save(AccountStatus accountStatus) {
        accountStatusRepo.save(accountStatus);
    }

    public void update(AccountStatus accountStatus) {
        accountStatusRepo.save(accountStatus);
    }

    public AccountStatus find(int id) throws AccountStatusNotFoundException {
        return accountStatusRepo.findById(id).orElseThrow(AccountStatusNotFoundException::new);
    }

    public List<AccountStatus> findAll(){
        return accountStatusRepo.findAll();
    }

    public void delete(AccountStatus accountStatus) throws AccountStatusNotFoundException {
        accountStatusRepo.delete(accountStatus);
    }

    public AccountStatus findByCode(String code) {
        return accountStatusRepo.findByCode(code);
    }
}
