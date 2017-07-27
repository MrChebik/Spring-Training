package ru.mrchebik.client0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

/**
 * Created by mrchebik on 26.02.17.
 */
@Configuration
@ComponentScan("ru.mrchebik.client0")
public class RootConfig {
    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
        SimpleJaxWsServiceExporter jaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        jaxWsServiceExporter.setBaseAddress("http://localhost:10000/ws/");

        return jaxWsServiceExporter;
    }
}
