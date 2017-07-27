package ru.mrchebik.receiver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mrchebik on 05.03.17.
 */
public class Main {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-context-receiver.xml");
    }
}
