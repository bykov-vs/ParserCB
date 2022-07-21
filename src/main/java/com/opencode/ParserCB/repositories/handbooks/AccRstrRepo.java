package com.opencode.ParserCB.repositories.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccRstrRepo extends HandbookRepo<AccRstr> {
    @Query(value = "SELECT * FROM ACC_RSTR i WHERE i.code = :code",
            nativeQuery = true)
    AccRstr findByCode(@Param("code") String code);
}