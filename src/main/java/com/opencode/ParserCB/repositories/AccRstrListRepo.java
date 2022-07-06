package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.AccRstrList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrListRepo extends JpaRepository<AccRstrList, Integer> {
}
