package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XchTypeRepo extends JpaRepository<XchType, Integer> {
}