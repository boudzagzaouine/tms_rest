package com.sinno.ems.service.impl;

import com.sinno.ems.dto.BlockType;
import com.sinno.ems.entities.PrmBlockType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BlockTypeMapper;
import com.sinno.ems.repositories.BlockTypeRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.BlockTypeService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
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
        return blockTypeRepository.exists(id);
    }

    @Override
    public BlockType findById(Long id) throws IdNotFound {
        BlockType blockType = BlockTypeMapper.toDto(blockTypeRepository.findOne(id), false);
        if (null != blockType) {
            return blockType;
        } else {
            throw new IdNotFound(id);
        }
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
        blockTypeRepository.delete(id);
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