package ru.mrchebik.config;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.mrchebik.bean.Service;
import ru.mrchebik.intefrace.Count;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 18.02.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ConfigTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired @Qualifier("firstCount")
    private Count count0;
    @Autowired @Qualifier("secondCount")
    private Count count1;
    @Autowired @Qualifier("thirdCount")
    private Count count2;
    @Autowired
    private Service service;

    @Before
    public void setting() {
        count0.setCount(1);
        count1.setCount(2);
        count2.setCount(3);
    }

    @Test
    public void firstCountShouldNotBeNull() {
        assertNotNull(count0);
    }

    @Test
    public void secondCountShouldNotBeNull() {
        assertNotNull(count1);
    }

    @Test
    public void thirdCountShouldNotBeNull() {
        assertNotNull(count2);
    }

    @Test
    public void serviceShouldNotBeNull() {
        assertNotNull(service);
    }

    @Test
    public void countInfoShouldBeEqual() {
        service.info();
        assertEquals("First count: 2\nSecond count: 3\nThird count: 1\n", log.getLog());
    }

    @Test
    public void countSummationShouldBeEqual() {
        service.summation();
        assertEquals("Summation: 6\n", log.getLog());
    }

    /**
     * Testing AspectJ work (Do not forgot to comment lines in CreateCopiesBeanFactoryPostProcessor)
     */
    @Test
    public void settingCount0() {
        count0.setCount(-1);
        assertEquals(10, count0.getCount());
    }
}
