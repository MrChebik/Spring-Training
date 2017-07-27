package ru.mrchebik.client0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.mrchebik.client0")
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public HandlerMapping handlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.setProperty("/example.service", "httpInvokerServiceExporter");
        mapping.setMappings(mappings);

        return mapping;
    }
}
