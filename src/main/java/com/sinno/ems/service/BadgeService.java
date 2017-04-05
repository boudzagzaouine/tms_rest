package com.sinno.ems.service;

import com.sinno.ems.dto.Badge;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 03/04/2017.
 */
public interface BadgeService {
    Badge save(Badge badge);

    Long size();

    Boolean isExist(Long id);

    Badge findById(Long id) throws IdNotFound;

    List<Badge> find(String search) throws AttributesNotFound, ErrorType;

    List<Badge> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Badge badge);

    List<Badge> findAll();

    List<Badge> findAll(Pageable pageable);
}
