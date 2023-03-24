package com.bagile.gmo.services;

import com.bagile.gmo.dto.MarchandiseType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface MarchandiseTypeService {
    MarchandiseType save(MarchandiseType marchandise);

    Long size();

    Boolean isExist(Long id);

    MarchandiseType findById(Long id) throws IdNotFound;

    List<MarchandiseType> find(String search) throws AttributesNotFound, ErrorType;

    List<MarchandiseType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MarchandiseType marchandise);
    void deleteAll (List<Long> ids);

    List<MarchandiseType> findAll();

    List<MarchandiseType> findAll(int page, int size);

	MarchandiseType findOne(String search) throws AttributesNotFound, ErrorType;

}
