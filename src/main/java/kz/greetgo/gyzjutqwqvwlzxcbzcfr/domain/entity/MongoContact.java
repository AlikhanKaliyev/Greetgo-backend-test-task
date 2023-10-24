package kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoContact {
    @Id
    private ObjectId id;

    private String name;

    private Integer birthYear;
    @Indexed(unique = true)
    private String firstPhoneNumber;
    @Indexed(unique = true)
    private String secondPhoneNumber;

    private LocalDateTime createdAt;
}
