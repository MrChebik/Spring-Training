package ru.mrchebik.model;

/**
 * Created by mrchebik on 12.03.17.
 */
public class ExamplePost {
    private String title;
    private String text;
    private ExampleUser user;

    public ExamplePost(String title, String text, ExampleUser user) {
        this.title = title;
        this.text = text;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ExampleUser getUser() {
        return user;
    }

    public void setUser(ExampleUser user) {
        this.user = user;
    }
}
