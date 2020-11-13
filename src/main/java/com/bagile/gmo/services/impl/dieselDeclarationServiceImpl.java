package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.DieselDeclaration;
import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.entities.GmoDieselDeclaration;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DieselDeclarationMapper;
import com.bagile.gmo.repositories.DieselDeclarationRepository;
import com.bagile.gmo.services.DieselDeclarationService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.VehicleService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
@Transactional
public class dieselDeclarationServiceImpl implements DieselDeclarationService {

    private final DieselDeclarationRepository dieselDeclarationRepository;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private SettingService settingService;
    public dieselDeclarationServiceImpl(DieselDeclarationRepository dieselDeclarationRepository) {
        this.dieselDeclarationRepository = dieselDeclarationRepository;
    }

    @Override
    public DieselDeclaration save(DieselDeclaration dieselDeclaration) throws AttributesNotFound, ErrorType, IdNotFound, IOException {
       DieselDeclaration dDeclaration=  DieselDeclarationMapper.toDto(dieselDeclarationRepository.saveAndFlush(DieselDeclarationMapper.toEntity(dieselDeclaration, false)), false);

        Vehicle vehicle = vehicleService.findById(dDeclaration.getVehicle().getId());
        vehicle.setCurrentMileage(dDeclaration.getMileage());
        vehicleService.save(vehicle);
        return dDeclaration;

    }

    @Override
    public Long size() {
        return dieselDeclarationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return dieselDeclarationRepository.existsById(id);
    }

    @Override
    public DieselDeclaration findById(Long id) throws IdNotFound {
        return DieselDeclarationMapper.toDto(dieselDeclarationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<DieselDeclaration> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DieselDeclarationMapper.toDtos(dieselDeclarationRepository.findAll(Search.expression(search, GmoDieselDeclaration.class)), false);
    }

    @Override
    public List<DieselDeclaration> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DieselDeclarationMapper.toDtos(dieselDeclarationRepository.findAll(Search.expression(search, GmoDieselDeclaration.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return dieselDeclarationRepository.count(Search.expression(search, GmoDieselDeclaration.class));
    }

    @Override
    public void delete(Long id) {
        dieselDeclarationRepository.deleteById(id);
    }

    @Override
    public void delete(DieselDeclaration dieselDeclaration) {
        dieselDeclarationRepository.delete(DieselDeclarationMapper.toEntity(dieselDeclaration, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            dieselDeclarationRepository.deleteById(id);        }
    }


    @Override
    public List<DieselDeclaration> findAll() {
        return DieselDeclarationMapper.toDtos(dieselDeclarationRepository.findAll(), false);
    }

    @Override
    public List<DieselDeclaration> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DieselDeclarationMapper.toDtos(dieselDeclarationRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value=settingService.generateCodedieselDeclaration() + dieselDeclarationRepository.getNextVal().get(0);
        return value;
    }

}

