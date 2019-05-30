package condonr4.api.repositories;

import condonr4.api.model.Shows;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShowRepository extends MongoRepository<Shows, String> {
    void deleteById(String id);
    Shows findByName(String name);
    List<Shows> findAll();
}
