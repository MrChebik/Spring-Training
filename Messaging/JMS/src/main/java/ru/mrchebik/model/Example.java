package ru.mrchebik.model;

import java.io.Serializable;

/**
 * Created by mrchebik on 07.03.17.
 */
public class Example implements Serializable {
    private String title;
    private String message;

    public Example() {
    }

    public Example(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return title + "\n" + message;
    }
}
