package com.bagile.tms.services;

import com.bagile.tms.dto.BadgeTypeDriver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

public interface BadgeTypeDriverService {

    BadgeTypeDriver save(BadgeTypeDriver badgeTypeDriver);

    Long size();

    Boolean isExist(Long id);

    BadgeTypeDriver findById(Long id) throws IdNotFound;

    List<BadgeTypeDriver> find(String search) throws AttributesNotFound, ErrorType;

    List<BadgeTypeDriver> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    BadgeTypeDriver findOne(String search) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BadgeTypeDriver badgeTypeDriver);

    List<BadgeTypeDriver> findAll() throws AttributesNotFound, ErrorType;

    List<BadgeTypeDriver> findAll(int page, int size) throws AttributesNotFound, ErrorType;



}
