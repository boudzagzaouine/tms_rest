package com.bagile.gmo.services;

import com.bagile.gmo.dto.AlimentationPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface AlimentationPumpService {
    AlimentationPump save(AlimentationPump alimentationPump);

    Long size();

    Boolean isExist(Long id);

    AlimentationPump findById(Long id) throws IdNotFound;

    List<AlimentationPump> find(String search) throws AttributesNotFound, ErrorType;

    List<AlimentationPump> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AlimentationPump alimentationPump);

    List<AlimentationPump> findAll();

    List<AlimentationPump> findAll(int page, int size);
}
