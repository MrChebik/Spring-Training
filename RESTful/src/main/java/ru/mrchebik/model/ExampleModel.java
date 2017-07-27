package ru.mrchebik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by mrchebik on 03.03.17.
 */
@Entity
@Table(name = "example")
public class ExampleModel implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String data;

    public ExampleModel() {
    }

    public ExampleModel(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public ExampleModel(long id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString() {
        return "Example [" + id + "]: name=" + name + ", data=" + data;
    }
}
