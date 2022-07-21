package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import com.opencode.ParserCB.repositories.BicDirectoryEntryRepo;
import com.opencode.ParserCB.services.exceptions.BicDirectoryEntryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicDirectoryEntryService {
    private final BicDirectoryEntryRepo bicDirectoryEntryRepo;

    public BicDirectoryEntryService(BicDirectoryEntryRepo bicDirectoryEntryRepo) {
        this.bicDirectoryEntryRepo = bicDirectoryEntryRepo;
    }

    public void save(BicDirectoryEntry bicDirectoryEntry) {
        bicDirectoryEntryRepo.save(bicDirectoryEntry);
    }

    public void update(BicDirectoryEntry bicDirectoryEntry) {
        bicDirectoryEntryRepo.save(bicDirectoryEntry);
    }

    public BicDirectoryEntry find(int id) throws BicDirectoryEntryNotFoundException {
        return bicDirectoryEntryRepo.findById(id).orElseThrow(BicDirectoryEntryNotFoundException::new);
    }

    public List<BicDirectoryEntry> findAll(){
        return bicDirectoryEntryRepo.findAll();
    }

    public void delete(BicDirectoryEntry bicDirectoryEntry) {
        bicDirectoryEntryRepo.delete(bicDirectoryEntry);
    }
}
