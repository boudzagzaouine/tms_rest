package com.bagile.tms.services.impl;

import com.bagile.tms.dto.TransportCategoryVehicle;
import com.bagile.tms.entities.TmsTransportCategoryVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TransportCategoryVehicleMapper;
import com.bagile.tms.repositories.TransportCategoryVehicleRepository;
import com.bagile.tms.services.TransportCategoryVehicleService;
import com.bagile.tms.services.TransportService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TransportCategoryVehicleServiceImpl implements TransportCategoryVehicleService {
    
    private final TransportCategoryVehicleRepository transportCategoryVehicleRepository;
    public TransportCategoryVehicleServiceImpl(TransportCategoryVehicleRepository transportCategoryVehicleRepository) {
        this.transportCategoryVehicleRepository = transportCategoryVehicleRepository;
    }

    @Override
    public TransportCategoryVehicle save(TransportCategoryVehicle transport) {
        return TransportCategoryVehicleMapper.toDto(transportCategoryVehicleRepository.saveAndFlush(TransportCategoryVehicleMapper.toEntity(transport, false)), false);
    }

    @Override
    public Long size() {
        return transportCategoryVehicleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportCategoryVehicleRepository.existsById(id);
    }

    @Override
    public TransportCategoryVehicle findById(Long id) throws IdNotFound {
        return TransportCategoryVehicleMapper.toDto(transportCategoryVehicleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportCategoryVehicle> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportCategoryVehicleMapper.toDtos(transportCategoryVehicleRepository.findAll(Search.expression(search, TmsTransportCategoryVehicle.class)), false);
    }

    @Override
    public List<TransportCategoryVehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportCategoryVehicleMapper.toDtos(transportCategoryVehicleRepository.findAll(Search.expression(search, TmsTransportCategoryVehicle.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportCategoryVehicleRepository.count(Search.expression(search, TmsTransportCategoryVehicle.class));
    }

    @Override
    public void delete(Long id) {
        transportCategoryVehicleRepository.deleteById(id);
    }

    @Override
    public void delete(TransportCategoryVehicle transport) {
        transportCategoryVehicleRepository.delete(TransportCategoryVehicleMapper.toEntity(transport, false));
    }

    @Override
    public List<TransportCategoryVehicle> findAll() {
        return TransportCategoryVehicleMapper.toDtos(transportCategoryVehicleRepository.findAll(), false);
    }

    @Override
    public List<TransportCategoryVehicle> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportCategoryVehicleMapper.toDtos(transportCategoryVehicleRepository.findAll(pageable), false);
    }

}

