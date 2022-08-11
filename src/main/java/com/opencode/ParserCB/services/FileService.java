package com.opencode.ParserCB.services;

import com.opencode.ParserCB.entities.FileDetails;
import com.opencode.ParserCB.entities.FileDetailsPages;
import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import com.opencode.ParserCB.entities.cbrf.Ed807;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FileService {
    private final Ed807Service ed807Service;
    private final AccountService accountService;
    private final BicDirectoryEntryService bicDirectoryEntryService;

    public FileDetailsPages getFileDetailsPages(FileDetails fileDetails) {
        String fileName = fileDetails.getFileName();
        if (fileName.isEmpty())
            return null;

        Ed807 ed807 = ed807Service.findEd(fileName);
        if (ed807 == null)
            return null;

        List<BicDirectoryEntry> bics = bicDirectoryEntryService.findAllByEd(ed807.getEdId());
        List<Account> accounts = new ArrayList<>();
        for (BicDirectoryEntry bic : bics) {
            accounts.addAll(accountService.findAllByBic(bic.getBicDirectoryEntryId()));
        }

        FileDetailsPages fileDetailsPages = new FileDetailsPages(fileDetails);
        fileDetailsPages.createBicPage(bics);
        fileDetailsPages.createAccountPage(accounts);
        return fileDetailsPages;
    }
}
