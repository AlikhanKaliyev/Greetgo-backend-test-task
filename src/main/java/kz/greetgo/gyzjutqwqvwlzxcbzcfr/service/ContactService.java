package kz.greetgo.gyzjutqwqvwlzxcbzcfr.service;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;

import java.util.List;

public interface ContactService<C> {
    C getContact(String parameter);
    List<C> getContacts(Filter filter);
}
