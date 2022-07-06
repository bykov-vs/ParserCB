package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicDirectoryEntryRepo extends JpaRepository<BicDirectoryEntry, Integer> {
}
