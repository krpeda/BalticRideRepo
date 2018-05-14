package app.message;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService service) {
        this.messageService = service;
    }

    @RequestMapping(value = "/messages/add", method = RequestMethod.POST, consumes = "application/json")
    public Message addMessage(@RequestBody Message message) { return messageService.addMessage(message);}

    @RequestMapping(value = "/user/{userId}/messages", method = RequestMethod.GET)
    public List<Message> getUserMessages(@PathVariable String userId){return messageService.getUserMessages(userId);}

    @RequestMapping (value = "messages/{messageId}/delete", method = RequestMethod.GET)
    public void deleteMessage(@PathVariable String messageId) {messageService.deleteMessage(messageId);}

    @RequestMapping (value = "messages/{messageId}", method = RequestMethod.GET)
    public Message getMessageById(String messageId) {return messageService.getMessageById(messageId);}
}
