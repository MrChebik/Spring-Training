package ru.mrchebik.client0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.remoting.caucho.HessianServiceExporter;
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
    public HessianServiceExporter hessianServiceExporter(ExampleService exampleService) {
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(exampleService);
        hessianServiceExporter.setServiceInterface(ExampleService.class);

        return hessianServiceExporter;
    }
}
