package ru.mrchebik.event.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 19.02.17.
 */
@Component
public class CustomEventPublisher {
    private final ApplicationEventPublisher publisher;

    @Autowired
    public CustomEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void doStuffAndPublishAnEvent(final String message) {
        System.out.println("Publishing custom event. ");
        CustomEvent customSpringEvent = new CustomEvent(this, message);
        publisher.publishEvent(customSpringEvent);
    }
}
