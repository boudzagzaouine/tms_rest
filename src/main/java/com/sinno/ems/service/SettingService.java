package com.sinno.ems.service;

import com.sinno.ems.dto.Setting;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 08/06/2016.
 */
public interface SettingService {
    public Setting save(Setting setting);

    public Long size();

    public Boolean isExist(Long id);

    public Setting findById(Long id) throws IdNotFound;

    public List<Setting> find(String search) throws AttributesNotFound, ErrorType;

    public List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Setting setting);

    public List<Setting> findAll();

    public List<Setting> findAll(int page, int size);
}
