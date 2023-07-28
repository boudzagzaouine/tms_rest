package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ZoneVille;
import com.bagile.gmo.entities.TmsZoneVille;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ZoneVilleMapper;
import com.bagile.gmo.repositories.ZoneVilleRepository;
import com.bagile.gmo.services.ZoneVilleService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneVilleServiceImpl implements ZoneVilleService {

    private  final ZoneVilleRepository zoneVilleRepository;

    public ZoneVilleServiceImpl(ZoneVilleRepository zoneVilleRepository) {
        this.zoneVilleRepository = zoneVilleRepository;
    }

    @Override
    public ZoneVille save(ZoneVille zoneVille) {
        return ZoneVilleMapper.toDto(zoneVilleRepository.saveAndFlush(ZoneVilleMapper.toEntity(zoneVille, false)), false);

    }

    @Override
    public List<ZoneVille> saveAll(List<ZoneVille> zoneVilles) throws AttributesNotFound, ErrorType {
        List<ZoneVille> zoneVilleList = new ArrayList<>();

        for (ZoneVille zoneVille : zoneVilles) {
            zoneVilleList.add(save(zoneVille));
        }

        return zoneVilleList;
    }

    @Override
    public Long size() {
        return zoneVilleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return zoneVilleRepository.existsById(id);
    }

    @Override
    public ZoneVille findById(Long id) throws IdNotFound {
        return ZoneVilleMapper.toDto(zoneVilleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }

    @Override
    public List<ZoneVille> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ZoneVilleMapper.toDtos(zoneVilleRepository.findAll(Search.expression(search, TmsZoneVille.class)), false);

    }

    @Override
    public List<ZoneVille> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ZoneVilleMapper.toDtos(zoneVilleRepository.findAll(Search.expression(search, TmsZoneVille.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return zoneVilleRepository.count(Search.expression(search, TmsZoneVille.class));

    }

    @Override
    public void delete(Long id) {
zoneVilleRepository.deleteById(id);
    }

    @Override
    public void delete(ZoneVille zoneVille) {
        zoneVilleRepository.delete(ZoneVilleMapper.toEntity(zoneVille, false));

    }

    @Override
    public void deleteAll(List<Long> ids) {
        for (Long id : ids) {
            zoneVilleRepository .deleteById(id); }
    }

    @Override
    public List<ZoneVille> findAll() {
        return ZoneVilleMapper.toDtos(zoneVilleRepository.findAll(), false);
    }

    @Override
    public List<ZoneVille> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ZoneVilleMapper.toDtos(zoneVilleRepository.findAll(pageable), false);
    }

    @Override
    public ZoneVille findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }
}
