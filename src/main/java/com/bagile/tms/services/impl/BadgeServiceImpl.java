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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    private final BadgeRepository badgeRepository;
    public BadgeServiceImpl(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    public Badge save(Badge badge) {
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
        return BadgeMapper.toDto(badgeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Badge> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return BadgeMapper.toDtos(badgeRepository.findAll(Search.expression(search, TmsBadge.class)), false);
    }

    @Override
    public List<Badge> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeMapper.toDtos(badgeRepository.findAll(Search.expression(search, TmsBadge.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return badgeRepository.count(Search.expression(search, TmsBadge.class));
    }

    @Override
    public void delete(Long id) {
        badgeRepository.deleteById(id);
    }

    @Override
    public void delete(Badge badge) {
        badgeRepository.delete(BadgeMapper.toEntity(badge, false));
    }

    @Override
    public List<Badge> findAll() {
        return BadgeMapper.toDtos(badgeRepository.findAll(), false);
    }

    @Override
    public List<Badge> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BadgeMapper.toDtos(badgeRepository.findAll(pageable), false);
    }

}

