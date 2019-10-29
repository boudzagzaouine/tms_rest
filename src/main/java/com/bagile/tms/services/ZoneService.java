package com.bagile.tms.services;

import com.bagile.tms.dto.Zone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {
        Zone save(Zone zone);

        Long size();

        Boolean isExist(Long id);

        Zone findById(Long id) throws IdNotFound;

        List<Zone> find(String search) throws AttributesNotFound, ErrorType;

        List<Zone> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

        Long size(String search) throws AttributesNotFound, ErrorType;

        void delete(Long id);

        void delete(Zone zone);

        List<Zone> findAll();

        List<Zone> findAll(int page, int size);
    }
