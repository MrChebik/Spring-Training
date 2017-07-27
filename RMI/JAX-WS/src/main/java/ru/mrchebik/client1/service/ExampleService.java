package ru.mrchebik.client1.service;

import javax.jws.WebService;

/**
 * Created by mrchebik on 26.02.17.
 */
@WebService(targetNamespace = "http://endpoint.service.client0.mrchebik.ru/")
public interface ExampleService {
    String getHelloWorld();
    String getMessage(String message);
    String calculate(String condition);
}
