package ru.mrchebik.client1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ru.mrchebik.client1.service.ExampleService;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@ComponentScan("ru.mrchebik.client1")
public class Config {
    @Bean
    public RmiProxyFactoryBean exampleService() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/ExampleService");
        rmiProxyFactoryBean.setServiceInterface(ExampleService.class);

        return rmiProxyFactoryBean;
    }
}
