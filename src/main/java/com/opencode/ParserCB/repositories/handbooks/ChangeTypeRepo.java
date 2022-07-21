package com.opencode.ParserCB.repositories.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.ChangeType;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeTypeRepo extends HandbookRepo<ChangeType> {
    @Query(value = "SELECT * FROM CHANGE_TYPE i WHERE i.code = :code",
            nativeQuery = true)
    ChangeType findByCode(@Param("code") String code);
}