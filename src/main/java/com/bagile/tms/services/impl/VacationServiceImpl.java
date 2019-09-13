package com.bagile.tms.services.impl;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VacationMapper;
import com.bagile.tms.repositories.VacationRepository;
import com.bagile.tms.services.VacationService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class VacationServiceImpl implements VacationService {
    @Autowired
    private VacationRepository vacationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VacationService.class);

    @Override
    public Vacation save(Vacation vacation) {
        LOGGER.info("save Vacation");

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
        Vacation Vacation = VacationMapper.toDto(vacationRepository.findById(id).get(), false);
        if (null != Vacation) {
            return Vacation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Vacation> find(String search) throws AttributesNotFound, ErrorType {
        return VacationMapper.toDtos(vacationRepository.findAll(Search.expression(search, TmsVacation.class)), false);
    }

    @Override
    public List<Vacation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VacationMapper.toDtos(vacationRepository.findAll(Search.expression(search, TmsVacation.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return vacationRepository.count(Search.expression(search, TmsVacation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Vacation");
        vacationRepository.deleteById(id);
    }

    @Override
    public void delete(Vacation Vacation) {
        LOGGER.info("delete Vehicle");
        vacationRepository.delete(VacationMapper.toEntity(Vacation, false));
    }

    @Override
    public List<Vacation> findAll() {
        return VacationMapper.toDtos(vacationRepository.findAll(), false);
    }

    @Override
    public List<Vacation> findAll(Pageable pageable) {
        return VacationMapper.toDtos(vacationRepository.findAll(pageable), false);
    }
}
