package condonr4.api.repositories;

import condonr4.api.model.QBox;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QBoxRepository extends MongoRepository<QBox, String> {
    List<QBox> findAll();
    QBox getByIpAddress(String ipAddress);
    void deleteById(String id);
}
