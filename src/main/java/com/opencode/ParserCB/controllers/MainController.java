package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.services.MainParserService;
import com.opencode.ParserCB.services.exceptions.CodeAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController implements WebMvcConfigurer {

    @Autowired
    private MainParserService mainParserService;

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<String> options = new ArrayList<>();
        options.add("AccountStatus");
        options.add("AccRstr");
        options.add("ChangeType");
        options.add("CreationReason");
        options.add("InfoTypeCode");
        options.add("ParticipantStatus");
        options.add("PtType");
        options.add("RegulationAccountType");
        options.add("Rstr");
        options.add("Srvcs");
        options.add("XchType");

        model.addAttribute("contentChange", false);
        model.addAttribute("handbooks", options);
        model.addAttribute("hidden", true);
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
        try {
            mainParserService.parseFile(multipartFile.getInputStream());
        }catch (Exception e){
            model.addAttribute("errorFile", "Ошибка чтения файла!");
        }

        ArrayList<String> options = new ArrayList<>();
        options.add("AccountStatus");
        options.add("AccRstr");
        options.add("ChangeType");
        options.add("CreationReason");
        options.add("InfoTypeCode");
        options.add("ParticipantStatus");
        options.add("PtType");
        options.add("RegulationAccountType");
        options.add("Rstr");
        options.add("Srvcs");
        options.add("XchType");

        model.addAttribute("handbooks", options);
        model.addAttribute("hidden", true);
        return "redirect:/";
    }

    @PostMapping("/")
    public String changeHandbook(@RequestParam("handbook") String handbook, Model model) {
        List<?> information = mainParserService.getInfoHandbook(handbook);
        ArrayList<String> options = new ArrayList<>();
        options.add("AccountStatus");
        options.add("AccRstr");
        options.add("ChangeType");
        options.add("CreationReason");
        options.add("InfoTypeCode");
        options.add("ParticipantStatus");
        options.add("PtType");
        options.add("RegulationAccountType");
        options.add("Rstr");
        options.add("Srvcs");
        options.add("XchType");

        model.addAttribute("handbooks", options);
        model.addAttribute("information", information);
        model.addAttribute("hidden", false);
        model.addAttribute("handbook", handbook);
        model.addAttribute("changeEntityKey", false);
        model.addAttribute("addEntityKey", false);
        return "index";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/";
    }
}
