package com.bagile.gmo.services;

import com.bagile.gmo.dto.ActivityArea;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface ActivityAreaService {
    ActivityArea save(ActivityArea activityArea);

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    ActivityArea findById(Long id) throws IdNotFound;

    List<ActivityArea> find(String search) throws AttributesNotFound, ErrorType;

    List<ActivityArea> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ActivityArea activityArea);

    List<ActivityArea> findAll();

    List<ActivityArea> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    void deleteAll (List<Long> ids);


}
