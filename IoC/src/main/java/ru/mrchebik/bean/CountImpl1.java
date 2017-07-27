package ru.mrchebik.bean;

import org.springframework.stereotype.Component;
import ru.mrchebik.annotation.InjectRandomInt;
import ru.mrchebik.intefrace.Count;

/**
 * Created by mrchebik on 18.02.17.
 */
@Component("secondCount")
public class CountImpl1 implements Count {
    // @InjectRandomInt
    // @Value("${secondCount}")
    @InjectRandomInt("property")
    private int count;

    public void setCount(int number) {
        count = number;
    }

    public int getCount() {
        return count;
    }
}
