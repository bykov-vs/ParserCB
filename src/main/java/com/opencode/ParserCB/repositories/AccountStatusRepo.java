package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusRepo extends JpaRepository<AccountStatus, Integer> {
}