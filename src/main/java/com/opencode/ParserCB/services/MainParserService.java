package com.opencode.ParserCB.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencode.ParserCB.entities.cbrf.BicDirectoryEntry;
import com.opencode.ParserCB.entities.cbrf.Ed807;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

@Service
public class MainParserService {

    public void parseFile(InputStream file) throws IOException {

        System.out.println();
        int c;

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        Ed807 ed807 = xmlMapper.readValue(file, Ed807.class);

        System.out.println(ed807.getEdAuthor());
        System.out.println(ed807.getXmlns());
        System.out.println(ed807.getDirectoryVersion());

        for (BicDirectoryEntry b : ed807.getBicDirectoryEntries()){
            System.out.println(b.getBic());
        }
    }
}
