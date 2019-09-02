package br.com.gmartins.resource;

import br.com.gmartins.model.Message;
import br.com.gmartins.model.OutputMessage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

  @MessageMapping("/message")
  @SendTo("/topic/messages")
  public OutputMessage send(Message message){
    String format = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    return new OutputMessage(message.getFrom(), message.getText(), format);
  }

}
