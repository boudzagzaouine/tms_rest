package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.entities.GmoPatrimony;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PatrimonyMapper;
import com.bagile.gmo.repositories.PatrimonyRepository;
import com.bagile.gmo.services.PatrimonyService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatrimonyServiceImpl implements PatrimonyService {

    private final PatrimonyRepository patrimonyRepository;

    public PatrimonyServiceImpl(PatrimonyRepository patrimonyRepository) {
        this.patrimonyRepository = patrimonyRepository;
    }

    @Override
    public Patrimony save(Patrimony patrimony) {
        return PatrimonyMapper.toDto
                (patrimonyRepository.saveAndFlush(PatrimonyMapper.toEntity(patrimony, false)), false);
    }

    @Override
    public Long size() {
        return patrimonyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return patrimonyRepository.existsById(id);
    }

    @Override
    public Patrimony findById(Long id) throws IdNotFound {
        return PatrimonyMapper.toDto(patrimonyRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Patrimony> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PatrimonyMapper.toDtos(patrimonyRepository.findAll(Search.expression(search, GmoPatrimony.class)), false);

    }

    @Override
    public List<Patrimony> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return PatrimonyMapper.toDtos(patrimonyRepository.findAll(Search.expression(search, GmoPatrimony.class), pageable), false);

    }


    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return patrimonyRepository.count(Search.expression(search, GmoPatrimony.class));
    }

    @Override
    public void delete(Long id) {
        patrimonyRepository.deleteById(id);
    }

    @Override
    public void delete(Patrimony patrimony) {
        patrimonyRepository.delete(PatrimonyMapper.toEntity(patrimony, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            patrimonyRepository.deleteById(id);        }
    }

    @Override
    public List<Patrimony> findAll() {

        return PatrimonyMapper.toDtos(patrimonyRepository.findAll(), false);

    }

    @Override
    public List<Patrimony> findAll(int page, int size) {
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);

        return PatrimonyMapper.toDtos(patrimonyRepository.findAll(pageable), false);    }

}
