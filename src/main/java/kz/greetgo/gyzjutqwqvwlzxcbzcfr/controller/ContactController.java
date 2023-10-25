package kz.greetgo.gyzjutqwqvwlzxcbzcfr.controller;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactController<C> {
    ResponseEntity getContact(String idOrPhoneNumber);
    ResponseEntity getContacts(Filter filter);
    ResponseEntity updateContact(String idOrPhoneNumber, C contactDTO);
    ResponseEntity deleteContact(String idOrPhoneNumber);
}
