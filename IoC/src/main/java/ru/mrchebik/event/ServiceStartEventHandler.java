package ru.mrchebik.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 19.02.17.
 */
@Component
public class ServiceStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("INFO: " + (contextStartedEvent.getTimestamp() - contextStartedEvent.getApplicationContext().getStartupDate()) + "ms :: " + contextStartedEvent.getApplicationContext().getDisplayName() + "  is started!");
    }
}
