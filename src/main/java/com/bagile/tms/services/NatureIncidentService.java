package com.bagile.tms.services;

import com.bagile.tms.dto.NatureIncident;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
public interface NatureIncidentService {
    NatureIncident save(NatureIncident natureIncident);

    Long size();

    Boolean isExist(Long id);

    NatureIncident findById(Long id)throws IdNotFound;

    List<NatureIncident> find(String search)throws AttributesNotFound,ErrorType;

    List<NatureIncident>find(String search, Pageable pageable)throws AttributesNotFound,ErrorType;

    Long size(String search)throws AttributesNotFound,ErrorType;

    void delete(Long id);

    void delete(NatureIncident natureIncident);

    List<NatureIncident>findAll();

    List<NatureIncident>findAll(Pageable pageable);
}
