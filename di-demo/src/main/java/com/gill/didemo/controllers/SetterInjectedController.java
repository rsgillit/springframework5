package com.gill.didemo.controllers;

import com.gill.didemo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {

    public GreetingService greetingService;

    @Autowired
    @Qualifier("setterGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String sayHello() {
        return greetingService.sayGreeting();
    }


}
