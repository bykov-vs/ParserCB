package com.opencode.ParserCB.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileDetails {
    private String fileName;
    private int bicPageNumber;
    private int bicPageSize;
    private int accountPageNumber;
    private int accountPageSize;

    public FileDetails() {
        this.fileName = "";
        this.bicPageNumber = 1;
        this.bicPageSize = 5;
        this.accountPageNumber = 1;
        this.accountPageSize = 5;
    }


}
