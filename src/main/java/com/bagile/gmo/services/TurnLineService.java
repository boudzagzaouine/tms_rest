package com.bagile.gmo.services;

import com.bagile.gmo.dto.TurnLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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
