package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.VacationType;
import com.bagile.gmo.entities.GmoVacationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VacationTypeMapper;
import com.bagile.gmo.repositories.VacationTypeRepository;
import com.bagile.gmo.services.VacationTypeService;
import com.bagile.gmo.util.Search;
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
        if (search.equals("")){
            return findAll ();
        }
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, GmoVacationType.class)), false);

    }

    @Override
    public List<VacationType> find(String search, int page,int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size,sort);
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, GmoVacationType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vacationtyperepository.count(Search.expression(search, GmoVacationType.class));

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
