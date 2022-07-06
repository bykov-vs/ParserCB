package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.ParticipantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantStatusRepo extends JpaRepository<ParticipantStatus, Integer> {
}