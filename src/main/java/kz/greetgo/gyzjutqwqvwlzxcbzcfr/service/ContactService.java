package kz.greetgo.gyzjutqwqvwlzxcbzcfr.service;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.DeleteResponse;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;

import java.util.List;

public interface ContactService<C> {
    C getContact(String parameter);
    List<C> getContacts(Filter filter);

    C updateContact (String parameter, C contactDTO);

    DeleteResponse deleteContact(String parameter);
}
