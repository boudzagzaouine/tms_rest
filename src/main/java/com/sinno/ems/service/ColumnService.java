package com.sinno.ems.service;

import com.sinno.ems.dto.Column;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColumnService {

   Column save(Column column);

   Long size();

   Boolean isExist(Long id);

   Column findById(Long id) throws IdNotFound;

   List<Column> find(String search) throws AttributesNotFound, ErrorType;

   List<Column> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

   Long size(String search) throws AttributesNotFound, ErrorType;

   void delete(Long id);

   void delete(Column column);

   List<Column> findAll();

   List<Column> findAll(Pageable pageable);
}