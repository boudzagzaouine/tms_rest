package com.bagile.tms.services;

import com.bagile.tms.dto.Acte;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

/**
 * Created by khalil on 27/03/2017.
 */
public interface ActeService {

    Acte save(Acte acte);

    Long size();

    Boolean isExist(Long id);

    Acte findById(Long id) throws IdNotFound;

    List<Acte> find(String search) throws AttributesNotFound, ErrorType;


    List<Acte> find(String search, org.springframework.data.domain.Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Acte acte);

    List<Acte> findAll();


    List<Acte> findAll(org.springframework.data.domain.Pageable pageable);

    /**
     * Created by bouzi on 4/26/2017.
     */
    interface DriverBadgeService {
    }
}
