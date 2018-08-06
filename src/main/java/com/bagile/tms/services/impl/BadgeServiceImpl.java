package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.entities.TmsBadge;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.BadgeMapper;
import com.bagile.tms.repositories.BadgeRepository;
import com.bagile.tms.services.BadgeService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return badgeRepository.existsById(id);
    }
    @Override
    public Badge findById(Long id) throws IdNotFound {
        Badge badge = BadgeMapper.toDto(badgeRepository.findById(id).get(), false);
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
        badgeRepository.deleteById(id);
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

