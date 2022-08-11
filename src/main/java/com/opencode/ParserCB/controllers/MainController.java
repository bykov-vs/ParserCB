package com.opencode.ParserCB.controllers;

import com.opencode.ParserCB.entities.cbrf_reference.Handbook;
import com.opencode.ParserCB.entities.cbrf_reference.XchType;
import com.opencode.ParserCB.services.HandbookService;
import com.opencode.ParserCB.services.MainParserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController implements WebMvcConfigurer {

    private final MainParserService mainParserService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("eds", mainParserService.getEdFiles());
        model.addAttribute("contentChange", false);
        model.addAttribute("handbooks", mainParserService.getListOfHandbooks());
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

        model.addAttribute("handbooks", mainParserService.getListOfHandbooks());
        model.addAttribute("hidden", true);

        return "redirect:/";
    }

    @PostMapping("/")
    public String changeHandbook(@RequestParam("handbook") String handbook, Model model) {
        List<?> information = mainParserService.getInfoHandbook(handbook);

        model.addAttribute("eds", mainParserService.getEdFiles());
        model.addAttribute("handbooks", mainParserService.getListOfHandbooks());
        model.addAttribute("information", information);
        model.addAttribute("hidden", false);
        model.addAttribute("handbook", handbook);
        model.addAttribute("changeEntityKey", false);
        model.addAttribute("addEntityKey", false);

        return "index";
    }
}
