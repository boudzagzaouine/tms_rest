package com.sinno.ems.service;

import com.sinno.ems.dto.AssetAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 16/12/2016.
 */
public interface AssetAccountService {

    AssetAccount save(AssetAccount aisle);

    Long size();

    Boolean isExist(Long id);

    AssetAccount findById(Long id) throws IdNotFound;

    List<AssetAccount> find(String search) throws AttributesNotFound, ErrorType;

    List<AssetAccount> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AssetAccount aisle);

    List<AssetAccount> findAll();

    List<AssetAccount> findAll(Pageable pageable);
}
