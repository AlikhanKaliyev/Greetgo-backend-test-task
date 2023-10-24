package kz.greetgo.gyzjutqwqvwlzxcbzcfr.mapper;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import org.springframework.stereotype.Component;

@Component
public class MongoContactMapper implements Mapper<MongoContact, MongoContactDTO>{
    @Override
    public MongoContactDTO entityToDTO(MongoContact mongoContact) {
        MongoContactDTO mongoContactDTO = new MongoContactDTO();
        mongoContactDTO.setId(mongoContact.getId().toString());
        mongoContactDTO.setName(mongoContact.getName());
        mongoContactDTO.setBirthYear(mongoContact.getBirthYear());
        mongoContactDTO.setFirstPhoneNumber(mongoContact.getFirstPhoneNumber());
        mongoContactDTO.setSecondPhoneNumber(mongoContact.getSecondPhoneNumber());
        mongoContactDTO.setCreatedAt(mongoContact.getCreatedAt());
        return mongoContactDTO;
    }
}
