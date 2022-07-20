package com.opencode.ParserCB.repositories.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.AccRstr;
import com.opencode.ParserCB.entities.cbrf_reference.ParticipantStatus;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantStatusRepo extends HandbookRepo<ParticipantStatus> {
    @Query(value = "SELECT * FROM PARTICIPANT_STATUS i WHERE i.code = :code",
            nativeQuery = true)
    ParticipantStatus findByCode(@Param("code") String code);
}