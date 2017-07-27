package ru.mrchebik.property;

import java.io.IOException;
import java.util.*;

/**
 * Created by mrchebik on 19.02.17.
 */
public class ReaderProperty {
    public static Map<String, String> ranges = new HashMap<String, String>();

    public ReaderProperty() {
        if (ranges != null) {
            ranges.clear();
        }

        Properties properties = new Properties();

        try {
            properties.load(ReaderProperty.class.getClassLoader().getResourceAsStream("randomize.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object state : properties.keySet()) {
            String key = (String) state;
            ranges.put(key, properties.getProperty(key));
        }
    }
}
