package com.bagile.tms.services.impl;

import com.bagile.tms.entities.TmsVehicleType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleTypeMapper;
import com.bagile.tms.services.VehicleTypeService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by bouzi on 4/4/2017.
 */
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleTypeService.class);



    @Override
    public VehiculeType save(VehiculeType vehiculeType) {
        LOGGER.info("save VehiculeType");

        return VehicleTypeMapper.toDto(vehicleTypeRepository.saveAndFlush(VehicleTypeMapper.toEntity(vehiculeType, false)), false);
    }

    @Override
    public Long size() {
        return vehicleTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleTypeRepository.existsById(id);
    }

    @Override
    public VehiculeType findById(Long id) throws IdNotFound {
        VehiculeType vehiculeType = VehicleTypeMapper.toDto(vehicleTypeRepository.findById(id).get(), false);
        if (null != vehiculeType) {
            return vehiculeType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<VehiculeType> find(String search) throws AttributesNotFound, ErrorType {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(Search.expression(search, TmsVehicleType.class)), false);
    }

    @Override
    public List<VehiculeType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(Search.expression(search, TmsVehicleType.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vehicleTypeRepository.count(Search.expression(search, TmsVehicleType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save VehiculeType");
        vehicleTypeRepository.deleteById(id);
    }

    @Override
    public void delete(VehiculeType vehiculeType) {
        LOGGER.info("delete VehiculeType");
        vehicleTypeRepository.delete(VehicleTypeMapper.toEntity(vehiculeType, false));
    }

    @Override
    public List<VehiculeType> findAll() {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(), false);
    }

    @Override
    public List<VehiculeType> findAll(Pageable pageable) {
        return VehicleTypeMapper.toDtos(vehicleTypeRepository.findAll(pageable), false);
    }
}
