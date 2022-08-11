package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicDirectoryEntryRepo extends JpaRepository<BicDirectoryEntry, Integer> {
    @Query(value = "SELECT * FROM BIC_DIRECTORY_ENTRY b WHERE b.ed_id = ed_id",
            nativeQuery = true)
    List<BicDirectoryEntry> findAllByEdId(@Param(value = "ed_id") int id);
}
