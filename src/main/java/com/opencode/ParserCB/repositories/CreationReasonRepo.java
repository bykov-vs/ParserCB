package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.CreationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationReasonRepo extends JpaRepository<CreationReason, Integer> {
}