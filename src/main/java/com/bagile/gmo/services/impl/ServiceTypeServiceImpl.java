package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ServiceType;
import com.bagile.gmo.entities.TmsServiceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ServiceTypeMapper;
import com.bagile.gmo.repositories.ServiceTypeRepository;
import com.bagile.gmo.services.ServiceTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    
    private final ServiceTypeRepository serviceTypeRepository;

    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @Override
    public ServiceType save(ServiceType serviceType) {
        return ServiceTypeMapper.toDto(serviceTypeRepository.saveAndFlush(ServiceTypeMapper.toEntity(serviceType, false)), false);
    }

    @Override
    public Long size() {
        return serviceTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return serviceTypeRepository.existsById(id);
    }

    @Override
    public ServiceType findById(Long id) throws IdNotFound {
        return ServiceTypeMapper.toDto(serviceTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ServiceType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ServiceTypeMapper.toDtos(serviceTypeRepository.findAll(Search.expression(search, TmsServiceType.class)), false);
    }

    @Override
    public List<ServiceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceTypeMapper.toDtos(serviceTypeRepository.findAll(Search.expression(search, TmsServiceType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return serviceTypeRepository.count(Search.expression(search, TmsServiceType.class));
    }

    @Override
    public void delete(Long id) {
        serviceTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ServiceType serviceType) {
        serviceTypeRepository.delete(ServiceTypeMapper.toEntity(serviceType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            serviceTypeRepository.deleteById(id);        }
    }


    @Override
    public List<ServiceType> findAll() {
        return ServiceTypeMapper.toDtos(serviceTypeRepository.findAll(), false);
    }

    @Override
    public List<ServiceType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceTypeMapper.toDtos(serviceTypeRepository.findAll(pageable), false);
    }

    @Override
    public ServiceType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

