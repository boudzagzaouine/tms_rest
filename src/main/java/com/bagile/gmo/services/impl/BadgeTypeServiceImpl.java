package com.bagile.tms.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.BadgeType;
import com.bagile.gmo.entities.GmoBadgeType;
import com.bagile.gmo.mapper.BadgeTypeMapper;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.BadgeTypeRepository;
import com.bagile.tms.services.BadgeTypeService;
import com.bagile.tms.util.Search;


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
        if (search.equals("")){
            return findAll ();
        }
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoBadgeType.class)), false);
    }

    @Override
    public List<BadgeType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoBadgeType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return badgeTypeRepository.count(Search.expression(search, GmoBadgeType.class));
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
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            badgeTypeRepository.deleteById(id);        }
    }


    @Override
    public List<BadgeType> findAll() {
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(), false);
    }

    @Override
    public List<BadgeType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeMapper.toDtos(badgeTypeRepository.findAll(pageable), false);
    }

}

