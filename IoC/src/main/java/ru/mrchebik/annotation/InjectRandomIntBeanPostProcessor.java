package ru.mrchebik.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.mrchebik.property.ReaderProperty;

import java.lang.reflect.Field;

/**
 * Created by mrchebik on 18.02.17.
 */
@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try {
            Field count = bean.getClass().getDeclaredField("count");
            count.setAccessible(true);
            InjectRandomInt annotation = count.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                if (annotation.value().equals("")) {
                    ReflectionUtils.setField(count, bean, getRandomIntInRange(annotation.min(), annotation.max()));
                } else if (annotation.value().equals("property")) {
                    ReflectionUtils.setField(count, bean, parseString(ReaderProperty.ranges.get(beanName)));
                }
            }
        } catch (NoSuchFieldException ignored) {
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private int parseString(String range) {
        String[] values = range.split("-");
        return getRandomIntInRange(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    private int getRandomIntInRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
