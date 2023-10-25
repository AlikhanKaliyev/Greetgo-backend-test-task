package kz.greetgo.gyzjutqwqvwlzxcbzcfr.controller;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.DeleteResponse;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl.PsqlContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class PsqlContactController implements ContactController<PsqlContactDTO>{
    private final PsqlContactService psqlContactService;

    @Override
    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity getContact(@PathVariable String idOrPhoneNumber) {
        PsqlContactDTO psqlContactDTO = psqlContactService.getContact(idOrPhoneNumber);
        return new ResponseEntity(psqlContactDTO, HttpStatus.OK);
    }

    @Override
    @GetMapping("/")
    public ResponseEntity getContacts(@RequestBody Filter filter) {
        List<PsqlContactDTO> psqlContactDTOList= psqlContactService.getContacts(filter);
        return new ResponseEntity(psqlContactDTOList, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{idOrPhoneNumber}")
    public ResponseEntity updateContact(@PathVariable String idOrPhoneNumber, @RequestBody PsqlContactDTO psqlContactDTO) {
        PsqlContactDTO updatedPsqlContactDTO = psqlContactService.updateContact(idOrPhoneNumber, psqlContactDTO);
        return new ResponseEntity(updatedPsqlContactDTO, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{idOrPhoneNumber}")
    public ResponseEntity deleteContact(@PathVariable String idOrPhoneNumber) {
        DeleteResponse deleteResponse = psqlContactService.deleteContact(idOrPhoneNumber);
        return new ResponseEntity(deleteResponse, HttpStatus.OK);
    }
}
