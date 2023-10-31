package com.example.bookinfo.controller;

import com.example.bookinfo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewContoller {
    private AppService appService;

    @Autowired
    public ViewContoller(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("author",appService.getAuthorsAmountOfBooksInCategory());
        return "view.html";
    }
}
