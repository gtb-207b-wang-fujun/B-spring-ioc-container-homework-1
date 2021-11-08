package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {

        this.greetingService = greetingService;
    }

    @Lookup
    public GreetingService getGreetingService() {
        return null;
    }

    @GetMapping("/greet")
    public String greet() {
        GreetingService prototype = getGreetingService();
        return prototype.sayHi();
    }


}
