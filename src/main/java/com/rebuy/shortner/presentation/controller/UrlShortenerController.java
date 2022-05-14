package com.rebuy.shortner.presentation.controller;

import com.rebuy.shortner.application.RoutingService;
import com.rebuy.shortner.presentation.model.RequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UrlShortenerController {
    private final RoutingService routingService;

    public UrlShortenerController(RoutingService routingService) {
        this.routingService = routingService;
    }

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
    @GetMapping("/{id}")
    public void redirect(@PathVariable String id) {
        String redirectUrl = routingService.redirectToUrl(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
    }
}
