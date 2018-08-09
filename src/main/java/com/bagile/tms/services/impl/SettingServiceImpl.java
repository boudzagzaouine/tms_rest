package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Setting;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SettingMapper;
import com.bagile.tms.repositories.SettingRepository;
import com.bagile.tms.services.SettingService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        return SettingMapper.toDto(settingRepository.findById(id).get(), false);
    }

    @Override
    public Setting findOne(String search) throws AttributesNotFound, ErrorType {
        return SettingMapper.toDto(settingRepository.findOne(Search.expression(search, Setting.class)).get(), false);
    }

    @Override
    public List<Setting> find(String search) throws AttributesNotFound, ErrorType {
        return SettingMapper.toDtos(settingRepository.findAll(Search.expression(search, Setting.class)), false);
    }

    @Override
    public List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return SettingMapper.toDtos(settingRepository.findAll(Search.expression(search, Setting.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return settingRepository.count(Search.expression(search, Setting.class));

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
        Pageable pageable = new PageRequest(page, size);
        return SettingMapper.toDtos(settingRepository.findAll(pageable), false);
    }

    @Override
    public boolean containerManagement() {
        Setting setting = null;
        try {
            setting = findById(1L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }             // id = 1

    @Override
    public boolean syncWms() {
        Setting setting = null;
        try {
            setting = findById(2L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }            // id = 2

    @Override
    public boolean warehouseManagement() {
        Setting setting = null;
        try {
            setting = findById(3L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 3

    @Override
    public boolean devisManagement() {
        Setting setting = null;
        try {
            setting = findById(4L);
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 4

    @Override
    public boolean preparationManagement() {
        Setting setting = null;
        try {
            setting = findById(5L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }          // id = 5

    @Override
    public boolean assetManagement() {
        Setting setting = null;
        try {
            setting = findById(6L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }                 // id = 6

    @Override
    public boolean litigationManagement() {
        Setting setting = null;
        try {
            setting = findById(7L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }            // id = 7

    @Override
    public boolean warrantyManagement() {
        Setting setting = null;
        try {
            setting = findById(8L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 8

    @Override
    public boolean colorManagement()                  // id = 9
    {
        Setting setting = null;
        try {
            setting = findById(9L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean lotManagement()                   // id = 10
    {
        Setting setting = null;
        try {
            setting = findById(10L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean qualityManagement()             // id = 11
    {
        Setting setting = null;
        try {
            setting = findById(11L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean serialNumberManagement()           // id = 12
    {
        Setting setting = null;
        try {
            setting = findById(12L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean dlcManagement()                    // id = 13
    {
        Setting setting = null;
        try {
            setting = findById(13L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean dluoManagement()                // id = 14
    {
        Setting setting = null;
        try {
            setting = findById(14L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean weightManagement()                  // id = 15
    {
        Setting setting = null;
        try {
            setting = findById(15L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean locationManagement()            // id = 16
    {
        Setting setting = null;
        try {
            setting = findById(16L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean dimensionManagement()              // id = 17
    {
        Setting setting = null;
        try {
            setting = findById(17L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean generateReception()              // id = 18
    {
        Setting setting = null;
        try {
            setting = findById(18L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public boolean generatePreparation()              // id = 19
    {
        Setting setting = null;
        try {
            setting = findById(19L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }

    @Override
    public String generateCodePreparation()              // id = 20
    {
        Setting setting = null;
        try {
            setting = findById(20L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeSaleOrder()              // id = 21
    {
        Setting setting = null;
        try {
            setting = findById(21L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodePurshaseOrder()              // id = 22
    {
        Setting setting = null;
        try {
            setting = findById(22L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeReception()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(23L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeDelivery()              // id = 24
    {
        Setting setting = null;
        try {
            setting = findById(24L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeProduct()              // id = 25
    {
        Setting setting = null;
        try {
            setting = findById(25L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeAccountInvoice()              // id = 26
    {
        Setting setting = null;
        try {
            setting = findById(26L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeSupplierInvoice()              // id = 27
    {
        Setting setting = null;
        try {
            setting = findById(27L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeAssetSupplier()              // id = 28
    {
        Setting setting = null;
        try {
            setting = findById(28L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeAssetAccount()              // id = 29
    {
        Setting setting = null;
        try {
            setting = findById(29L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String generateCodeDevis()              // id = 30
    {
        Setting setting = null;
        try {
            setting = findById(30L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    @Override
    public String commercialCommissionSetting()              // id = 32
    {
        Setting setting = null;
        try {
            setting = findById(32L);//1 commission based on SaleOrder -2commission based on payment 3-commission when  invoice closed
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }
}
