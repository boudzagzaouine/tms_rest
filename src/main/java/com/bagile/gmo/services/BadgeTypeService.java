package com.bagile.gmo.services;

import com.bagile.gmo.dto.BadgeType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BadgeTypeService {
    BadgeType save(BadgeType badgeType);

    Long size();

    Boolean isExist(Long id);

    BadgeType findById(Long id) throws IdNotFound;

    List<BadgeType> find(String search) throws AttributesNotFound, ErrorType;

    List<BadgeType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BadgeType badgeType);
    void deleteAll (List<Long> ids);
    List<BadgeType> findAll();

    List<BadgeType> findAll(int page, int size);
}
