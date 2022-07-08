package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.PtType;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PtTypeRepo extends JpaRepository<PtType, Integer> {
    @Query(value = "SELECT * FROM PT_TYPE i WHERE i.code = :code",
            nativeQuery = true)
    PtType findByCode(@Param("code") String code);
}