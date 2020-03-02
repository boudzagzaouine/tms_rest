package com.bagile.tms.services.impl;

import com.bagile.tms.dto.DeliveryLine;
import com.bagile.tms.entities.CmdDeliveryLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.DeliveryLineMapper;
import com.bagile.tms.repositories.DeliveryLineRepository;
import com.bagile.tms.services.DeliveryLineService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
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

