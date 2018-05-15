package app.message;

import app.ride.CustomerDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;

    private String senderId;
    private String receiverId;
    private String messageContent;
    private long rideId;
    @JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
    private Date sentTime;

    public Message(long rideId, String senderId, String receiverId, String content) {
        this.rideId = rideId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageContent = content;
        this.sentTime = new Date();
    }
    public Message() {}

    public long getMessageId() {
        return messageId;
    }

    public long getRideId() {
        return rideId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Date getSentTime() {
        return sentTime;
    }
}
