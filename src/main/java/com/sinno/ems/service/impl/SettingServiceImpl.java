package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Setting;
import com.sinno.ems.entities.PrmSetting;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SettingMapper;
import com.sinno.ems.repositories.SettingRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.SettingService;
import com.sinno.ems.util.Search;
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
        return settingRepository.exists(id);
    }

    @Override
    public Setting findById(Long id) throws IdNotFound {
        return SettingMapper.toDto(settingRepository.findOne(id),false);
    }

    @Override
    public List<Setting> find(String search) throws AttributesNotFound, ErrorType {
        return SettingMapper.toDtos( settingRepository.findAll(Search.expression(search, PrmSetting.class)),false);
    }

    @Override
    public List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return SettingMapper.toDtos( settingRepository.findAll(Search.expression(search, PrmSetting.class),pageable),false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return settingRepository.count(Search.expression(search, PrmSetting.class));

    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Setting");
        settingRepository.delete(id);
    }

    @Override
    public void delete(Setting setting) {
        LOGGER.info("delete Setting");
        settingRepository.delete(SettingMapper.toEntity(setting,false));


    }

    @Override
    public List<Setting> findAll() {
        return SettingMapper.toDtos( settingRepository.findAll(),false);
    }

    @Override
    public List<Setting> findAll(int page, int size) {
        Pageable pageable=new PageRequest(page, size);
        return SettingMapper.toDtos( settingRepository.findAll(pageable),false);
    }
}
