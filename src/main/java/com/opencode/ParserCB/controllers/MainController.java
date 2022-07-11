package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.services.MainParserService;
import com.opencode.ParserCB.services.exceptions.CodeAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

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

        model.addAttribute("handbooks", options);
        model.addAttribute("hidden", true);
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException {
        mainParserService.parseFile(multipartFile.getInputStream());
        return "redirect:/";
    }

    @PostMapping("/")
    public String changeHandbook(@RequestParam("handbook") String handbook, Model model) throws IOException {
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
        return "index";
    }

    @GetMapping("/add/")
    public String addEntity(@RequestParam(value = "handbook") String handbook, Model model) {
        List<?> information = mainParserService.getInfoHandbook(handbook);

        model.addAttribute("addEntityKey", true);
        model.addAttribute("information", information);
        model.addAttribute("handbook", handbook);
        return "index";
    }

    @PostMapping("/add/")
    public String saveEntity(@RequestParam(value = "code") String code,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "handbook") String handbook,
                             Model model) {
        try{
            mainParserService.saveHandbookEntity(code, name, handbook);
        }catch (CodeAlreadyExistsException e){
            model.addAttribute("error", e.getMessage());
            //model.addAttribute("addEntityKey", true);
            return "index";
        }

        return "redirect:/";
    }
}
