package ru.mrchebik.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 19.02.17.
 */
@Component
public class ServiceStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("INFO: " + (contextStoppedEvent.getTimestamp() - contextStoppedEvent.getApplicationContext().getStartupDate()) + "ms :: " + contextStoppedEvent.getApplicationContext().getDisplayName() + "  is stopped!");
    }
}
