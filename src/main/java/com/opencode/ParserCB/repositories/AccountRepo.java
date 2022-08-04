package com.opencode.ParserCB.repositories;


import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * FROM ACCOUNT a WHERE a.bic_directory_entry_id = :bic_id",
            nativeQuery = true)
    List<Account> findAllByEd(@Param(value = "bic_id") int bic_id);
}
