package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActivityArea;
import com.bagile.gmo.entities.CmdActivityArea;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActivityAreaMapper;
import com.bagile.gmo.repositories.ActivityAreaRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.ActivityAreaService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityAreaServiceImpl implements ActivityAreaService {
    private final ActivityAreaRepository activityAreaRepository;

    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ActivityAreaService.class);

    public ActivityAreaServiceImpl(ActivityAreaRepository activityAreaRepository) {
        this.activityAreaRepository = activityAreaRepository;
    }

    @Override
    public ActivityArea save(@NonNull ActivityArea activityArea) {
        LOGGER.info("save ActivityArea");
    
        return ActivityAreaMapper.toDto(activityAreaRepository.saveAndFlush(ActivityAreaMapper.toEntity(activityArea, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return activityAreaRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return activityAreaRepository.existsById(id);
    }

    @Override
    public ActivityArea findById(Long id) throws IdNotFound {
        return ActivityAreaMapper.toDto(activityAreaRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActivityArea> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActivityAreaMapper.toDtos(activityAreaRepository.findAll(Search.expression(search, CmdActivityArea.class)), false);
    }

    @Override
    public List<ActivityArea> find(String search,int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActivityAreaMapper.toDtos(activityAreaRepository.findAll(Search.expression(search, CmdActivityArea.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return activityAreaRepository.count(Search.expression(search, CmdActivityArea.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save ActivityArea");
        activityAreaRepository.deleteById(id);
    }

    @Override
    public void delete(ActivityArea activityArea) {
        LOGGER.info("delete ActivityArea");
        activityAreaRepository.delete(ActivityAreaMapper.toEntity(activityArea, false));
    }

    @Override
    public List<ActivityArea> findAll() {

        return ActivityAreaMapper.toDtos(activityAreaRepository.findAll(), false);
    }

    @Override
    public List<ActivityArea> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActivityAreaMapper.toDtos(activityAreaRepository.findAll( pageable), false);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            activityAreaRepository.deleteById(id);        }
    }



}

