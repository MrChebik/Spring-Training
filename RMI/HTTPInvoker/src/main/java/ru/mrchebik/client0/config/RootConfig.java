package ru.mrchebik.client0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.mrchebik.client0.service.ExampleService;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@ComponentScan(basePackages = {"ru.mrchebik.client0"},
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(ExampleService exampleService) {
        HttpInvokerServiceExporter httpInvokerServiceExporter = new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(exampleService);
        httpInvokerServiceExporter.setServiceInterface(ExampleService.class);

        return httpInvokerServiceExporter;
    }
}
