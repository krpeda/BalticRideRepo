package app.message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends CrudRepository<Message, Long>, MessageRepositoryCustom {
    @Override
    List<Message> findAll();
}
