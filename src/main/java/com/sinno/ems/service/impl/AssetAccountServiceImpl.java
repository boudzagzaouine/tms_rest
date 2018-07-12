package com.sinno.ems.service.impl;

import com.sinno.ems.entities.CmdAssetAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AssetAccountMapper;
import com.sinno.ems.service.AssetAccountService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 16/12/2016.
 */
@Service
public class AssetAccountServiceImpl implements AssetAccountService{
    @Autowired
    private AssetAccountRepository aliasRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AssetAccountServiceImpl.class);
    @Override
    public AssetAccount save(AssetAccount aisle) {
        LOGGER.info("save AssetAccount");
        aisle.setUpdateDate(EmsDate.getDateNow());
        if (0 >= aisle.getId()) {
            aisle.setCreationDate(EmsDate.getDateNow());
        }
        return AssetAccountMapper.toDto(aliasRepository.saveAndFlush(AssetAccountMapper.toEntity(aisle, false)), false);
    }

    @Override
    public Long size() {
        return aliasRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return aliasRepository.exists(id);
    }

    @Override
    public AssetAccount findById(Long id) throws IdNotFound {
        AssetAccount aisle = AssetAccountMapper.toDto(aliasRepository.findOne(id), false);
        if (null != aisle) {
            return aisle;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<AssetAccount> find(String search) throws AttributesNotFound, ErrorType {
        return AssetAccountMapper.toDtos(aliasRepository.findAll(Search.expression(search, CmdAssetAccount.class)), false);
    }

    @Override
    public List<AssetAccount> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return AssetAccountMapper.toDtos(aliasRepository.findAll(Search.expression(search, CmdAssetAccount.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return aliasRepository.count(Search.expression(search, CmdAssetAccount.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete AssetAccount");
        aliasRepository.delete(id);
    }

    @Override
    public void delete(AssetAccount aisle) {
        LOGGER.info("delete AssetAccount");
        aliasRepository.delete(AssetAccountMapper.toEntity(aisle, false));
    }

    @Override
    public List<AssetAccount> findAll() {
        return AssetAccountMapper.toDtos(aliasRepository.findAll(), false);
    }

    @Override
    public List<AssetAccount> findAll(Pageable pageable) {
        return AssetAccountMapper.toDtos(aliasRepository.findAll(pageable), false);
    }
}
