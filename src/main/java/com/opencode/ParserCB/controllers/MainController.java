package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.services.MainParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MainParserService mainParserService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        mainParserService.parseFile(multipartFile.getInputStream());
        return "redirect:/";
    }
}
