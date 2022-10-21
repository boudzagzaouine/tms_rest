package com.bagile.gmo.services;

import com.bagile.gmo.dto.TurnStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TurnStatusService {
    TurnStatus save(TurnStatus turnStatus);

    Long size();

    Boolean isExist(Long id);

    TurnStatus findById(Long id) throws IdNotFound;

    List<TurnStatus> find(String search) throws AttributesNotFound, ErrorType;

    List<TurnStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TurnStatus turnStatus);
    void deleteAll (List<Long> ids);

    List<TurnStatus> findAll();

    List<TurnStatus> findAll(int page, int size);

	TurnStatus findOne(String search) throws AttributesNotFound, ErrorType;

}
