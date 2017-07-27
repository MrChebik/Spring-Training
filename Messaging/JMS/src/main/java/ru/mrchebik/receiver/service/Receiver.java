package ru.mrchebik.receiver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.mrchebik.model.Example;

import java.io.IOException;

/**
 * Created by mrchebik on 05.03.17.
 */
public class Receiver {
    public void retrieveExample(Object object) throws IOException {
        if (object instanceof Example) {
            System.out.println(object);
        } else {
            System.out.println(new ObjectMapper().readValue(new String((byte[]) object), Example.class));
        }
    }
}
