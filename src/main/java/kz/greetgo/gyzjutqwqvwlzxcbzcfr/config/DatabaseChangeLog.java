package kz.greetgo.gyzjutqwqvwlzxcbzcfr.config;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Alikhan")
    public void seedDatabase(MongoRepository mongoRepository) {
        List<MongoContact> contacts = new LinkedList<>();
        contacts.add(createContact(new ObjectId("6537b4fcfeedbb4a275485d2"), "Айжан", 1995, "87776669900", "87712233445", LocalDateTime.now()));
        contacts.add(createContact(new ObjectId("6537b4fcfeedbb4a275485d3"), "Аскар", 1980, "87771112233", "87779998877", LocalDateTime.now()));
        contacts.add(createContact(new ObjectId("6537b4fcfeedbb4a275485d4"), "София", 1998, "87755556666", "87777777777", LocalDateTime.now()));
        contacts.add(createContact(new ObjectId("6537b4fcfeedbb4a275485d5"), "Арман", 1987, "87770001122", "87799998888", LocalDateTime.now()));
        contacts.add(createContact(new ObjectId("6537b4fcfeedbb4a275485d6"), "Мадина", 1992, "87733334444", "87773337733", LocalDateTime.now()));
        mongoRepository.insert(contacts);
    }

    private MongoContact createContact(ObjectId id, String name, int birthYear, String firstTelephoneNumber, String secondPhoneNumber, LocalDateTime createdAt) {
        MongoContact contact = new MongoContact();
        contact.setId(id);
        contact.setName(name);
        contact.setBirthYear(birthYear);
        contact.setFirstPhoneNumber(firstTelephoneNumber);
        contact.setSecondPhoneNumber(secondPhoneNumber);
        contact.setCreatedAt(createdAt);
        return contact;
    }
}
