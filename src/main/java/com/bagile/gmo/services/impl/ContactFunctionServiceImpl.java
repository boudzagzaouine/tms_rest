package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ContactFunction;
import com.bagile.gmo.entities.TmsContactFunction;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ContactFunctionMapper;
import com.bagile.gmo.repositories.ContactFunctionRepository;
import com.bagile.gmo.services.ContactFunctionService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactFunctionServiceImpl implements ContactFunctionService {
    
    private final ContactFunctionRepository contactFunctionRepository;

    public ContactFunctionServiceImpl(ContactFunctionRepository contactFunctionRepository) {
        this.contactFunctionRepository = contactFunctionRepository;
    }

    @Override
    public ContactFunction save(ContactFunction contactFunction) {
        return ContactFunctionMapper.toDto(contactFunctionRepository.saveAndFlush(ContactFunctionMapper.toEntity(contactFunction, false)), false);
    }

    @Override
    public Long size() {
        return contactFunctionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return contactFunctionRepository.existsById(id);
    }

    @Override
    public ContactFunction findById(Long id) throws IdNotFound {
        return ContactFunctionMapper.toDto(contactFunctionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ContactFunction> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ContactFunctionMapper.toDtos(contactFunctionRepository.findAll(Search.expression(search, TmsContactFunction.class)), false);
    }

    @Override
    public List<ContactFunction> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ContactFunctionMapper.toDtos(contactFunctionRepository.findAll(Search.expression(search, TmsContactFunction.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return contactFunctionRepository.count(Search.expression(search, TmsContactFunction.class));
    }

    @Override
    public void delete(Long id) {
        contactFunctionRepository.deleteById(id);
    }

    @Override
    public void delete(ContactFunction contactFunction) {
        contactFunctionRepository.delete(ContactFunctionMapper.toEntity(contactFunction, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            contactFunctionRepository.deleteById(id);        }
    }


    @Override
    public List<ContactFunction> findAll() {
        return ContactFunctionMapper.toDtos(contactFunctionRepository.findAll(), false);
    }

    @Override
    public List<ContactFunction> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ContactFunctionMapper.toDtos(contactFunctionRepository.findAll(pageable), false);
    }

    @Override
    public ContactFunction findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

