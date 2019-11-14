package com.bagile.tms.services.impl;

import com.bagile.tms.dto.VacationType;
import com.bagile.tms.entities.TmsVacationType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VacationTypeMapper;
import com.bagile.tms.repositories.VacationTypeRepository;
import com.bagile.tms.services.VacationTypeService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VacationTypeServiceImpl implements VacationTypeService {

    private final VacationTypeRepository vacationtyperepository;

    public VacationTypeServiceImpl(VacationTypeRepository vacationtyperepository) {
        this.vacationtyperepository = vacationtyperepository;
    }


    @Override
    public VacationType save(VacationType vacationtype) {
        return VacationTypeMapper.toDto(vacationtyperepository.saveAndFlush(VacationTypeMapper.toEntity(vacationtype, false)), false);
    }

    @Override
    public Long size() {
        return vacationtyperepository.count();

    }

    @Override
    public Boolean isExist(Long id) {
        return vacationtyperepository.existsById(id);
    }

    @Override
    public VacationType findById(Long id) throws IdNotFound {
        return VacationTypeMapper.toDto(vacationtyperepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<VacationType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll ();
        }
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, TmsVacationType.class)), false);

    }

    @Override
    public List<VacationType> find(String search, int page,int size) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, TmsVacationType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return size ();
        }
        return vacationtyperepository.count(Search.expression(search, TmsVacationType.class));

    }

    @Override
    public void delete(Long id) {
        vacationtyperepository.deleteById(id);
    }

    @Override
    public void delete(VacationType badge) {
        vacationtyperepository.delete(VacationTypeMapper.toEntity(badge, false));
    }

    @Override
    public List<VacationType> findAll() {
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(), false);
    }

    @Override
    public List<VacationType> findAll(int page,int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(pageable), false);

    }
}
