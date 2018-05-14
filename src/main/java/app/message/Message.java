package app.message;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

public class Message {
    @Id
    @GeneratedValue
    private long messageId;

    private String senderId;
    private String reciverId;
    private String messageContent;
    private LocalDateTime sentTime;

    public Message(long id, String senderId, String reciverId, String content) {
        this.messageId = id;
        this.senderId = senderId;
        this.reciverId = reciverId;
        this.messageContent = content;
        this.sentTime = LocalDateTime.now();
    }
    public Message() {}

    public long getMessageId() {
        return messageId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReciverId() {
        return reciverId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }
}
