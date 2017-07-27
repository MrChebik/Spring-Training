package ru.mrchebik.client0.service.impl;

import org.springframework.stereotype.Service;
import ru.mrchebik.client0.service.ExampleService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mrchebik on 26.02.17.
 */
@Service
public class ExampleServiceImpl implements ExampleService {
    public String getHelloWorld() {
        return "Hello World";
    }

    public String getMessage(String message) {
        return "Message from Server: " + message;
    }

    public String calculate(String condition) {
        int a = 0;
        int b = 0;
        String c = "";

        Matcher matcher = Pattern.compile("(\\d+)([\\*\\-\\+/])(\\d+)").matcher(condition);
        while (matcher.find()) {
            a = Integer.parseInt(matcher.group(1));
            b = Integer.parseInt(matcher.group(3));
            c = matcher.group(2);
        }

        return "The result of " + condition + " is " + (c.equals("+") ? a + b : c.equals("-") ? a - b : c.equals("*") ? a * b : a / b);
    }
}
