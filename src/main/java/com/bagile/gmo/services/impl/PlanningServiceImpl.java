package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Planning;
import com.bagile.gmo.entities.TmsPlanning;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PlanningMapper;
import com.bagile.gmo.repositories.PlanningRepository;
import com.bagile.gmo.services.PlanningService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanningServiceImpl implements PlanningService {

    private final PlanningRepository planningRepository;

    public PlanningServiceImpl(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }

    @Override
    public Planning save(Planning planning) {
        return PlanningMapper.toDto(planningRepository.saveAndFlush(PlanningMapper.toEntity(planning, false)), false);
    }

    @Override
    public Long size() {
        return planningRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return planningRepository.existsById(id);
    }

    @Override
    public Planning findById(Long id) throws IdNotFound {
        return PlanningMapper.toDto(planningRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Planning> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PlanningMapper.toDtos(planningRepository.findAll(Search.expression(search, TmsPlanning.class)), false);
    }

    @Override
    public List<Planning> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PlanningMapper.toDtos(planningRepository.findAll(Search.expression(search, TmsPlanning.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return planningRepository.count(Search.expression(search, TmsPlanning.class));
    }

    @Override
    public void delete(Long id) {
        planningRepository.deleteById(id);
    }

    @Override
    public void delete(Planning planning) {
        planningRepository.delete(PlanningMapper.toEntity(planning, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            planningRepository.deleteById(id);        }
    }


    @Override
    public List<Planning> findAll()
    {
        return PlanningMapper.toDtos(planningRepository.findAll(), false);
    }

    @Override
    public List<Planning> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PlanningMapper.toDtos(planningRepository.findAll(pageable), false);
    }

}

