package kz.greetgo.gyzjutqwqvwlzxcbzcfr;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.PsqlContact;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.MongoContactService;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.PsqlContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
class GyzjutqwqvwlzxcbzcfrApplicationTests extends AbstractTestNGSpringContextTests {
    @Autowired
    private PsqlContactService psqlContactService;

    @Autowired
    private MongoContactService mongoContactService;

    @Test
    void checkPsqlGetContact() {
        PsqlContactDTO psqlContactDTO1 = psqlContactService.getContact("83210715-30e8-46f5-a09f-9886ba986c84");
        PsqlContactDTO psqlContactDTO2 = psqlContactService.getContact("87755556666");
        PsqlContactDTO psqlContactDTO3 = psqlContactService.getContact("87777777777");
        Assert.assertEquals(psqlContactDTO1, psqlContactDTO2);
        Assert.assertEquals(psqlContactDTO2, psqlContactDTO3);
    }

    @Test
    void checkMongoGetContact() {
        MongoContactDTO psqlContactDTO1 = mongoContactService.getContact("6537b6b179b7d360ea78b8d3");
        MongoContactDTO psqlContactDTO2 = mongoContactService.getContact("87755556666");
        MongoContactDTO psqlContactDTO3 = mongoContactService.getContact("87777777777");
        Assert.assertEquals(psqlContactDTO1, psqlContactDTO2);
        Assert.assertEquals(psqlContactDTO2, psqlContactDTO3);
    }

}
