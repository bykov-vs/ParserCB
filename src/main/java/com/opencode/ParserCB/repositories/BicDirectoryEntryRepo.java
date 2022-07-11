package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import com.opencode.ParserCB.entities.cbrf_reference.RegulationAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicDirectoryEntryRepo extends JpaRepository<BicDirectoryEntry, Integer> {
}
