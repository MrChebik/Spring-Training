package ru.mrchebik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import ru.mrchebik.model.ExamplePost;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mrchebik on 12.03.17.
 */
@Component
public class Sender {
    private final JavaMailSender mailSender;

    @Autowired
    public Sender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleExampleMessage(String to, ExamplePost examplePost) {
        SimpleMailMessage message = new SimpleMailMessage();
        String exampleName = examplePost.getUser().getUsername();

        message.setFrom("noreplay@company.com");
        message.setTo(to);
        message.setSubject("New post from " + exampleName);
        message.setText(exampleName + " says: " + examplePost.getText());

        mailSender.send(message);
    }

    public void sendExampleEmailWithAttachement(String to, ExamplePost examplePost) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String exampleName = examplePost.getUser().getUsername();

        helper.setFrom("mrchebik@yandex.ru");
        helper.setTo(to);
        helper.setSubject("New post from " + exampleName);
        helper.setText(exampleName + " says: " + examplePost.getText());

        // FileSystemResource image = new FileSystemResource("/path/image.png");
        // helper.addAttachment("Image.png", image);
        helper.addAttachment("Cardinal.png", new InputStreamSource() {
            public InputStream getInputStream() throws IOException {
                return Sender.class.getClassLoader().getResourceAsStream("cardinal.jpg");
            }
        });

        mailSender.send(message);
    }

    public void sendRichExampleEmail(String to, ExamplePost examplePost) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        String exampleName = examplePost.getUser().getUsername();

        helper.setFrom("mrchebik@yandex.ru");
        helper.setTo(to);
        helper.setSubject("New post from " + exampleName);
        helper.setText("<html><body><img src='cid:logo'><h4>" + exampleName + " says:</h4> <i>" + examplePost.getText() + "</i></body></html>", true);

        // ClassPathResource image = new ClassPathResource("image.png");
        // helper.addInline("logo", image);
        FileSystemResource resource = new FileSystemResource("/home/mrchebik/IdeaProjects/SpringMessaging-Training/Email/src/main/resources/cardinal.jpg");
        helper.addInline("logo", resource);

        mailSender.send(message);
    }
}
