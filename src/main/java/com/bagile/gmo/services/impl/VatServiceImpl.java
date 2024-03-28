package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Vat;
import com.bagile.gmo.entities.PrmVat;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VatMapper;
import com.bagile.gmo.repositories.VatRepository;
import com.bagile.gmo.services.VatService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class VatServiceImpl implements VatService {
    private final VatRepository vatRepository;
    public VatServiceImpl(VatRepository vatRepository) {
        this.vatRepository = vatRepository;
    }

    @Override
    public Vat save(Vat vat) {
        return VatMapper.toDto(vatRepository.saveAndFlush(VatMapper.toEntity(vat, false)), false);
    }

    @Override
    public Long size() {
        return vatRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vatRepository.existsById(id);
    }

    @Override
    public Vat findById(Long id) throws IdNotFound {
        return VatMapper.toDto(vatRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Vat> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VatMapper.toDtos(vatRepository.findAll(Search.expression(search, PrmVat.class)), false);
    }

    @Override
    public List<Vat> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VatMapper.toDtos(vatRepository.findAll(Search.expression(search, PrmVat.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vatRepository.count(Search.expression(search, PrmVat.class));
    }

    @Override
    public void delete(Long id) {
        vatRepository.deleteById(id);
    }

    @Override
    public void delete(Vat vat) {
        vatRepository.delete(VatMapper.toEntity(vat, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vatRepository.deleteById(id);        }
    }
    @Override
    public List<Vat> findAll() {
        return VatMapper.toDtos(vatRepository.findAll(), false);
    }

    @Override
    public List<Vat> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return VatMapper.toDtos(vatRepository.findAll(pageable), false);
    }

}

