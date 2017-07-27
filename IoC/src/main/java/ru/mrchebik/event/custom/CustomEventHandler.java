package ru.mrchebik.event.custom;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by mrchebik on 19.02.17.
 */
@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(customEvent.getMessage());
    }
}
