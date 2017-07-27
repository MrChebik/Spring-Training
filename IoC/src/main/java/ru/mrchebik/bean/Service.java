package ru.mrchebik.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.mrchebik.intefrace.Count;

/**
 * Created by mrchebik on 18.02.17.
 */
@org.springframework.stereotype.Service
public class Service {
    @Autowired @Qualifier("secondCount")
    private Count count0;
    @Autowired @Qualifier("thirdCount")
    private Count count1;
    @Autowired @Qualifier("firstCount")
    private Count count2;

    public void info() {
        System.out.printf("First count: %d\nSecond count: %d\nThird count: %d\n", count0.getCount(), count1.getCount(), count2.getCount());
    }

    public void summation() {
        System.out.println("Summation: " + (count0.getCount() + count1.getCount() + count2.getCount()));
    }
}
