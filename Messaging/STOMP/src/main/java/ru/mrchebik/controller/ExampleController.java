package ru.mrchebik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import ru.mrchebik.model.Example;
import ru.mrchebik.model.Shout;
import ru.mrchebik.service.ExampleFeedService;

/**
 * Created by mrchebik on 11.03.17.
 */
@Controller
public class ExampleController {
    private final ExampleFeedService exampleFeedService;

    @Autowired
    public ExampleController(ExampleFeedService exampleFeedService) {
        this.exampleFeedService = exampleFeedService;
    }

    @MessageMapping("/testStomp")
    @SendTo("/topic/shout")
    public Shout handleShout(Shout incoming) {
        System.out.println("Received message: " + incoming.getMessage());

        Shout outgoing = new Shout();
        outgoing.setMessage("Your message was received. Thanks! !");

        exampleFeedService.broadcastExample(new Example("message", "data"));
        // Message to the user -- exampleFeedService.broadcastExample(new Example("message to @USERNAME", "data"));

        return outgoing;
    }

    @SubscribeMapping("/testStomp")
    public Shout handleSubscription() {
        Shout outgoing = new Shout();
        outgoing.setMessage("You was subscribed to 'testStomp'!");

        return outgoing;
    }

    /*
     * Spring Security
     *
    @MessageMapping("/testStomp")
    @SendTo("/queue/notifications")
    public Notification handleExample(Principal principal, ExampleForm form) {
        ExampleWithUser example = new ExampleWithUser(principal.getName(), form.getText(), new Date());

        service.save(example);

        return new Notification("Saved Example!");
    }
     */

    @MessageExceptionHandler
    // Specific exception class -- @MessageExceptionHandler(ExampleException.class)
    // Specific several exception types -- @MessageExceptionHandler({ ExampleException.class, DatabaseExceptions.class })
    @SendTo("/queue/errors")
    public Throwable handleExceptions(Throwable t) {
        System.out.println("Error handling message: " + t.getMessage());

        return t;
    }
}
