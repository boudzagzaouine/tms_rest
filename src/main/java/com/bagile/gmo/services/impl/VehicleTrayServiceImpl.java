package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VehicleTray;
import com.bagile.gmo.entities.TmsVehicleTray;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleTrayMapper;
import com.bagile.gmo.repositories.VehicleTrayRepository;
import com.bagile.gmo.services.VehicleTrayService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleTrayServiceImpl implements VehicleTrayService {

    private final VehicleTrayRepository vehicleTrayRepository;

    public VehicleTrayServiceImpl(VehicleTrayRepository vehicleTrayRepository) {
        this.vehicleTrayRepository = vehicleTrayRepository;
    }

    @Override
    public VehicleTray save(VehicleTray vehicleTray) {
        return VehicleTrayMapper.toDto(vehicleTrayRepository.saveAndFlush(VehicleTrayMapper.toEntity(vehicleTray, false)), false);
    }

    @Override
    public Long size() {
        return vehicleTrayRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleTrayRepository.existsById(id);
    }

    @Override
    public VehicleTray findById(Long id) throws IdNotFound {
        return VehicleTrayMapper.toDto(vehicleTrayRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VehicleTray> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleTrayMapper.toDtos(vehicleTrayRepository.findAll(Search.expression(search, TmsVehicleTray.class)), false);
    }

    @Override
    public List<VehicleTray> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleTrayMapper.toDtos(vehicleTrayRepository.findAll(Search.expression(search, TmsVehicleTray.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleTrayRepository.count(Search.expression(search, TmsVehicleTray.class));
    }

    @Override
    public void delete(Long id) {
        vehicleTrayRepository.deleteById(id);
    }

    @Override
    public void delete(VehicleTray vehicleTray) {
        vehicleTrayRepository.delete(VehicleTrayMapper.toEntity(vehicleTray, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vehicleTrayRepository.deleteById(id);        }
    }


    @Override
    public List<VehicleTray> findAll()
    {
        return VehicleTrayMapper.toDtos(vehicleTrayRepository.findAll(), false);
    }

    @Override
    public List<VehicleTray> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VehicleTrayMapper.toDtos(vehicleTrayRepository.findAll(pageable), false);
    }

}

