package ru.mrchebik.client1.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mrchebik.client1.service.ExampleService;

/**
 * Created by mrchebik on 26.02.17.
 */
@Component
public class CustomService {
    private final ExampleService exampleService;

    @Autowired
    public CustomService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public void soutInfoFromServer() {
        System.out.println(exampleService.getHelloWorld());

        System.out.println(exampleService.getMessage("RMI message"));

        System.out.println(exampleService.calculate("2+2"));
    }
}
