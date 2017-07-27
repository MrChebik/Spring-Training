package ru.mrchebik.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.mrchebik.handler.ExampleNotFoundException;
import ru.mrchebik.model.Error;
import ru.mrchebik.model.ExampleModel;
import ru.mrchebik.service.ExampleService;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by mrchebik on 02.03.17.
 */
@RestController
public class IndexController {
    @Resource
    private ExampleService exampleService;

    @RequestMapping(value = "/add", method = PUT)
    public ResponseEntity<ExampleModel> add(@RequestBody ExampleModel exampleModel) {
        return new ResponseEntity<>(exampleService.add(exampleModel), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/edit", method = PUT)
    public ResponseEntity<ExampleModel> edit(@RequestBody ExampleModel exampleModel) {
        if (exampleService.get(exampleModel.getId()) == null) {
            throw new ExampleNotFoundException(exampleModel.getId());
        }

        return new ResponseEntity<>(exampleService.edit(exampleModel), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ExampleModel getOne(@PathVariable long id) {
        ExampleModel model = exampleService.get(id);
        if (model == null) {
            throw new ExampleNotFoundException(id);
        }

        return model;
    }

    @RequestMapping(value = "/examples", method = GET)
    public ResponseEntity<List<ExampleModel>> getAll() {
        return new ResponseEntity<>(exampleService.getAll(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/delete", method = DELETE)
    public ResponseEntity<Void> delete(@RequestParam String id,
                       UriComponentsBuilder uriComponentsBuilder) {
        long correctId = Long.parseLong(id);
        if (exampleService.get(correctId) == null) {
            throw new ExampleNotFoundException(correctId);
        }
        exampleService.remove(correctId);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri =
                uriComponentsBuilder.path("/example/")
                .path("delete/")
                .path("id")
                .queryParam("successful")
                .build()
                .toUri();
        headers.setLocation(locationUri);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteAll", method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        exampleService.removeAll();
    }

    @ExceptionHandler(ExampleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error exampleNotFound(ExampleNotFoundException e) {
        return new Error(404, "Example [" + e.getId() + "] not found");
    }
}
