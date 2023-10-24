package kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.DeleteResponse;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception.FilterDataException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception.NoContactFoundException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.mapper.MongoContactMapper;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository.MongoContactRepository;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MongoContactService implements ContactService<MongoContactDTO> {
    private final MongoContactRepository mongoContactRepository;
    private final MongoContactMapper mongoContactMapper;

    @Override
    public MongoContactDTO getContact(String parameter) {
        MongoContact mongoContact = mongoContactRepository.findContactsByParameter(parameter);
        if (mongoContact == null) throw new NoContactFoundException();

        return mongoContactMapper.entityToDTO(mongoContact);
    }

    @Override
    public List<MongoContactDTO> getContacts(Filter filter) {
        Integer offset = filter.getOffset();
        if (offset == null) throw new FilterDataException("offset is not provided");
        Integer limit = filter.getLimit();
        if (limit == null) throw new FilterDataException("limit is not provided");
        Pageable pageRequest = PageRequest.of(offset, limit);
        Page<MongoContact> contacts = mongoContactRepository.findAll(pageRequest);
        return contacts.stream()
                .map(contact -> mongoContactMapper.entityToDTO(contact))
                .collect(Collectors.toList());
    }

    @Override
    public MongoContactDTO updateContact(String parameter, MongoContactDTO contactDTO) {
        return null;
    }

    @Override
    public DeleteResponse deleteContact(String parameter) {
        return null;
    }
}
