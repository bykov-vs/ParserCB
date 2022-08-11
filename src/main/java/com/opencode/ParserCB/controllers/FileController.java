package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.entities.FileDetails;
import com.opencode.ParserCB.entities.FileDetailsPages;
import com.opencode.ParserCB.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/files")
@AllArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/details")
    public String bicsDetails(FileDetails fileDetails,
                              Model model) {
        FileDetailsPages fileDetailsPages = fileService.getFileDetailsPages(fileDetails);
        model.addAttribute("file", fileDetails.getFileName());
        model.addAttribute("isEntered", true);
        model.addAttribute("bicPage", fileDetailsPages.getBicPage());
        model.addAttribute("bicPageNumber", fileDetails.getBicPageNumber());
        model.addAttribute("accountPage", fileDetailsPages.getAccountPage());
        model.addAttribute("accountPageNumber", fileDetails.getAccountPageNumber());
        return "files";
    }


}
