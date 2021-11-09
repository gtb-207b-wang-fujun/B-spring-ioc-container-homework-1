package com.thoughtworks.capability.demospringioccontainer;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
//Spring 使用 CGLIB 库直接对对象进行子类化
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GreetingService implements ApplicationContextAware {

    public GreetingService() {
        System.out.println(GreetingService.class);
    }

    String sayHi() {
        return "hello world";
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getBean(GreetingFactory.class));
    }
}
