package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.BadgeTypeDriver;
import com.bagile.gmo.entities.GmoBadgeTypeDriver;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.BadgeTypeDriverMapper;
import com.bagile.gmo.repositories.BadgeTypeDriverRepository;
import com.bagile.gmo.services.BadgeTypeDriverService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BadgeTypeDriverServiceImpl implements BadgeTypeDriverService {
    
    private final BadgeTypeDriverRepository badgeTypeDriverRepository;
    public BadgeTypeDriverServiceImpl(BadgeTypeDriverRepository badgeTypeDriverRepository) {
        this.badgeTypeDriverRepository = badgeTypeDriverRepository;
    }

    @Override
    public BadgeTypeDriver save(BadgeTypeDriver badgeTypeDriver) {
        return BadgeTypeDriverMapper.toDto(badgeTypeDriverRepository.saveAndFlush(BadgeTypeDriverMapper.toEntity(badgeTypeDriver, false)), false);
    }

    @Override
    public Long size() {
        return badgeTypeDriverRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return badgeTypeDriverRepository.existsById(id);
    }

    @Override
    public BadgeTypeDriver findById(Long id) throws IdNotFound {
        return BadgeTypeDriverMapper.toDto(badgeTypeDriverRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<BadgeTypeDriver> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return BadgeTypeDriverMapper.toDtos(badgeTypeDriverRepository.findAll(Search.expression(search, GmoBadgeTypeDriver.class)), false);
    }

    @Override
    public List<BadgeTypeDriver> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeDriverMapper.toDtos(badgeTypeDriverRepository.findAll(Search.expression(search, GmoBadgeTypeDriver.class), pageable), false);
    }

    @Override
    public BadgeTypeDriver findOne(String search) throws AttributesNotFound, ErrorType {
        return BadgeTypeDriverMapper.toDto (badgeTypeDriverRepository.findOne (Search.expression (search, GmoBadgeTypeDriver.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return badgeTypeDriverRepository.count(Search.expression(search, GmoBadgeTypeDriver.class));
    }

    @Override
    public void delete(Long id) {
        badgeTypeDriverRepository.deleteById(id);
    }

    @Override
    public void delete(BadgeTypeDriver badgeTypeDriver) {
        badgeTypeDriverRepository.delete(BadgeTypeDriverMapper.toEntity(badgeTypeDriver, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            badgeTypeDriverRepository.deleteById(id);        }
    }

    @Override
    public List<BadgeTypeDriver> findAll() {
        return BadgeTypeDriverMapper.toDtos(badgeTypeDriverRepository.findAll(), false);
    }

    @Override
    public List<BadgeTypeDriver> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeTypeDriverMapper.toDtos(badgeTypeDriverRepository.findAll(pageable), false);
    }



}

