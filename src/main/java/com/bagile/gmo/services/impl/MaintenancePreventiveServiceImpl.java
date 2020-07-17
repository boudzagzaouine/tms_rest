package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.MaintenancePreventive;
import com.bagile.gmo.entities.GmoMaintenancePreventive;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenancePreventiveMapper;
import com.bagile.gmo.repositories.MaintenancePreventiveRepository;
import com.bagile.gmo.services.MaintenancePreventiveService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MaintenancePreventiveServiceImpl implements MaintenancePreventiveService {

    private final MaintenancePreventiveRepository maintenancePreventiveRepository;
    public MaintenancePreventiveServiceImpl(MaintenancePreventiveRepository maintenancePreventiveRepository) {
        this.maintenancePreventiveRepository = maintenancePreventiveRepository;
    }

    @Override
    public MaintenancePreventive save(MaintenancePreventive maintenancePreventive) {
        return MaintenancePreventiveMapper.toDto(maintenancePreventiveRepository.save(MaintenancePreventiveMapper.toEntity(maintenancePreventive, false)), false);
    }

    @Override
    public List<MaintenancePreventive> saveAll(List<MaintenancePreventive> maintenancePreventives) {

        List<MaintenancePreventive> MaintenancePreventiveList = new ArrayList<>( );
        for (MaintenancePreventive action : maintenancePreventives) {
            MaintenancePreventiveList.add (save (action));
        }
        return MaintenancePreventiveList;
    }

    @Override
    public Long size() {
        return maintenancePreventiveRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenancePreventiveRepository.existsById(id);
    }

    @Override
    public MaintenancePreventive findById(Long id) throws IdNotFound {
        return MaintenancePreventiveMapper.toDto(maintenancePreventiveRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenancePreventive> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenancePreventiveMapper.toDtos(maintenancePreventiveRepository.findAll(Search.expression(search, GmoMaintenancePreventive.class)), false);
    }

    @Override
    public List<MaintenancePreventive> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePreventiveMapper.toDtos(maintenancePreventiveRepository.findAll(Search.expression(search, GmoMaintenancePreventive.class), pageable), false);
    }

    @Override
    public MaintenancePreventive findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenancePreventiveMapper.toDto (maintenancePreventiveRepository.findOne (Search.expression (search, GmoMaintenancePreventive.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenancePreventiveRepository.count(Search.expression(search, GmoMaintenancePreventive.class));
    }

    @Override
    public void delete(Long id) {
        maintenancePreventiveRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenancePreventive maintenancePreventive) {
        maintenancePreventiveRepository.delete(MaintenancePreventiveMapper.toEntity(maintenancePreventive, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            maintenancePreventiveRepository.deleteById(id);        }
    }
    @Override
    public List<MaintenancePreventive> findAll() {
        return MaintenancePreventiveMapper.toDtos(maintenancePreventiveRepository.findAll(), false);
    }

    @Override
    public List<MaintenancePreventive> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePreventiveMapper.toDtos(maintenancePreventiveRepository.findAll(pageable), false);
    }



}

