package com.bagile.tms.services;

import com.bagile.gmo.dto.InsuranceTermsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface InsuranceTermsVehicleService {

    InsuranceTermsVehicle save(InsuranceTermsVehicle insuranceTermsVehicle);

    Long size();

    Boolean isExist(Long id);

    InsuranceTermsVehicle findById(Long id) throws IdNotFound;

    List<InsuranceTermsVehicle> find(String search) throws AttributesNotFound, ErrorType;

    List<InsuranceTermsVehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    InsuranceTermsVehicle findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(InsuranceTermsVehicle insuranceTermsVehicle);

    List<InsuranceTermsVehicle> findAll() throws AttributesNotFound, ErrorType;

    List<InsuranceTermsVehicle> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
