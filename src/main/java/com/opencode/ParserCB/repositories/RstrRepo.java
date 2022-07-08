package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import com.opencode.ParserCB.entities.cbrf_reference.Rstr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RstrRepo extends JpaRepository<Rstr, Integer> {
    @Query(value = "SELECT * FROM RSTR i WHERE i.code = :code",
            nativeQuery = true)
    Rstr findByCode(@Param("code") String code);
}