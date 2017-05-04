package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Address;
import com.sinno.ems.entities.AdrAddress;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AddressMapper;
import com.sinno.ems.repositories.AddressRepository;
import com.sinno.ems.service.AccountService;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AddressService.class);
    @Override
    public Address save(Address address) {
        LOGGER.info("save Address");
        address.setUpdateDate(EmsDate.getDateNow());
        if (0 >= address.getId()) {
            address.setCreationDate(EmsDate.getDateNow());
        }
        return AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
    }

    @Override
    public Long size() {
        return addressRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return addressRepository.exists(id);
    }

    @Override
    public Address findById(Long id) throws IdNotFound {
        Address address = AddressMapper.toDto(addressRepository.findOne(id), false);
        if (null != address) {
            return address;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Address> find(String search) throws AttributesNotFound, ErrorType {
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class)), false);
    }

    @Override
    public List<Address> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "adrAddressUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return addressRepository.count(Search.expression(search, AdrAddress.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Address");
        addressRepository.delete(id);
    }

    @Override
    public void delete(Address address) {
        LOGGER.info("delete Address");
        addressRepository.delete(AddressMapper.toEntity(address, false));
    }

    @Override
    public List<Address> findAll() {
        return AddressMapper.toDtos(addressRepository.findAll(), false);
    }

    @Override
    public List<Address> findAll(Pageable pageable) {
        return AddressMapper.toDtos(addressRepository.findAll(pageable), false);
    }
}