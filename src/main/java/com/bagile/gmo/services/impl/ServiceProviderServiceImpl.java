package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ServiceProvider;
import com.bagile.gmo.entities.GmoServiceProvider;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ServiceProviderMapper;
import com.bagile.gmo.repositories.ServiceProviderRepository;
import com.bagile.gmo.services.ServiceProviderService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
    private final ServiceProviderRepository serviceProviderRepository;

    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public ServiceProvider save(ServiceProvider serviceProvider) {
        return ServiceProviderMapper.toDto(serviceProviderRepository.saveAndFlush(ServiceProviderMapper.toEntity(serviceProvider, false)), false);
    }

    @Override
    public Long size() {
        return serviceProviderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return serviceProviderRepository.existsById(id);
    }

    @Override
    public ServiceProvider findById(Long id) throws IdNotFound {
        return ServiceProviderMapper.toDto(serviceProviderRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ServiceProvider> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ServiceProviderMapper.toDtos(serviceProviderRepository.findAll(Search.expression(search, GmoServiceProvider.class)), false);
    }

    @Override
    public List<ServiceProvider> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceProviderMapper.toDtos(serviceProviderRepository.findAll(Search.expression(search, GmoServiceProvider.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return serviceProviderRepository.count(Search.expression(search, GmoServiceProvider.class));
    }

    @Override
    public void delete(Long id) {
        serviceProviderRepository.deleteById(id);
    }

    @Override
    public void delete(ServiceProvider serviceProvider) {
        serviceProviderRepository.delete(ServiceProviderMapper.toEntity(serviceProvider, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            serviceProviderRepository.deleteById(id);        }
    }


    @Override
    public List<ServiceProvider> findAll() {
        return ServiceProviderMapper.toDtos(serviceProviderRepository.findAll(), false);
    }

    @Override
    public List<ServiceProvider> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceProviderMapper.toDtos(serviceProviderRepository.findAll(pageable), false);
    }

}

