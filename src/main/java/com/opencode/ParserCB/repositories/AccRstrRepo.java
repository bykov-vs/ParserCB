package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrRepo extends JpaRepository<AccRstr, Integer> {
}