package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.BlockType;
import com.bagile.gmo.entities.GmoInsuranceTypeTerms;
import com.bagile.gmo.entities.PrmBlockType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.BlockTypeMapper;
import com.bagile.gmo.repositories.BlockTypeRepository;
import com.bagile.gmo.services.BlockTypeService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockTypeServiceImpl implements BlockTypeService {

    @Autowired
    private BlockTypeRepository blockTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BlockTypeService.class);

    @Override
    public BlockType save(BlockType blockType) {
        LOGGER.info("save BlockType");
        blockType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= blockType.getId()) {
            blockType.setCreationDate(EmsDate.getDateNow());
        }
        return BlockTypeMapper.toDto(blockTypeRepository.saveAndFlush(BlockTypeMapper.toEntity(blockType, false)), false);
    }

    @Override
    public Long size() {
        return blockTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return blockTypeRepository.existsById(id);
    }

    @Override
    public BlockType findById(Long id) throws IdNotFound {
        BlockType blockType = BlockTypeMapper.toDto(blockTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != blockType) {
            return blockType;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public BlockType findOne(String search) throws AttributesNotFound, ErrorType {
        return BlockTypeMapper.toDto(blockTypeRepository.findOne(Search.expression (search, GmoInsuranceTypeTerms.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }
    @Override
    public List<BlockType> find(String search) throws AttributesNotFound, ErrorType {
        return BlockTypeMapper.toDtos(blockTypeRepository.findAll(Search.expression(search, PrmBlockType.class)), false);
    }

    @Override
    public List<BlockType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return BlockTypeMapper.toDtos(blockTypeRepository.findAll(Search.expression(search, PrmBlockType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return blockTypeRepository.count(Search.expression(search, PrmBlockType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete BlockType");
        blockTypeRepository.deleteById(id);
    }

    @Override
    public void delete(BlockType blockType) {
        LOGGER.info("dele BlockType");
        blockTypeRepository.delete(BlockTypeMapper.toEntity(blockType, false));
    }

    @Override
    public List<BlockType> findAll() {
        return BlockTypeMapper.toDtos(blockTypeRepository.findAll(), false);
    }

    @Override
    public List<BlockType> findAll(Pageable pageable) {
        return BlockTypeMapper.toDtos(blockTypeRepository.findAll(pageable), false);
    }
}