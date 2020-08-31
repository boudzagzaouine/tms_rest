package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Setting;
import com.bagile.gmo.entities.GmoInsuranceType;
import com.bagile.gmo.entities.PrmSetting;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SettingMapper;
import com.bagile.gmo.repositories.SettingRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.Search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 08/06/2016.
 */
@Service
public class SettingServiceImpl implements SettingService {
    @Autowired
    private SettingRepository settingRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SettingService.class);

    @Override
    public Setting save(Setting setting) {
        LOGGER.info("save Setting");
        return SettingMapper.toDto(settingRepository.saveAndFlush(SettingMapper.toEntity(setting, false)), false);
    }

    @Override
    public Long size() {
        return settingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return settingRepository.existsById(id);
    }

    @Override
    public Setting findById(Long id) throws IdNotFound {
        return SettingMapper.toDto(settingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public Setting findOne(String search) throws AttributesNotFound, ErrorType {
        return SettingMapper.toDto(settingRepository.findOne (Search.expression (search, PrmSetting.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public List<Setting> find(String search) throws AttributesNotFound, ErrorType {
        return SettingMapper.toDtos(settingRepository.findAll(Search.expression(search, PrmSetting.class)), false);
    }

    @Override
    public List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);

        return SettingMapper.toDtos(settingRepository.findAll(Search.expression(search, PrmSetting.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return settingRepository.count(Search.expression(search, PrmSetting.class));

    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Setting");
        settingRepository.deleteById(id);
    }

    @Override
    public void delete(Setting setting) {
        LOGGER.info("delete Setting");
        settingRepository.delete(SettingMapper.toEntity(setting, false));


    }

    @Override
    public List<Setting> findAll() {
        return SettingMapper.toDtos(settingRepository.findAll(), false);
    }

    @Override
    public List<Setting> findAll(int page, int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return SettingMapper.toDtos(settingRepository.findAll(pageable), false);
    }
}
