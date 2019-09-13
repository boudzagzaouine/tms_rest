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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class VacationTypeServiceImpl implements VacationTypeService {

    private VacationTypeRepository  vacationtyperepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VacationTypeService.class);


    @Override
    public VacationType save(VacationType vacationtype) {
        LOGGER.info("save VacationtypeServiceImpl");


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
        VacationType vacationtype = VacationTypeMapper.toDto(vacationtyperepository.findById(id).get(), false);
        if (null != vacationtype) {
            return vacationtype;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<VacationType> find(String search) throws AttributesNotFound, ErrorType {
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, TmsVacationType.class)), false);

    }

    @Override
    public List<VacationType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(Search.expression(search, TmsVacationType.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vacationtyperepository.count(Search.expression(search, TmsVacationType.class));

    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Vacation Type");
        vacationtyperepository.deleteById(id);
    }

    @Override
    public void delete(VacationType badge) {
        LOGGER.info("delete Vacation Type");
        vacationtyperepository.delete(VacationTypeMapper.toEntity(badge, false));
    }

    @Override
    public List<VacationType> findAll() {
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(), false);
    }

    @Override
    public List<VacationType> findAll(Pageable pageable) {
        return VacationTypeMapper.toDtos(vacationtyperepository.findAll(pageable), false);

    }
}
