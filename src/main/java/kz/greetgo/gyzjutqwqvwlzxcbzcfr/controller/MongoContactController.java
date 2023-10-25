package kz.greetgo.gyzjutqwqvwlzxcbzcfr.controller;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.DeleteResponse;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.MongoContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongo-contacts")
@RequiredArgsConstructor
public class MongoContactController implements ContactController<MongoContactDTO>{
    private final MongoContactService mongoContactService;

    @Override
    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity getContact(@PathVariable String idOrPhoneNumber) {
        MongoContactDTO mongoContactDTO = mongoContactService.getContact(idOrPhoneNumber);
        return new ResponseEntity(mongoContactDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity getContacts(@RequestBody Filter filter) {
        List<MongoContactDTO> contacts = mongoContactService.getContacts(filter);
        return new ResponseEntity(contacts, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{idOrPhoneNumber}")
    public ResponseEntity updateContact(@PathVariable String idOrPhoneNumber, @RequestBody MongoContactDTO mongoContactDTO) {
        MongoContactDTO updatedMongoContactDTO = mongoContactService.updateContact(idOrPhoneNumber, mongoContactDTO);
        return new ResponseEntity(updatedMongoContactDTO, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{idOrPhoneNumber}")
    public ResponseEntity deleteContact(@PathVariable String idOrPhoneNumber) {
        DeleteResponse deleteResponse = mongoContactService.deleteContact(idOrPhoneNumber);
        return new ResponseEntity(deleteResponse, HttpStatus.OK);
    }
}
