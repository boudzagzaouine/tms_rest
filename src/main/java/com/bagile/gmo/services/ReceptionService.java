package com.bagile.gmo.services;


import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.exceptions.*;

import java.util.List;

public interface ReceptionService {

    Reception save(Reception reception) throws ContainerException, ProductControls, AttributesNotFound, ErrorType, IdNotFound, CustomException;

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    Reception findById(Long id) throws IdNotFound;

    List<Reception> find(String search) throws AttributesNotFound, ErrorType;

    List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Reception findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Reception badgeTypeDriver);
    void deleteAll (List<Long> ids);
    List<Reception> findAll() throws AttributesNotFound, ErrorType;
    void updateReception(Reception purshaseOrder);

    List<Reception> findAll(int page, int size) throws AttributesNotFound, ErrorType;
     void changeStatusToOnProgress(Reception reception) throws IdNotFound;

    void calculateAllLines(Reception selectedReception);

    String getNextVal();
}