package ru.mrchebik.client0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ru.mrchebik.client0.service.ExampleService;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@ComponentScan("ru.mrchebik.client0")
public class Config {
    @Bean
    public RmiServiceExporter rmiServiceExporter(ExampleService exampleService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(exampleService);
        rmiServiceExporter.setServiceName("ExampleService");
        rmiServiceExporter.setServiceInterface(ExampleService.class);

        return rmiServiceExporter;
    }
}
