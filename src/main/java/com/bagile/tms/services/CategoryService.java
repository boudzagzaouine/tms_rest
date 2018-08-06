package com.bagile.tms.services;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.dto.Category;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    Long size();

    Boolean isExist(Long id);

    Category findById(Long id) throws IdNotFound;

    List<Category> find(String search) throws AttributesNotFound, ErrorType;

    List<Category> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Category category);

    List<Category> findAll();

    List<Category> findAll(Pageable pageable);

}
