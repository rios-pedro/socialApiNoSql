package pedrorios.socialapinosql.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pedrorios.socialapinosql.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
