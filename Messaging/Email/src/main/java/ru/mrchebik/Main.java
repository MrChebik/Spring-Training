package ru.mrchebik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mrchebik.config.Config;
import ru.mrchebik.model.ExamplePost;
import ru.mrchebik.model.ExampleUser;
import ru.mrchebik.service.Sender;

import javax.mail.MessagingException;

/**
 * Created by mrchebik on 12.03.17.
 */
public class Main {
    public static void main(String[] args) throws MessagingException {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Sender sender = context.getBean(Sender.class);

        sender.sendRichExampleEmail("example@mail.com", new ExamplePost("Some title of the post", "Some text of the post", new ExampleUser("example@mail.com", "Jake", "Additional information about this user")));
    }
}
