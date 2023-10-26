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

@SpringBootTest
class GyzjutqwqvwlzxcbzcfrApplicationTests extends AbstractTestNGSpringContextTests {
    @MockBean
    private PsqlContactService psqlContactService;

    @MockBean
    private MongoContactService mongoContactService;

    @Test
    void checkPsqlGetContact() {
        PsqlContactDTO psqlContactDTO1 = new PsqlContactDTO();
        PsqlContactDTO psqlContactDTO2 = new PsqlContactDTO();
        PsqlContactDTO psqlContactDTO3 = new PsqlContactDTO();

        Mockito.when(psqlContactService.getContact("83210715-30e8-46f5-a09f-9886ba986c84")).thenReturn(psqlContactDTO1);
        Mockito.when(psqlContactService.getContact("87755556666")).thenReturn(psqlContactDTO2);
        Mockito.when(psqlContactService.getContact("87777777777")).thenReturn(psqlContactDTO3);

        Assert.assertEquals(psqlContactDTO1, psqlContactDTO2);
        Assert.assertEquals(psqlContactDTO2, psqlContactDTO3);
    }

    @Test
    void checkMongoGetContact() {
        MongoContactDTO mongoContactDTO1 = new MongoContactDTO();
        MongoContactDTO mongoContactDTO2 = new MongoContactDTO();
        MongoContactDTO mongoContactDTO3 = new MongoContactDTO();

        Mockito.when(mongoContactService.getContact("6537b4fcfeedbb4a275485d4")).thenReturn(mongoContactDTO1);
        Mockito.when(mongoContactService.getContact("87755556666")).thenReturn(mongoContactDTO2);
        Mockito.when(mongoContactService.getContact("87777777777")).thenReturn(mongoContactDTO3);

        Assert.assertEquals(mongoContactDTO1, mongoContactDTO2);
        Assert.assertEquals(mongoContactDTO2, mongoContactDTO3);
    }

}
