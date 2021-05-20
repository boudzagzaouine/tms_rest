package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.AlimentationPump;
import com.bagile.gmo.entities.GmoAlimentationPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AlimentationPumpMapper;
import com.bagile.gmo.repositories.AlimentationPumpRepository;
import com.bagile.gmo.services.AlimentationPumpService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AlimentationPumpServiceImpl implements AlimentationPumpService {

    private final AlimentationPumpRepository alimentationPumpRepository;
    public AlimentationPumpServiceImpl(AlimentationPumpRepository alimentationPumpRepository) {
        this.alimentationPumpRepository = alimentationPumpRepository;
    }

    @Override
    public AlimentationPump save(AlimentationPump alimentationPump) {
        return AlimentationPumpMapper.toDto(alimentationPumpRepository.saveAndFlush(AlimentationPumpMapper.toEntity(alimentationPump, false)), false);
    }

    @Override
    public Long size() {
        return alimentationPumpRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return alimentationPumpRepository.existsById(id);
    }

    @Override
    public AlimentationPump findById(Long id) throws IdNotFound {
        return AlimentationPumpMapper.toDto(alimentationPumpRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AlimentationPump> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(Search.expression(search, GmoAlimentationPump.class)), false);
    }

    @Override
    public List<AlimentationPump> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(Search.expression(search, GmoAlimentationPump.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return alimentationPumpRepository.count(Search.expression(search, GmoAlimentationPump.class));
    }

    @Override
    public void delete(Long id) {
        alimentationPumpRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            alimentationPumpRepository.deleteById(id);        }
    }

    @Override
    public void delete(AlimentationPump alimentationPump) {
        alimentationPumpRepository.delete(AlimentationPumpMapper.toEntity(alimentationPump, false));
    }

    @Override
    public List<AlimentationPump> findAll() {
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(), false);
    }

    @Override
    public List<AlimentationPump> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(pageable), false);
    }

}

