package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.FuelPump;
import com.bagile.gmo.dto.Location;
import com.bagile.gmo.entities.GmoFuelPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.FuelPumpMapper;
import com.bagile.gmo.repositories.FuelPumpRepository;
import com.bagile.gmo.services.FuelPumpService;
import com.bagile.gmo.services.LocationService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class FuelPumpServiceImpl implements FuelPumpService {

    @Autowired
    private LocationService locationService;

    private final FuelPumpRepository fuelPumpRepository;
    public FuelPumpServiceImpl(FuelPumpRepository fuelPumpRepository) {
        this.fuelPumpRepository = fuelPumpRepository;
    }

    @Override
    public FuelPump save(FuelPump fuelPump) throws IdNotFound {

        Location location = locationService.findById(20000L);
        fuelPump.setLocation(location);

        return FuelPumpMapper.toDto(fuelPumpRepository.saveAndFlush(FuelPumpMapper.toEntity(fuelPump, false)), false);
    }

    @Override
    public Long size() {
        return fuelPumpRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return fuelPumpRepository.existsById(id);
    }

    @Override
    public FuelPump findById(Long id) throws IdNotFound {
        return FuelPumpMapper.toDto(fuelPumpRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<FuelPump> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return FuelPumpMapper.toDtos(fuelPumpRepository.findAll(Search.expression(search, GmoFuelPump.class)), false);
    }

    @Override
    public List<FuelPump> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return FuelPumpMapper.toDtos(fuelPumpRepository.findAll(Search.expression(search, GmoFuelPump.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return fuelPumpRepository.count(Search.expression(search, GmoFuelPump.class));
    }

    @Override
    public void delete(Long id) {
        fuelPumpRepository.deleteById(id);
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            fuelPumpRepository.deleteById(id);        }
    }
    @Override
    public void delete(FuelPump fuelPump) {
        fuelPumpRepository.delete(FuelPumpMapper.toEntity(fuelPump, false));
    }

    @Override
    public List<FuelPump> findAll() {
        return FuelPumpMapper.toDtos(fuelPumpRepository.findAll(), false);
    }

    @Override
    public List<FuelPump> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return FuelPumpMapper.toDtos(fuelPumpRepository.findAll(pageable), false);
    }

}

