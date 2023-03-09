package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.entities.AdrAddress;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.AddressDelivery;
import com.bagile.gmo.mapper.AddressMapper;
import com.bagile.gmo.repositories.AddressRepository;
import com.bagile.gmo.services.AddressService;
import com.bagile.gmo.services.PaysService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.VilleService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    @Autowired
    private VilleService villeService;
    @Autowired
    private PaysService paysService;
    @Autowired
    private SettingService settingService;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    private final static Logger LOGGER = LoggerFactory
            .getLogger(Address.class);
    @Override
    public Address save(Address address) {
        return AddressMapper.toDto(addressRepository.saveAndFlush(AddressMapper.toEntity(address, false)), false);
    }

    public List<Address> saveAll(List<Address> addresses) throws AttributesNotFound, ErrorType {

        List<Address> addressList = new ArrayList<>();

        for (Address address : addresses) {
            addressList.add(save(address));
        }

        return addressList;

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
        if (search.equals("")) {
            return findAll();
        }
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class)), false);
    }

    @Override
    public List<Address> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return findAll(page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "cmdAddressUpdateDate");
        Pageable pageable = PageRequest.of(page, size);
        return AddressMapper.toDtos(addressRepository.findAll(Search.expression(search, AdrAddress.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")) {
            return size();
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
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            addressRepository.deleteById(id);        }
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
        String value = settingService.generateCodeAddress() + addressRepository.getNextVal().get(0);
        return value;

    }

    @Override
    public List<AddressDelivery> loadingDataImport(List<AddressDelivery> addressDeliveries) throws ErrorType, AttributesNotFound, IdNotFound {
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();

        for (AddressDelivery addressDelivery : addressDeliveries) {
            try {


                address.setCode(addressDelivery.getAddress_delivery_name());
                address.setName(addressDelivery.getAddress_delivery_name());
                address.setLine1(addressDelivery.getAddress_delivery_line1());
                address.setLine2(addressDelivery.getAddress_delivery_line2());
                address.setZip(addressDelivery.getAddress_delivery_zip());

                address.setVille((villeService.find("code~" + addressDelivery.getAddress_delivery_city())).stream().findFirst().orElse(null));
                address.setPays(paysService.findById(1L));
                address.setAddressType(1L);
                address.setDelivery(true);
                address.setLatitude(address.getVille().getLatitude());
                address.setLongitude(address.getVille().getLongitude());
                addressList.add(save(address));


            }catch (Exception e){
                LOGGER.error("error importing "+ addressDelivery.getAddress_delivery_line1());
            }
        }
        saveAll(addressList);

        return null;

    }

}

