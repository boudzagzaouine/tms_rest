package com.bagile.tms.services;

import com.bagile.tms.dto.TurnLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface TurnLineService {
    TurnLine save(TurnLine turnLine);

    List<TurnLine> saveAll(List<TurnLine> turnLines);


    Long size();

    Boolean isExist(Long id);

    TurnLine findById(Long id) throws IdNotFound;

    TurnLine findOne(String search) throws AttributesNotFound, ErrorType;

    List<TurnLine> find(String search) throws AttributesNotFound, ErrorType;

    List<TurnLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TurnLine turnLine);

    List<TurnLine> findAll();

    List<TurnLine> findAll(int page, int size);

    String getNextVal();

   
}
