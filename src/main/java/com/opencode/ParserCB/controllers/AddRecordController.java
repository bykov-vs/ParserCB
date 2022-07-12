package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.services.MainParserService;
import com.opencode.ParserCB.services.exceptions.CodeAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/add")
public class AddRecordController {

    @Autowired
    private MainParserService mainParserService;

    @GetMapping("/")
    public String addEntity(@RequestParam(value = "handbook") String handbook, Model model) {
        List<?> information = mainParserService.getInfoHandbook(handbook);

        model.addAttribute("addEntityKey", true);
        model.addAttribute("information", information);
        model.addAttribute("handbook", handbook);
        model.addAttribute("hidden", false);
        model.addAttribute("changeEntityKey", false);
        return "index";
    }

    @PostMapping("/")
    public String saveEntity(@RequestParam(value = "code") String code,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "handbook") String handbook,
                             Model model) {
        try{
            mainParserService.saveHandbookEntity(code, name, handbook, code);
        }catch (CodeAlreadyExistsException e){
            model.addAttribute("hidden", true);
            model.addAttribute("changeEntityKey", false);
            //model.addAttribute("addEntityKey", true);
            return "index";
        }

        return "redirect:/";
    }
}
