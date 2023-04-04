package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VehicleAccompaniment;
import com.bagile.gmo.entities.TmsVehicleAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleAccompanimentMapper;
import com.bagile.gmo.repositories.VehicleAccompanimentRepository;
import com.bagile.gmo.services.VehicleAccompanimentService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleAccompanimentServiceImpl implements VehicleAccompanimentService {

    private final VehicleAccompanimentRepository vehicleAccompanimentRepository;

    public VehicleAccompanimentServiceImpl(VehicleAccompanimentRepository vehicleAccompanimentRepository) {
        this.vehicleAccompanimentRepository = vehicleAccompanimentRepository;
    }

    @Override
    public VehicleAccompaniment save(VehicleAccompaniment vehicleAccompaniment) {
        return VehicleAccompanimentMapper.toDto(vehicleAccompanimentRepository.saveAndFlush(VehicleAccompanimentMapper.toEntity(vehicleAccompaniment, false)), false);
    }

    @Override
    public Long size() {
        return vehicleAccompanimentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleAccompanimentRepository.existsById(id);
    }

    @Override
    public VehicleAccompaniment findById(Long id) throws IdNotFound {
        return VehicleAccompanimentMapper.toDto(vehicleAccompanimentRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleAccompaniment> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleAccompanimentMapper.toDtos(vehicleAccompanimentRepository.findAll(Search.expression(search, TmsVehicleAccompaniment.class)), false);
    }

    @Override
    public List<VehicleAccompaniment> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleAccompanimentMapper.toDtos(vehicleAccompanimentRepository.findAll(Search.expression(search, TmsVehicleAccompaniment.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleAccompanimentRepository.count(Search.expression(search, TmsVehicleAccompaniment.class));
    }

    @Override
    public void delete(Long id) {
        vehicleAccompanimentRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleAccompaniment vehicleAccompaniment) {
        vehicleAccompanimentRepository.delete(VehicleAccompanimentMapper.toEntity(vehicleAccompaniment, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vehicleAccompanimentRepository.deleteById(id);        }
    }


    @Override
    public List<VehicleAccompaniment> findAll()
    {
        return VehicleAccompanimentMapper.toDtos(vehicleAccompanimentRepository.findAll(), false);
    }

    @Override
    public List<VehicleAccompaniment> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleAccompanimentMapper.toDtos(vehicleAccompanimentRepository.findAll(pageable), false);
    }

}

