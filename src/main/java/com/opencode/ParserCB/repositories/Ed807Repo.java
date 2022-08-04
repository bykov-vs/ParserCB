package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.Ed807;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Ed807Repo extends JpaRepository<Ed807, Integer> {
    Optional<Ed807> findByEdNo(String edNo);
}