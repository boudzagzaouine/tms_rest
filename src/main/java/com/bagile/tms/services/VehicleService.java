package com.bagile.tms.services;

import com.bagile.tms.dto.Vehicule;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bouzi on 4/4/2017.
 */
public interface VehicleService {
    Vehicule save(Vehicule vehicule);

    Long size();

    Boolean isExist(Long id);

    Vehicule findById(Long id) throws IdNotFound;

    List<Vehicule> find(String search) throws AttributesNotFound, ErrorType;

    List<Vehicule> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Vehicule vehicule);

    List<Vehicule> findAll();

    List<Vehicule> findAll(Pageable pageable);
}
