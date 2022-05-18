package com.rebuy.shortner.presentation.controller;

import com.rebuy.shortner.application.RoutingService;
import com.rebuy.shortner.presentation.model.RequestModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class UrlShortenerController {
    private final RoutingService routingService;

    public UrlShortenerController(RoutingService routingService) {
        this.routingService = routingService;
    }

    @GetMapping("/request")
    public String form(Model model) {
        model.addAttribute("request", new RequestModel());
        return "request";
    }

    @PostMapping("/request")
    public String generateUrl(@ModelAttribute RequestModel request, Model model) {
        String shortUrl = routingService.generateUrl(request.getUrl());
        request.setUrl(shortUrl);
        model.addAttribute("request", request);
        return "result";
    }
    @GetMapping("/{id}")
    public RedirectView redirect(@PathVariable String id) {
        String redirectUrl = "https://"+routingService.redirectToUrl(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        redirectView.setUrl(redirectUrl);
        return redirectView;
    }
}
