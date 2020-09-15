package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Vacation;
import com.bagile.gmo.entities.GmoVacation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VacationMapper;
import com.bagile.gmo.repositories.VacationRepository;
import com.bagile.gmo.services.VacationService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class VacationServiceImpl implements VacationService {
    private final VacationRepository vacationRepository;

    public VacationServiceImpl(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public Vacation save(Vacation vacation) {

        return VacationMapper.toDto(vacationRepository.save(VacationMapper.toEntity(vacation, false)), false);
    }

    @Override
    public Long size() {
        return vacationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vacationRepository.existsById(id);
    }

    @Override
    public Vacation findById(Long id) throws IdNotFound {
        return VacationMapper.toDto(vacationRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Vacation> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VacationMapper.toDtos(vacationRepository.findAll(Search.expression(search, GmoVacation.class)), false);
    }

    @Override
    public List<Vacation> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VacationMapper.toDtos(vacationRepository.findAll(Search.expression(search, GmoVacation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vacationRepository.count(Search.expression(search, GmoVacation.class));
    }

    @Override
    public void delete(Long id) {
        vacationRepository.deleteById(id);
    }

    @Override
    public void delete(Vacation Vacation) {
        vacationRepository.delete(VacationMapper.toEntity(Vacation, false));
    }

    @Override
    public List<Vacation> findAll() {
        return VacationMapper.toDtos(vacationRepository.findAll(), false);
    }

    @Override
    public List<Vacation> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VacationMapper.toDtos(vacationRepository.findAll(pageable), false);
    }
}
