package kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoContactRepository extends MongoRepository<MongoContact, String> {
    @Query("{ '$or': [ { 'firstPhoneNumber': ?0 }, { 'secondPhoneNumber': ?0 }, { '_id': ?0 } ] }")
    MongoContact findContactsByParameter(String parameter);
}
