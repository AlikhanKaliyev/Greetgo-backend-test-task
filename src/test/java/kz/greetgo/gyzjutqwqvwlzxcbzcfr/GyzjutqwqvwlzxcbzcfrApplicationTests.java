package kz.greetgo.gyzjutqwqvwlzxcbzcfr;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.MongoContactService;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.PsqlContactService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
class GyzjutqwqvwlzxcbzcfrApplicationTests extends AbstractTestNGSpringContextTests {
    @MockBean
    private PsqlContactService psqlContactService;

    @MockBean
    private MongoContactService mongoContactService;

    @Test
    void checkPsqlGetContact() {
        PsqlContactDTO expectedPsqlContactDTO = new PsqlContactDTO();
        expectedPsqlContactDTO.setId(UUID.fromString("83210715-30e8-46f5-a09f-9886ba986c84"));
        expectedPsqlContactDTO.setName("София");
        expectedPsqlContactDTO.setBirthYear(1998);
        expectedPsqlContactDTO.setFirstPhoneNumber("87755556666");
        expectedPsqlContactDTO.setSecondPhoneNumber("87777777777");
        expectedPsqlContactDTO.setCreatedAt(LocalDateTime.now());

        Mockito.when(psqlContactService.getContact("83210715-30e8-46f5-a09f-9886ba986c84")).thenReturn(expectedPsqlContactDTO);

        PsqlContactDTO resultPsqlContactDTO = psqlContactService.getContact("83210715-30e8-46f5-a09f-9886ba986c84");

        Mockito.verify(psqlContactService).getContact("83210715-30e8-46f5-a09f-9886ba986c84");

        Assert.assertEquals(expectedPsqlContactDTO, resultPsqlContactDTO);
    }

    @Test
    void checkMongoGetContact() {
        MongoContactDTO expectedMongoContactDTO = new MongoContactDTO();
        expectedMongoContactDTO.setId("6537b4fcfeedbb4a275485d4");
        expectedMongoContactDTO.setName("София");
        expectedMongoContactDTO.setBirthYear(1998);
        expectedMongoContactDTO.setFirstPhoneNumber("87755556666");
        expectedMongoContactDTO.setSecondPhoneNumber("87777777777");
        expectedMongoContactDTO.setCreatedAt(LocalDateTime.now());

        Mockito.when(mongoContactService.getContact("87777777777")).thenReturn(expectedMongoContactDTO);

        MongoContactDTO resultMongoContactDTO = mongoContactService.getContact("87777777777");

        Mockito.verify(mongoContactService).getContact("87777777777");

        Assert.assertEquals(expectedMongoContactDTO, resultMongoContactDTO);
    }

}
