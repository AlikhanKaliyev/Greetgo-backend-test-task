package kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.DeleteResponse;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.MongoContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.MongoContact;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.PsqlContact;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception.DuplicatePhoneNumberException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception.FilterDataException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.exception.NoContactFoundException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.mapper.MongoContactMapper;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository.MongoContactRepository;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.ContactService;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.util.PhoneNumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
        if (offset < 0) throw new FilterDataException("offset can't be less than zero");

        Integer limit = filter.getLimit();
        if (limit == null) throw new FilterDataException("limit is not provided");
        if (limit <= 0) throw new FilterDataException("limit must be more than zero");
        Pageable pageRequest = PageRequest.of(offset, limit);
        Page<MongoContact> contacts = mongoContactRepository.findAll(pageRequest);
        return contacts.stream()
                .map(contact -> mongoContactMapper.entityToDTO(contact))
                .collect(Collectors.toList());
    }

    @Override
    public MongoContactDTO updateContact(String parameter, MongoContactDTO mongoContactDTO) {
        parameter = PhoneNumberUtil.validateAndTransformPhoneNumber(parameter);

        MongoContact contact = mongoContactRepository.findContactsByParameter(parameter);
        if (contact == null) throw new NoContactFoundException();

        String name = mongoContactDTO.getName();
        if (name != null) contact.setName(name);

        Integer birthYear = mongoContactDTO.getBirthYear();
        if (birthYear != null) contact.setBirthYear(birthYear);

        String firstPhoneNumber = mongoContactDTO.getFirstPhoneNumber();
        if (firstPhoneNumber != null) {
            if (PhoneNumberUtil.isPhoneNumberValid(firstPhoneNumber)) {
                firstPhoneNumber = PhoneNumberUtil.transformPhoneNumber(firstPhoneNumber);
                checkPhoneNumberUsing(contact, firstPhoneNumber, "First");
                contact.setFirstPhoneNumber(firstPhoneNumber);

            }
        }

        String secondPhoneNumber = mongoContactDTO.getSecondPhoneNumber();
        if (secondPhoneNumber != null) {
            if (PhoneNumberUtil.isPhoneNumberValid(secondPhoneNumber)) {
                secondPhoneNumber = PhoneNumberUtil.transformPhoneNumber(secondPhoneNumber);
                checkPhoneNumberUsing(contact, secondPhoneNumber, "Second");
                contact.setSecondPhoneNumber(secondPhoneNumber);
            }
        }

        contact = mongoContactRepository.save(contact);
        return mongoContactMapper.entityToDTO(contact);
    }

    private void checkPhoneNumberUsing(MongoContact contact, String phoneNumber, String phoneNumberType) {
        if (!phoneNumber.equals(contact.getFirstPhoneNumber()) && !phoneNumber.equals(contact.getSecondPhoneNumber())) {
            MongoContact existingContactWithPhoneNumber = mongoContactRepository.findContactsByParameter(phoneNumber);
            if (existingContactWithPhoneNumber != null) {
                throw new DuplicatePhoneNumberException(phoneNumberType + " phone number is already in use by another contact.");
            }
        } else {
            throw new DuplicatePhoneNumberException(phoneNumberType + " phone number is already used in this contact.");
        }
    }

    @Override
    public DeleteResponse deleteContact(String parameter) {
        parameter = PhoneNumberUtil.validateAndTransformPhoneNumber(parameter);

        MongoContact contact = mongoContactRepository.findContactsByParameter(parameter);
        if (contact == null) throw new NoContactFoundException();
        String id = contact.getId().toString();
        mongoContactRepository.delete(contact);
        return new DeleteResponse("Deleted contact with id: " + id);
    }
}
