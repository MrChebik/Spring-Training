package ru.mrchebik.model;

/**
 * Created by mrchebik on 11.03.17.
 */
public class Example {
    private String message;
    private String data;

    public Example(String message, String data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
