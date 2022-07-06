package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.InfoTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTypeCodeRepo extends JpaRepository<InfoTypeCode, Integer> {
}