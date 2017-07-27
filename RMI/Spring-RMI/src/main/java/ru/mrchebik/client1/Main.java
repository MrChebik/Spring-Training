package ru.mrchebik.client1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mrchebik.client1.bean.CustomService;
import ru.mrchebik.client1.config.Config;

/**
 * Created by mrchebik on 26.02.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        CustomService customService = ctx.getBean(CustomService.class);

        customService.soutInfoFromServer();
    }
}
