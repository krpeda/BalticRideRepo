package app.message;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepositoryCustom {
    List<Message> getUserMessages(String userId);
    void deleteMessage(String messageId);

}
