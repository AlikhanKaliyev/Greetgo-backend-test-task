package kz.greetgo.gyzjutqwqvwlzxcbzcfr.mapper;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.PsqlContact;
import org.springframework.stereotype.Component;

@Component
public class PsqlContactMapper implements Mapper<PsqlContact, PsqlContactDTO>{
    @Override
    public PsqlContactDTO entityToDTO(PsqlContact psqlContact) {
        PsqlContactDTO psqlContactDTO = new PsqlContactDTO();
        psqlContactDTO.setId(psqlContact.getId());
        psqlContactDTO.setName(psqlContact.getName());
        psqlContactDTO.setBirthYear(psqlContact.getBirthYear());
        psqlContactDTO.setFirstPhoneNumber(psqlContact.getFirstPhoneNumber());
        psqlContactDTO.setSecondPhoneNumber(psqlContact.getSecondPhoneNumber());
        psqlContactDTO.setCreatedAt(psqlContact.getCreatedAt());
        return psqlContactDTO;
    }
}
