package com.bagile.tms.services;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BadgeService {
    Badge save(Badge badge);

    Long size();

    Boolean isExist(Long id);

    Badge findById(Long id) throws IdNotFound;

    List<Badge> find(String search) throws AttributesNotFound, ErrorType;

    List<Badge> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Badge badge);

    List<Badge> findAll();

    List<Badge> findAll(int page, int size);
}
