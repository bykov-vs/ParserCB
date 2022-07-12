package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.services.MainParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/list")
public class ChangeHandbookController {

    @Autowired
    private MainParserService mainParserService;

    @GetMapping("/")
    public String changeEntity(@RequestParam(value = "code") String code,
                               @RequestParam(value = "handbook") String handbook,
                               @RequestParam(value = "action") int action,
                               Model model){
        model.addAttribute("contentChange", true);
        if (action == 0){
            model.addAttribute("handbook", handbook);
            model.addAttribute("action", action);
            model.addAttribute("prevValue", code);
            model.addAttribute("changeEntityKey", true);
            model.addAttribute("addEntityKey", false);
            model.addAttribute("hidden", true);
            return "index";
        }
        try {
            mainParserService.deleteHandbookEntity(handbook, code);
            model.addAttribute("hidden", true);
            model.addAttribute("error","Успешно");
            return "index";
        }catch (Exception e){
            model.addAttribute("hidden", true);
            model.addAttribute("error","Неуспешно");
            return "index";
        }
    }

    @PostMapping("/change")
    public String changeEntityAndSave(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "handbook") String handbook,
                                      @RequestParam(value = "prevValue") String prevValue,
                                      Model model){
        mainParserService.saveHandbookEntity(code, name, handbook, prevValue);
        return "redirect:/";
    }
}
