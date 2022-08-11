package com.opencode.ParserCB.entities;

import com.opencode.ParserCB.entities.cbrf.Account;
import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Getter
public class FileDetailsPages {
    private Page<BicDirectoryEntry> bicPage;
    private Page<Account> accountPage;
    private FileDetails fileDetails;
    //TODO private Page<ParticipantInfo> participantInfoPage;

    public FileDetailsPages(FileDetails fileDetails) {
        this.fileDetails = fileDetails;
    }

    public void createBicPage(List<BicDirectoryEntry> bics) {
        Pageable pageableBics = PageRequest.of(
                fileDetails.getBicPageNumber(),
                fileDetails.getBicPageSize()
        );

        int pageSize = pageableBics.getPageSize();
        int currentPage = pageableBics.getPageNumber();
        int startItem = currentPage * pageSize;
        List<BicDirectoryEntry> list;
        if (bics.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, bics.size());
            list = bics.subList(startItem, toIndex);
        }
        bicPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), bics.size());
    }

    public void createAccountPage(List<Account> accounts) {
        Pageable pageableAccount = PageRequest.of(
                fileDetails.getAccountPageNumber(),
                fileDetails.getAccountPageSize()
        );

        int pageSize = pageableAccount.getPageSize();
        int currentPage = pageableAccount.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Account> list;
        if (accounts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, accounts.size());
            list = accounts.subList(startItem, toIndex);
        }
        accountPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), accounts.size());
    }
}
