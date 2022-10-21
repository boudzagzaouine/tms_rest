package com.bagile.gmo.services;

import com.bagile.gmo.dto.PackagingType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface PackagingTypeService {
    PackagingType save(PackagingType packagingType);

    Long size();

    Boolean isExist(Long id);

    PackagingType findById(Long id) throws IdNotFound;

    List<PackagingType> find(String search) throws AttributesNotFound, ErrorType;

    List<PackagingType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(PackagingType packagingType);
    void deleteAll (List<Long> ids);

    List<PackagingType> findAll();

    List<PackagingType> findAll(int page, int size);

	PackagingType findOne(String search) throws AttributesNotFound, ErrorType;

}
