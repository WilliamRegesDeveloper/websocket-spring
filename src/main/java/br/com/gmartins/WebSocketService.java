package br.com.gmartins;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketService implements WebSocketMessageBrokerConfigurer {


  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic");
    registry.setUserDestinationPrefix("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat");
    registry.addEndpoint("/chat").withSockJS();
  }


  @MessageMapping("/app.message")
  @SendTo("/topic/messages")
  public OutputMessage send(Message message){
    String format = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    return new OutputMessage(message.getFrom(), message.getText(), format);
  }
}
