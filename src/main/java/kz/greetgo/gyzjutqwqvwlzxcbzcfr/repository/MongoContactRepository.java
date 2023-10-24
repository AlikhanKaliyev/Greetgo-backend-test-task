package kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoContactRepository extends MongoRepository<MongoContact, String> {
}
