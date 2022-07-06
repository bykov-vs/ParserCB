package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.Srvcs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SrvcsRepo extends JpaRepository<Srvcs, Integer> {
}