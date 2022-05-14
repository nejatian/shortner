package com.rebuy.shortner.presentation.controller;

import com.rebuy.shortner.presentation.model.RequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlShortenerController {

    @GetMapping("/request")
    public String greetingForm(Model model) {
        model.addAttribute("request", new RequestModel());
        return "request";
    }

    @PostMapping("/request")
    public String greetingSubmit(@ModelAttribute RequestModel request, Model model) {
        model.addAttribute("request", request);
        return "result";
    }
}
