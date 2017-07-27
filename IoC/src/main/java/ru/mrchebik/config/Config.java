package ru.mrchebik.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by mrchebik on 18.02.17.
 */
@Configuration
@ComponentScan("ru.mrchebik")
@EnableAspectJAutoProxy
//@PropertySource("classpath:randomize.properties")
public class Config {
    /* @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    } */
}
