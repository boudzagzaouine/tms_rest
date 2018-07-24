package com.bagile.tms.services.impl;

import com.sinno.ems.dto.Badge;
import com.sinno.ems.entities.TmsBadge;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.BadgeMapper;
import com.sinno.ems.repositories.BadgeRepository;
import com.sinno.ems.service.BadgeService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by khalil on 03/04/2017.
 */
@Service
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(BadgeService.class);
    @Override
    public Badge save(Badge badge) {
        LOGGER.info("save Badge");


        return BadgeMapper.toDto(badgeRepository.saveAndFlush(BadgeMapper.toEntity(badge, false)), false);
    }

    @Override
    public Long size() {
        return badgeRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return badgeRepository.exists(id);
    }
    @Override
    public Badge findById(Long id) throws IdNotFound {
        Badge badge = BadgeMapper.toDto(badgeRepository.findOne(id), false);
        if (null != badge) {
            return badge;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<Badge> find(String search) throws AttributesNotFound, ErrorType {
        return BadgeMapper.toDtos(badgeRepository.findAll(Search.expression(search, TmsBadge.class)), false);
    }
    @Override
    public List<Badge> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return BadgeMapper.toDtos(badgeRepository.findAll(Search.expression(search, TmsBadge.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return badgeRepository.count(Search.expression(search, TmsBadge.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Badge");
        badgeRepository.delete(id);
    }
    @Override
    public void delete(Badge badge) {
        LOGGER.info("delete Badge");
        badgeRepository.delete(BadgeMapper.toEntity(badge, false));
    }
    @Override
    public List<Badge> findAll() {
        return BadgeMapper.toDtos(badgeRepository.findAll(), false);
    }
    @Override
    public List<Badge> findAll(Pageable pageable) {
        return BadgeMapper.toDtos(badgeRepository.findAll(pageable), false);
    }

}

