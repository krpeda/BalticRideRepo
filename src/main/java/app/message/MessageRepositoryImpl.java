package app.message;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class MessageRepositoryImpl implements MessageRepositoryCustom {
    @PersistenceContext
    private EntityManager manager;

    public List<Message> getUserMessages(String userId) {
        TypedQuery<Message> query = manager.createQuery("FROM Message c WHERE c.receiver_id = :receiverId", Message.class);
        List <Message> foundMessages = null;
        try {
            query.setParameter("receiverId", userId);
            foundMessages = query.getResultList();
        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }
        return foundMessages;
    }

    @Override
    public void deleteMessage(String messageId) {
        Query query = manager.createQuery("DELETE FROM Message WHERE message_id = :messageId");
        try {
            query.setParameter("messageId", Long.parseLong(messageId)).executeUpdate();
        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }
    }
}
