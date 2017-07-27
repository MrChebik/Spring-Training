package ru.mrchebik.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import ru.mrchebik.model.Example;
import ru.mrchebik.service.ExampleFeedService;

/**
 * Created by mrchebik on 11.03.17.
 */
@Service
public class ExampleFeedServiceImpl implements ExampleFeedService {
    private final SimpMessageSendingOperations messaging;
    // Message to the user -- private Pattern pattern = Pattern.compile("\\@(\\S+)");

    @Autowired
    public ExampleFeedServiceImpl(SimpMessageSendingOperations messaging) {
        this.messaging = messaging;
    }

    public void broadcastExample(Example example) {
        messaging.convertAndSend("/topic/exampleFeed", example);

        /*
         * Message to the user
         *
        Matcher matcher = pattern.matcher(example.getMessage());
        if (matcher.find()) {
            String username = matcher.group(1);
            messaging.convertAndSendToUser(username, "/queue/notifications", new Shout("You just got mentioned!")); // Message to '/user/USERNAME/queue/notifications
        }
         */
    }
}
