package ru.mrchebik.service;

import ru.mrchebik.model.ExampleModel;

import java.util.List;

/**
 * Created by mrchebik on 03.03.17.
 */
public interface ExampleService {
    ExampleModel add(ExampleModel model);
    ExampleModel edit(ExampleModel model);
    ExampleModel get(long id);
    List<ExampleModel> getAll();
    void remove(long id);
    void removeAll();
}
