package com.bagile.gmo.services;

import com.bagile.gmo.dto.AccountPricing;
import com.bagile.gmo.dto.ZoneVille;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface ZoneVilleService {
    ZoneVille save(ZoneVille zoneVille);
    List<ZoneVille> saveAll(List<ZoneVille> zoneVilles) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    ZoneVille findById(Long id) throws IdNotFound;

    List<ZoneVille> find(String search) throws AttributesNotFound, ErrorType;

    List<ZoneVille> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ZoneVille accountPricing);
    void deleteAll (List<Long> ids);

    List<ZoneVille> findAll();

    List<ZoneVille> findAll(int page, int size);

    ZoneVille findOne(String search) throws AttributesNotFound, ErrorType;

}
