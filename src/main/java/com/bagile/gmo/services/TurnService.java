package com.bagile.gmo.services;

import com.bagile.gmo.dto.Turn;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface TurnService {

    Turn save(Turn turn);

    Long size();

    Boolean isExist(Long id);

    Turn findById(Long id) throws IdNotFound;

    List<Turn> find(String search) throws AttributesNotFound, ErrorType;

    List<Turn> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Turn Turn);

    List<Turn> findAll();

    List<Turn> findAll(int page, int size);


    void archive(Long id) throws IdNotFound;
}
