package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.ChangeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeTypeRepo extends JpaRepository<ChangeType, Integer> {
}