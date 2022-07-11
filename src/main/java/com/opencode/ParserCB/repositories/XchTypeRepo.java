package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XchTypeRepo extends JpaRepository<XchType, Integer> {
    @Query(value = "SELECT * FROM XCH_TYPE i WHERE i.code = :code",
            nativeQuery = true)
    XchType findByCode(@Param("code") String code);
}