package com.opencode.ParserCB.repositories;


import com.opencode.ParserCB.entities.cbrf.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
}
