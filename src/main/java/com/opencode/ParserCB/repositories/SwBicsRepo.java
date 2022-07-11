package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.SwBics;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwBicsRepo extends JpaRepository<SwBics, Integer> {
}