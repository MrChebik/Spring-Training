package ru.mrchebik.bean;

import org.springframework.stereotype.Component;
import ru.mrchebik.annotation.InjectRandomInt;
import ru.mrchebik.intefrace.Count;

/**
 * Created by mrchebik on 18.02.17.
 */
@Component("firstCount")
public class CountImpl0 implements Count {
    // @InjectRandomInt
    // @Value("${firstCount}")
    @InjectRandomInt("property")
    private int count;

    public void setCount(int number) {
        count = number;
    }

    public int getCount() {
        return count;
    }
}
