package com.gill.springbootjokesapp.controllers;

import com.gill.springbootjokesapp.services.RandomQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private RandomQuotesService randomQuotesService;

    @Autowired
    public JokesController(RandomQuotesService randomQuotesService) {
        this.randomQuotesService = randomQuotesService;
    }

    @RequestMapping({"/", ""})
    public String getJokes(Model model) {
        model.addAttribute("joke", randomQuotesService.getRandomJoke());
        return "chucknorris";
    }
}
