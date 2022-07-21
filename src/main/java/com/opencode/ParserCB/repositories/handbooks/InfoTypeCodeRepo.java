package com.opencode.ParserCB.repositories.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.InfoTypeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTypeCodeRepo extends HandbookRepo<InfoTypeCode> {
    @Query(value = "SELECT * FROM INFO_TYPE_CODE i WHERE i.code = :code",
            nativeQuery = true)
    InfoTypeCode findByCode(@Param("code") String code);
}