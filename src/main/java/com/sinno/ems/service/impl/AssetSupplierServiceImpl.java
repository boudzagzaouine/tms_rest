package com.sinno.ems.service.impl;

import com.sinno.ems.dto.AssetSupplier;
import com.sinno.ems.entities.RcpAssetSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AssetSupplierMapper;
import com.sinno.ems.repositories.AssetSupplierRepository;
import com.sinno.ems.service.AssetSupplierService;
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
public class AssetSupplierServiceImpl implements AssetSupplierService{
    @Autowired
    private AssetSupplierRepository supplierAssetRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AssetSupplierServiceImpl.class);
    @Override
    public AssetSupplier save(AssetSupplier supplierAsset) {
        LOGGER.info("save AssetSupplier");
        supplierAsset.setUpdateDate(EmsDate.getDateNow());
        if (0 >= supplierAsset.getId()) {
            supplierAsset.setCreationDate(EmsDate.getDateNow());
        }
        return AssetSupplierMapper.toDto(supplierAssetRepository.saveAndFlush(AssetSupplierMapper.toEntity(supplierAsset, false)), false);
    }

    @Override
    public Long size() {
        return supplierAssetRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierAssetRepository.exists(id);
    }

    @Override
    public AssetSupplier findById(Long id) throws IdNotFound {
        AssetSupplier supplierAsset = AssetSupplierMapper.toDto(supplierAssetRepository.findOne(id), false);
        if (null != supplierAsset) {
            return supplierAsset;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<AssetSupplier> find(String search) throws AttributesNotFound, ErrorType {
        return AssetSupplierMapper.toDtos(supplierAssetRepository.findAll(Search.expression(search, RcpAssetSupplier.class)), false);
    }

    @Override
    public List<AssetSupplier> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return AssetSupplierMapper.toDtos(supplierAssetRepository.findAll(Search.expression(search, RcpAssetSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return supplierAssetRepository.count(Search.expression(search, RcpAssetSupplier.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete AssetSupplier");
        supplierAssetRepository.delete(id);
    }

    @Override
    public void delete(AssetSupplier supplierAsset) {
        LOGGER.info("delete AssetSupplier");
        supplierAssetRepository.delete(AssetSupplierMapper.toEntity(supplierAsset, false));
    }

    @Override
    public List<AssetSupplier> findAll() {
        return AssetSupplierMapper.toDtos(supplierAssetRepository.findAll(), false);
    }

    @Override
    public List<AssetSupplier> findAll(Pageable pageable) {
        return AssetSupplierMapper.toDtos(supplierAssetRepository.findAll(pageable), false);
    }
}
