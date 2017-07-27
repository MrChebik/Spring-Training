package ru.mrchebik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.mrchebik.handler.ExampleHandler;

/**
 * Created by mrchebik on 10.03.17.
 */
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(exampleHandler(), "/example").withSockJS();
    }

    @Bean
    public ExampleHandler exampleHandler() {
        return new ExampleHandler();
    }
}
