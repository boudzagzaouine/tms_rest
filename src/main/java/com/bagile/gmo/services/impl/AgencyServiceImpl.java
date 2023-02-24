package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Agency;
import com.bagile.gmo.entities.UsrAgency;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AgencyMapper;
import com.bagile.gmo.repositories.AgencyRepository;
import com.bagile.gmo.services.AgencyService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public Agency save(Agency agency) {
        return AgencyMapper.toDto(agencyRepository.saveAndFlush(AgencyMapper.toEntity(agency, false)), false);
    }

    @Override
    public Long size() {
        return agencyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return agencyRepository.existsById(id);
    }

    @Override
    public Agency findById(Long id) throws IdNotFound {
        return AgencyMapper.toDto(agencyRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Agency> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AgencyMapper.toDtos(agencyRepository.findAll(Search.expression(search, UsrAgency.class)), false);
    }

    @Override
    public List<Agency> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AgencyMapper.toDtos(agencyRepository.findAll(Search.expression(search, UsrAgency.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return agencyRepository.count(Search.expression(search, UsrAgency.class));
    }

    @Override
    public void delete(Long id) {
        agencyRepository.deleteById(id);
    }

    @Override
    public void delete(Agency agency) {
        agencyRepository.delete(AgencyMapper.toEntity(agency, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            agencyRepository.deleteById(id);        }
    }


    @Override
    public List<Agency> findAll()
    {
        return AgencyMapper.toDtos(agencyRepository.findAll(), false);
    }

    @Override
    public List<Agency> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AgencyMapper.toDtos(agencyRepository.findAll(pageable), false);
    }

}

