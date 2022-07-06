package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.Ed807;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ed807Repo extends JpaRepository<Ed807, Integer> {
}