package ru.mrchebik.client1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import ru.mrchebik.client1.service.ExampleService;

import java.io.IOException;
import java.net.URL;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@ComponentScan(basePackages = {"ru.mrchebik.client1"})
public class Config {
    @Bean
    public JaxWsPortProxyFactoryBean exampleService() throws IOException {
        JaxWsPortProxyFactoryBean proxyFactoryBean = new JaxWsPortProxyFactoryBean();
        proxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:10000/ws/exampleService?wsdl"));
        proxyFactoryBean.setServiceName("exampleService");
        proxyFactoryBean.setPortName("ExampleServiceEndpointPort");
        proxyFactoryBean.setServiceInterface(ExampleService.class);
        proxyFactoryBean.setNamespaceUri("http://endpoint.service.client0.mrchebik.ru/");

        return proxyFactoryBean;
    }
}
