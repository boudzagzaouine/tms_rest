package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ReceptionStock;
import com.bagile.gmo.entities.RcpReceptionStock;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ReceptionStockMapper;
import com.bagile.gmo.repositories.ReceptionStockRepository;
import com.bagile.gmo.services.ReceptionStockService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ReceptionStockServiceImpl implements ReceptionStockService {

    private final ReceptionStockRepository receptionRepository;
    public ReceptionStockServiceImpl(ReceptionStockRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    @Override
    public ReceptionStock save(ReceptionStock ReceptionStock) {
        return ReceptionStockMapper.toDto(receptionRepository.saveAndFlush(ReceptionStockMapper.toEntity(ReceptionStock, false)), false);
    }

    @Override
    public Long size() {
        return receptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionRepository.existsById(id);
    }

    @Override
    public ReceptionStock findById(Long id) throws IdNotFound {
        return ReceptionStockMapper.toDto(receptionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ReceptionStock> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ReceptionStockMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReceptionStock.class)), false);
    }

    @Override
    public List<ReceptionStock> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionStockMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReceptionStock.class), pageable), false);
    }

    @Override
    public ReceptionStock findOne(String search) throws AttributesNotFound, ErrorType {
        return ReceptionStockMapper.toDto (receptionRepository.findOne (Search.expression (search, RcpReceptionStock.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return receptionRepository.count(Search.expression(search, RcpReceptionStock.class));
    }

    @Override
    public void delete(Long id) {
        receptionRepository.deleteById(id);
    }

    @Override
    public void delete(ReceptionStock ReceptionStock) {
        receptionRepository.delete(ReceptionStockMapper.toEntity(ReceptionStock, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            receptionRepository.deleteById(id);        }
    }

    @Override
    public List<ReceptionStock> findAll() {
        return ReceptionStockMapper.toDtos(receptionRepository.findAll(), false);
    }

    @Override
    public List<ReceptionStock> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionStockMapper.toDtos(receptionRepository.findAll(pageable), false);
    }



}

