package com.bagile.gmo.services;

import com.bagile.gmo.dto.Insurance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InsuranceService {

    Insurance save(Insurance insurance);

    Long size();

    Boolean isExist(Long id);

    Insurance findById(Long id) throws IdNotFound;

    List<Insurance> find(String search) throws AttributesNotFound, ErrorType;

    List<Insurance> find(String search, int page,int size) throws AttributesNotFound, ErrorType;

    Insurance findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Insurance insurance);
    void deleteAll(List<Long> ids);

    List<Insurance> findAll() throws AttributesNotFound, ErrorType;

    List<Insurance> findAll(int page, int size) throws AttributesNotFound, ErrorType;

     Insurance findByPatrimony(Long idVehicle);

    //List<Insurance> findAvailableInsurances();


}
