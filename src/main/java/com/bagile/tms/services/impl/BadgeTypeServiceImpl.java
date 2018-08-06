package com.bagile.tms.services.impl;
import com.bagile.tms.dto.Badge;
import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.entities.TmsBadge;
import com.bagile.tms.entities.TmsBadgeType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.BadgeMapper;
import com.bagile.tms.mapper.BadgeTypeMapper;
import com.bagile.tms.repositories.BadgeRepository;
import com.bagile.tms.repositories.BadgeTypeRepository;
import com.bagile.tms.services.BadgeService;
import com.bagile.tms.services.BadgeTypeService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BadgeTypeServiceImpl implements BadgeTypeService {

    @Autowired
    private BadgeTypeRepository badgeTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BadgeTypeService.class);
    @Override
    public BadgeType save(BadgeType badgeType) {
        LOGGER.info("save BadgeType");


        return BadgeTypeMapper.toDto(badgeTypeRepository.saveAndFlush(BadgeTypeMapper.toEntity(badgeType, false)), false);
    }

    @Override
    public Long size() {
        return badgeTypeRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return badgeTypeRepository.existsById(id);
    }
    @Override
    public BadgeType findById(Long id) throws IdNotFound {
        BadgeType badgeType = BadgeTypeMapper.toDto(badgeTypeRepository.findById(id).get(), false);
        if (null != badgeType) {
            return badgeType;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<BadgeType> find(String search) throws AttributesNotFound, ErrorType {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, TmsBadgeType.class)), false);
    }
    @Override
    public List<BadgeType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, TmsBadgeType.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return badgeTypeRepository.count(Search.expression(search, TmsBadgeType.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save BadgeType");
        badgeTypeRepository.deleteById(id);
    }
    @Override
    public void delete(BadgeType badgeType) {
        LOGGER.info("delete BadgeType");
        badgeTypeRepository.delete(BadgeTypeMapper.toEntity(badgeType, false));
    }
    @Override
    public List<BadgeType> findAll() {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(), false);
    }
    @Override
    public List<BadgeType> findAll(Pageable pageable) {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(pageable), false);
    }


}
