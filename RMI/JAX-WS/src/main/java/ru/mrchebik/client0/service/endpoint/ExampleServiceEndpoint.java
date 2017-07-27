package ru.mrchebik.client0.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mrchebik.client0.service.ExampleService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by mrchebik on 27.02.17.
 */
@Component
@WebService(serviceName = "exampleService")
public class ExampleServiceEndpoint {
    @Autowired
    private ExampleService exampleService;

    @WebMethod
    public String getHelloWorld() {
        return exampleService.getHelloWorld();
    }

    @WebMethod
    public String getMessage(String message) {
        return exampleService.getMessage(message);
    }

    @WebMethod
    public String calculate(String condition) {
        return exampleService.calculate(condition);
    }
}
