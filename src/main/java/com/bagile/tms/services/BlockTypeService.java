package com.bagile.tms.services;

import com.bagile.tms.dto.BlockType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlockTypeService {

    public BlockType save(BlockType blockType);

    public Long size();

    public Boolean isExist(Long id);

    public BlockType findById(Long id) throws IdNotFound;

    public List<BlockType> find(String search) throws AttributesNotFound, ErrorType;

    public List<BlockType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(BlockType blockType);

    public List<BlockType> findAll();

    public List<BlockType> findAll(Pageable pageable);
}