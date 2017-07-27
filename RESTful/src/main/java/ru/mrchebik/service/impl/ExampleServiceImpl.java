package ru.mrchebik.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mrchebik.model.ExampleModel;
import ru.mrchebik.repository.ExampleRepository;
import ru.mrchebik.service.ExampleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mrchebik on 03.03.17.
 */
@Service
@Transactional
public class ExampleServiceImpl implements ExampleService {
    @Resource
    private ExampleRepository exampleRepository;

    @Override
    public ExampleModel add(ExampleModel model) {
        return exampleRepository.saveAndFlush(model);
    }

    @Override
    public ExampleModel edit(ExampleModel model) {
        return exampleRepository.saveAndFlush(model);
    }

    @Override
    public ExampleModel get(long id) {
        return exampleRepository.findOne(id);
    }

    @Override
    public List<ExampleModel> getAll() {
        return exampleRepository.findAll();
    }

    @Override
    public void remove(long id) {
        exampleRepository.delete(id);
    }

    @Override
    public void removeAll() {
        exampleRepository.deleteAll();
    }
}
