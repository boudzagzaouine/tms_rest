package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.entities.AdrAddress;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AddressMapper;
import com.bagile.gmo.repositories.AddressRepository;
import com.bagile.gmo.services.AddressService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
    }

    @Override
    public Long size() {
        return addressRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return addressRepository.existsById(id);
    }

    @Override
    public Address findById(Long id) throws IdNotFound {
        return AddressMapper.toDto(addressRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public Address findByCode(String code) {
        return null;
    }

    @Override
    public List<Address> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class)), false);
    }

    @Override
    public List<Address> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "cmdAddressUpdateDate");
        Pageable pageable = PageRequest.of(page, size);
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return addressRepository.count(Search.expression(search, AdrAddress.class));
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(AddressMapper.toEntity(address, false));
    }

    @Override
    public Address findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return AddressMapper.toDtos(addressRepository.findAll(), false);
    }

    @Override
    public List<Address> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AddressMapper.toDtos(addressRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        return null;
    }

}

