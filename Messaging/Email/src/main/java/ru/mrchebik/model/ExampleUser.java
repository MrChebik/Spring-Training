package ru.mrchebik.model;

/**
 * Created by mrchebik on 12.03.17.
 */
public class ExampleUser {
    private String email;
    private String username;
    private String data;

    public ExampleUser(String email, String username, String data) {
        this.email = email;
        this.username = username;
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
