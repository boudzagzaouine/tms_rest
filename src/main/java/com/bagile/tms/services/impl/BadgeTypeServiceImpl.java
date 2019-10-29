package com.bagile.tms.services.impl;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.entities.TmsBadgeType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.BadgeTypeMapper;
import com.bagile.tms.repositories.BadgeTypeRepository;
import com.bagile.tms.services.BadgeTypeService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BadgeTypeServiceImpl implements BadgeTypeService {
    private final BadgeTypeRepository badgeTypeRepository;

    public BadgeTypeServiceImpl(BadgeTypeRepository badgeTypeRepository) {
        this.badgeTypeRepository = badgeTypeRepository;
    }

    @Override
    public BadgeType save(BadgeType badgeType) {
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
        return BadgeTypeMapper.toDto(badgeTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<BadgeType> find(String search) throws AttributesNotFound, ErrorType {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, TmsBadgeType.class)), false);
    }

    @Override
    public List<BadgeType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "prmBadgeTypeUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, TmsBadgeType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return badgeTypeRepository.count(Search.expression(search, TmsBadgeType.class));
    }

    @Override
    public void delete(Long id) {
        badgeTypeRepository.deleteById(id);
    }

    @Override
    public void delete(BadgeType badgeType) {
        badgeTypeRepository.delete(BadgeTypeMapper.toEntity(badgeType, false));
    }

    @Override
    public List<BadgeType> findAll() {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(), false);
    }

    @Override
    public List<BadgeType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "prmBadgeTypeUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(pageable), false);
    }

}

