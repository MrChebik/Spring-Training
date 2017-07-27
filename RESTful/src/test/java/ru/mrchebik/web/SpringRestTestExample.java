package ru.mrchebik.web;

import org.springframework.web.client.RestTemplate;
import ru.mrchebik.model.ExampleModel;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by mrchebik on 04.03.17.
 */
public class SpringRestTestExample {
    private static final String DEFAULT_URI = "http://localhost:8080/";

    private static void createExample() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(DEFAULT_URI + "add", new ExampleModel("name", "data"), ExampleModel.class);
    }

    private static void updateExample() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(DEFAULT_URI + "edit", new ExampleModel(1,"name1", "data1"), ExampleModel.class);
    }

    private static void get() {
        RestTemplate restTemplate = new RestTemplate();
        ExampleModel model = restTemplate.getForObject(DEFAULT_URI + 1, ExampleModel.class);
        System.out.println(model.toString());
    }

    @SuppressWarnings("unchecked")
    private static void getAll() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> examplesMap = restTemplate.getForObject(DEFAULT_URI+"examples", List.class);

        if (examplesMap != null) {
            for(LinkedHashMap<String, Object> map : examplesMap){
                System.out.println("Example : id=" + map.get("id") + ", name=" + map.get("name") + ", data=" + map.get("data"));;
            }
        }
    }

    private static void deleteExample() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DEFAULT_URI+"delete?id=1");
    }

    private static void deleteAllExample() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DEFAULT_URI+"deleteAll");
    }

    public static void main(String[] args) {
        createExample();
        createExample();
        createExample();
        updateExample();
        get();
        getAll();
        deleteExample();
        deleteAllExample();
    }
}
