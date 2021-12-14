package com.bagile.gmo.services;

import com.bagile.gmo.dto.TurnSoPo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TurnSoPoService {
    TurnSoPo save(TurnSoPo turnSoPo);
    List<TurnSoPo> saveAll(List<TurnSoPo> turnSoPo) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    TurnSoPo findById(Long id) throws IdNotFound;

    List<TurnSoPo> find(String search) throws AttributesNotFound, ErrorType;

    List<TurnSoPo> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TurnSoPo turnSoPo);
    void deleteAll(List<Long> ids);
    List<TurnSoPo> findAll();

    List<TurnSoPo> findAll(int page, int size);
}
