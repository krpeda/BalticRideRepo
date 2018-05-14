package app.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public MessageService(MessageRepository repository) {this.messageRepository = repository;}

    public Message addMessage(Message message){return messageRepository.save(message);}
    public List<Message> getUserMessages(String userId) {return messageRepository.getUserMessages(userId);}
    public void deleteMessage(String messageId) { messageRepository.deleteMessage(messageId);}
    public Message getMessageById(String messageId) {return messageRepository.findOne(Long.parseLong(messageId));}
}
