package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.RstrList;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrListRepo extends JpaRepository<RstrList, Integer> {
}