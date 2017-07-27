package ru.mrchebik.event.custom;

import org.springframework.context.ApplicationEvent;

/**
 * Created by mrchebik on 19.02.17.
 */
public class CustomEvent extends ApplicationEvent {
    private String message;

    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
