package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GreetingController {

//    private final GreetingService greetingService;

    @Autowired
    private ObjectFactory<GreetingService> prototypeBeanObjectFactory;

    @GetMapping("/greet")
    public String greet() {
        return prototypeBeanObjectFactory.getObject().sayHi();
    }


}
