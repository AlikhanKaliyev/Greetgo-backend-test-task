package kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.impl;

import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.Filter;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto.PsqlContactDTO;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.entity.PsqlContact;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.exception.FilterDataException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.exception.NoContactFoundException;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.mapper.PsqlContactMapper;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.repository.PsqlContactRepository;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.service.ContactService;
import kz.greetgo.gyzjutqwqvwlzxcbzcfr.util.PhoneNumberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PsqlContactService implements ContactService<PsqlContactDTO> {
    private final PsqlContactRepository psqlContactRepository;

    private final PsqlContactMapper psqlContactMapper;

    @Override
    public PsqlContactDTO getContact(String parameter) {
        parameter = PhoneNumberUtil.validateAndTransformPhoneNumber(parameter);

        PsqlContact contact = psqlContactRepository.findContactsByParameter(parameter);
        if (contact == null) throw new NoContactFoundException();

        return psqlContactMapper.entityToDTO(contact);
    }

    @Override
    public List<PsqlContactDTO> getContacts(Filter filter) {
        Integer offset = filter.getOffset();
        if (offset == null) throw new FilterDataException("offset is not provided");
        if (offset < 0) throw new FilterDataException("offset can't be less than zero");

        Integer limit = filter.getLimit();
        if (limit == null) throw new FilterDataException("limit is not provided");
        if (limit <= 0) throw new FilterDataException("limit must be more than zero");

        Pageable pageRequest = PageRequest.of(offset, limit);
        Page<PsqlContact> contacts = psqlContactRepository.findAll(pageRequest);

        return contacts.stream()
                .map(contact -> psqlContactMapper.entityToDTO(contact))
                .collect(Collectors.toList());
    }
}
