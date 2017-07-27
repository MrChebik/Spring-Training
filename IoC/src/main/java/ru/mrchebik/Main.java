package ru.mrchebik;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mrchebik.bean.Service;
import ru.mrchebik.config.Config;
import ru.mrchebik.event.custom.CustomEventPublisher;
import ru.mrchebik.property.ReaderProperty;

/**
 * Created by mrchebik on 18.02.17.
 */
public class Main {
    public static void main(String[] args) {
        new ReaderProperty();

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.start();

        CustomEventPublisher customEventPublisher = ctx.getBean(CustomEventPublisher.class);
        customEventPublisher.doStuffAndPublishAnEvent("CustomEventPubliser is output this message!");

        Service service = ctx.getBean(Service.class);

        service.info();
        service.summation();

        ctx.stop();
    }
}
