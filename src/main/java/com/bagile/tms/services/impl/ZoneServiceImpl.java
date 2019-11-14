package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Zone;
import com.bagile.tms.entities.TmsZone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ZoneMapper;
import com.bagile.tms.repositories.ZoneRepository;
import com.bagile.tms.services.VehicleService;
import com.bagile.tms.services.ZoneService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneServiceImpl implements ZoneService {
    private final ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public Zone save(Zone zone) {
        return ZoneMapper.toDto(zoneRepository.save(ZoneMapper.toEntity(zone, false)), false);
    }

    @Override
    public Long size() {
        return zoneRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return zoneRepository.existsById(id);
    }

    @Override
    public Zone findById(Long id) throws IdNotFound {
       return ZoneMapper.toDto(zoneRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Zone> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, TmsZone.class)), false);
    }

    @Override
    public List<Zone> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, TmsZone.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return zoneRepository.count(Search.expression(search, TmsZone.class));
    }

    @Override
    public void delete(Long id) {
        zoneRepository.deleteById(id);
    }

    @Override
    public void delete(Zone zone) {
        delete(zone.getId());
    }

    @Override
    public List<Zone> findAll() {
        return ZoneMapper.toDtos(zoneRepository.findAll(), false);
    }

    @Override
    public List<Zone> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return ZoneMapper.toDtos(zoneRepository.findAll(pageable), false);
    }
}
