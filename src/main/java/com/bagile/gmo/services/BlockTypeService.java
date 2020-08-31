package com.bagile.gmo.services;

import com.bagile.gmo.dto.BlockType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlockTypeService {

    BlockType save(BlockType blockType);

    Long size();

    Boolean isExist(Long id);

    BlockType findById(Long id) throws IdNotFound;

    BlockType findOne(String search) throws AttributesNotFound, ErrorType;

    List<BlockType> find(String search) throws AttributesNotFound, ErrorType;

    List<BlockType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(BlockType blockType);

    List<BlockType> findAll();

    List<BlockType> findAll(Pageable pageable);
}