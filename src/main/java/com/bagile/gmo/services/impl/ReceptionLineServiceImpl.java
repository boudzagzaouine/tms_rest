package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.dto.ReceptionLine;
import com.bagile.gmo.entities.RcpReceptionLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ReceptionLineMapper;
import com.bagile.gmo.repositories.ReceptionLineRepository;
import com.bagile.gmo.services.OrderStatusService;
import com.bagile.gmo.services.ReceptionLineService;
import com.bagile.gmo.services.ReceptionService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ReceptionLineServiceImpl implements ReceptionLineService {
    @Autowired
    private  ReceptionLineRepository receptionLineRepository;
    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private OrderStatusService orderStatusService;

    public ReceptionLineServiceImpl(){
    }

    @Override
    public ReceptionLine save(ReceptionLine receptionLine) {
        return ReceptionLineMapper.toDto(receptionLineRepository.saveAndFlush(ReceptionLineMapper.toEntity(receptionLine, false)), false);
    }

    @Override
    public Long size() {
        return receptionLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionLineRepository.existsById(id);
    }

    @Override
    public ReceptionLine findById(Long id) throws IdNotFound {
        return ReceptionLineMapper.toDto(receptionLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ReceptionLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(Search.expression(search, RcpReceptionLine.class)), false);
    }

    @Override
    public List<ReceptionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(Search.expression(search, RcpReceptionLine.class), pageable), false);
    }

    @Override
    public ReceptionLine findOne(String search) throws AttributesNotFound, ErrorType {
        return ReceptionLineMapper.toDto (receptionLineRepository.findOne (Search.expression (search, RcpReceptionLine.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return receptionLineRepository.count(Search.expression(search, RcpReceptionLine.class));
    }

    @Override
    public void delete(Long id) {
        receptionLineRepository.deleteById(id);
    }

    @Override
    public void delete(ReceptionLine receptionLine) {
        receptionLineRepository.delete(ReceptionLineMapper.toEntity(receptionLine, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            receptionLineRepository.deleteById(id);        }
    }

    @Override
    public List<ReceptionLine> findAll() {
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(), false);
    }

    @Override
    public void updateReceptionLine(ReceptionLine receptionLine) {
        try {
            if (receptionLine.getQuantityReceived().compareTo(receptionLine.getQuantity()) > -1) {
                receptionLine.setOrderStatus(orderStatusService.completedStatus());
            } else if (receptionLine.getQuantityReceived().compareTo(BigDecimal.ZERO) > 0) {
                receptionLine.setOrderStatus(orderStatusService.findById(7L));
            } else return;
            Reception reception = receptionService.findById(receptionLine.getReception().getId());
           // productService.updatePurchasePrice(receptionLine.getProduct().getId(), receptionLine.getPurshasePrice(), receptionLine.getProductPack(), reception.getSupplier(), reception.getCurrency());
            save(receptionLine);
        } catch (IdNotFound idNotFound) {
           // LOGGER.error(idNotFound.getMessage(), idNotFound);
        }
    }

    @Override
    public List<ReceptionLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(pageable), false);
    }



}

