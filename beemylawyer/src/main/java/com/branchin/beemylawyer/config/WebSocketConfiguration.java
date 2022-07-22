package com.branchin.beemylawyer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
//@EnableWebSocket
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final static String CHAT_ENDPOINT = "/chat";

    /*** address clients will have to pin to connect with socket ***/
    /***
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        webSocketHandlerRegistry.addHandler(getChatWebSocketHandler(), CHAT_ENDPOINT)
                .setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler getChatWebSocketHandler(){
        return new ChatWebSocketHandler();
    }
    ***/

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       registry.setApplicationDestinationPrefixes("/app");
       /*** all socket data coming from client will pass through routing /app before going to MessageMapping functions
        client send function all need to add /app/funcMappingDestination ***/
       registry.enableSimpleBroker("/lawyers");
       /*** all socket data will be sent to broker /lawyers before going back to client ***/
       registry.setUserDestinationPrefix("/user");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").setAllowedOriginPatterns("*").withSockJS();
    }

}