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
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
        try {
            mainParserService.parseFile(multipartFile.getInputStream());
        }catch (Exception e){
            model.addAttribute("errorFile", "Ошибка чтения файла!");
        }

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

    @GetMapping("/add/")
    public String addEntity(@RequestParam(value = "handbook") String handbook, Model model) {
        List<?> information = mainParserService.getInfoHandbook(handbook);

        model.addAttribute("addEntityKey", true);
        model.addAttribute("information", information);
        model.addAttribute("handbook", handbook);
        model.addAttribute("hidden", false);
        model.addAttribute("changeEntityKey", false);
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
            model.addAttribute("hidden", true);
            model.addAttribute("changeEntityKey", false);
            //model.addAttribute("addEntityKey", true);
            return "index";
        }

        return "redirect:/";
    }

    @GetMapping("/list")
    public String changeEntity(@RequestParam(value = "code") String code,
                               @RequestParam(value = "handbook") String handbook,
                               @RequestParam(value = "action") int action,
                               Model model){
        if (action == 0){

            model.addAttribute("handbook", handbook);
            model.addAttribute("action", action);
            model.addAttribute("changeEntityKey", true);
            model.addAttribute("addEntityKey", false);
            model.addAttribute("hidden", true);
            return "index";
        }
        try {
            mainParserService.deleteHandbookEntity(handbook, code);
            return "redirect:/";
        }catch (Exception e){
            model.addAttribute("error","Удаление НЕ совершено");
            return "index";
        }
    }

    @PostMapping("/list/change")
    public String changeEntityAndSave(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "handbook") String handbook,
                                      Model model){

        mainParserService.saveHandbookEntity(code, name, handbook);
        return "redirect:/";
    }
}
