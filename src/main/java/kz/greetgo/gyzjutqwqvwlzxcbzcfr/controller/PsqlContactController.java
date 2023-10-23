package kz.greetgo.gyzjutqwqvwlzxcbzcfr.controller;

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
public class PsqlContactController {
    private final PsqlContactService psqlContactService;

    @GetMapping("/{idOrPhoneNumber}")
    public ResponseEntity getContact(@PathVariable String idOrPhoneNumber) {
        PsqlContactDTO psqlContactDTO = psqlContactService.getContact(idOrPhoneNumber);
        return new ResponseEntity(psqlContactDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getContacts(@RequestBody Filter filter) {
        List<PsqlContactDTO> psqlContactDTOList= psqlContactService.getContacts(filter);
        return new ResponseEntity(psqlContactDTOList, HttpStatus.OK);
    }
}
