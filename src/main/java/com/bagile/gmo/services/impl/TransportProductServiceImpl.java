package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportProduct;
import com.bagile.gmo.entities.TmsTransportProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportProductMapper;
import com.bagile.gmo.repositories.TransportProductRepository;
import com.bagile.gmo.services.TransportProductService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportProductServiceImpl implements TransportProductService {

    private final TransportProductRepository transportProductRepository;

    public TransportProductServiceImpl(TransportProductRepository transportProductRepository) {
        this.transportProductRepository = transportProductRepository;
    }

    @Override
    public TransportProduct save(TransportProduct transportProduct) {
        return TransportProductMapper.toDto(transportProductRepository.saveAndFlush(TransportProductMapper.toEntity(transportProduct, false)), false);
    }

    @Override
    public Long size() {
        return transportProductRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportProductRepository.existsById(id);
    }

    @Override
    public TransportProduct findById(Long id) throws IdNotFound {
        return TransportProductMapper.toDto(transportProductRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportProduct> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportProductMapper.toDtos(transportProductRepository.findAll(Search.expression(search, TmsTransportProduct.class)), false);
    }

    @Override
    public List<TransportProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportProductMapper.toDtos(transportProductRepository.findAll(Search.expression(search, TmsTransportProduct.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportProductRepository.count(Search.expression(search, TmsTransportProduct.class));
    }

    @Override
    public void delete(Long id) {
        transportProductRepository.deleteById(id);
    }

    @Override
    public void delete(TransportProduct transportProduct) {
        transportProductRepository.delete(TransportProductMapper.toEntity(transportProduct, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportProductRepository.deleteById(id);        }
    }


    @Override
    public List<TransportProduct> findAll()
    {
        return TransportProductMapper.toDtos(transportProductRepository.findAll(), false);
    }

    @Override
    public List<TransportProduct> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportProductMapper.toDtos(transportProductRepository.findAll(pageable), false);
    }

}

