package ru.mrchebik.client0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mrchebik.client0.config.Config;

/**
 * Created by mrchebik on 26.02.17.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class);
    }
}
