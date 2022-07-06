package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.PtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PtTypeRepo extends JpaRepository<PtType, Integer> {
}