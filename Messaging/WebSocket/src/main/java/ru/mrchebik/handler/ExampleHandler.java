package ru.mrchebik.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by mrchebik on 10.03.17.
 */
public class ExampleHandler extends AbstractWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connection established");
    }

    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        System.out.println(new String(message.asBytes()));

        session.sendMessage(new TextMessage("Hello!\nYou connected to the WebSocket!"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus status) throws Exception {
        System.out.println("Connection closed. Status: " + status);
    }
}
