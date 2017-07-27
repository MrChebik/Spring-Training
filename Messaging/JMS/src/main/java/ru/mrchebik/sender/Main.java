package ru.mrchebik.sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import ru.mrchebik.model.Example;

/**
 * Created by mrchebik on 05.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-sender.xml");
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        jmsTemplate.convertAndSend(new Example("JMS", "This message from JMS"));
    }
}
