package kz.greetgo.gyzjutqwqvwlzxcbzcfr.controller;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.MongoContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo-contacts")
@RequiredArgsConstructor
public class MongoContactController {
    private final MongoContactService mongoContactService;

    @GetMapping("/")
    public ResponseEntity getContacts(@RequestBody Filter filter) {
        List<MongoContactDTO> contacts = mongoContactService.getContacts(filter);
        return new ResponseEntity(contacts, HttpStatus.OK);
    }

    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity getContact(@PathVariable String idOrPhoneNumber) {
        MongoContactDTO mongoContactDTO = mongoContactService.getContact(idOrPhoneNumber);
        return new ResponseEntity(mongoContactDTO, HttpStatus.OK);
    }
}
