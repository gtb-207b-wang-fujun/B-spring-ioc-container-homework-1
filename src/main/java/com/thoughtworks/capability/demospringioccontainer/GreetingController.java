package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.desktop.SystemEventListener;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GreetingController {

    @Autowired
//    private ObjectFactory<GreetingService> prototypeBeanObjectFactory;
    private ApplicationContext context;

    @GetMapping("/greet")
    public String greet() {
//        return prototypeBeanObjectFactory.getObject().sayHi();
        GreetingService bean = context.getBean(GreetingService.class);
        System.out.println(bean);
        return bean.sayHi();
    }
    


}
