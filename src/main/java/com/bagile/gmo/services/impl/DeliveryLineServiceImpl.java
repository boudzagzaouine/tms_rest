package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.DeliveryLine;
import com.bagile.gmo.entities.CmdDeliveryLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DeliveryLineMapper;
import com.bagile.gmo.repositories.DeliveryLineRepository;
import com.bagile.gmo.services.DeliveryLineService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
public class DeliveryLineServiceImpl implements DeliveryLineService {
    private final DeliveryLineRepository deliveryLineRepository;
    public DeliveryLineServiceImpl(DeliveryLineRepository deliveryLineRepository) {
        this.deliveryLineRepository = deliveryLineRepository;
    }

    @Override
    public DeliveryLine save(DeliveryLine deliveryLine) {
        return DeliveryLineMapper.toDto(deliveryLineRepository.saveAndFlush(DeliveryLineMapper.toEntity(deliveryLine, false)), false);
    }

    @Override
    public Long size() {
        return deliveryLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return deliveryLineRepository.existsById(id);
    }

    @Override
    public DeliveryLine findById(Long id) throws IdNotFound {
        return DeliveryLineMapper.toDto(deliveryLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<DeliveryLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class)), false);
    }

    @Override
    public List<DeliveryLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return deliveryLineRepository.count(Search.expression(search, CmdDeliveryLine.class));
    }

    @Override
    public void delete(Long id) {
        deliveryLineRepository.deleteById(id);
    }

    @Override
    public void delete(DeliveryLine deliveryLine) {
        deliveryLineRepository.delete(DeliveryLineMapper.toEntity(deliveryLine, false));
    }

    @Override
    public List<DeliveryLine> findAll() {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(), false);
    }


    @Override
    public void updateDeliveryLine(DeliveryLine deliveryLine, BigDecimal quantiyServed) {

    }

    @Override
    public void cancel(DeliveryLine deliveryLine) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {

    }

    @Override
    public List<DeliveryLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(pageable), false);
    }

}

