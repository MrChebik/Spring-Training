package ru.mrchebik.handler;

/**
 * Created by mrchebik on 04.03.17.
 */
public class ExampleNotFoundException extends RuntimeException {
    private long id;

    public ExampleNotFoundException(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
