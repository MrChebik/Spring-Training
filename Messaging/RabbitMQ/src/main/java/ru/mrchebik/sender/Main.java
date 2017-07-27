package ru.mrchebik.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.mrchebik.model.Example;

/**
 * Created by mrchebik on 09.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-sender.xml");
        RabbitTemplate template = (RabbitTemplate) context.getBean("rabbitTemplate");

        template.convertAndSend(new Example("RabbitMQ", "This message from RabbitMQ"));
    }
}
