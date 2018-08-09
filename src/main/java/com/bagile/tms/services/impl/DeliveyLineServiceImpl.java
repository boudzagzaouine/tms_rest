package com.bagile.tms.services.impl;

import com.bagile.tms.dto.DeliveryLine;
import com.bagile.tms.entities.CmdDeliveryLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.ProductControls;
import com.bagile.tms.mapper.DeliveryLineMapper;
import com.bagile.tms.repositories.DeliveryLineRepository;
import com.bagile.tms.repositories.SettingRepository;
import com.bagile.tms.services.DeliveryLineService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Enissay on 21/04/2016.
 */
@Service
@Transactional
public class DeliveyLineServiceImpl implements DeliveryLineService {
    @Autowired
    private DeliveryLineRepository deliveryLineRepository;
    @Autowired
    private SettingRepository settingRepository;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(DeliveryLineService.class);

    @Override
    public DeliveryLine save(DeliveryLine deliveryLine) throws ProductControls {
        LOGGER.info("save DeliveryLine");
        deliveryLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= deliveryLine.getId()) {
            deliveryLine.setCreationDate(EmsDate.getDateNow());
        }
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
        DeliveryLine deliveryLine = DeliveryLineMapper.toDto(deliveryLineRepository.findById(id).get(), false);
        if (null != deliveryLine) {
            return deliveryLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<DeliveryLine> find(String search) throws AttributesNotFound, ErrorType {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class)), false);
    }

    @Override
    public List<DeliveryLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdDeliveryLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(Search.expression(search, CmdDeliveryLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return deliveryLineRepository.count(Search.expression(search, CmdDeliveryLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete DeliveryLine");
        deliveryLineRepository.deleteById(id);
    }

    @Override
    public void delete(DeliveryLine deliveryLine) {
        LOGGER.info("delete DeliveryLine");
        deliveryLineRepository.delete(DeliveryLineMapper.toEntity(deliveryLine, false));
    }

    @Override
    public List<DeliveryLine> findAll() {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(), false);
    }

    @Override
    public List<DeliveryLine> findAll(Pageable pageable) {
        return DeliveryLineMapper.toDtos(deliveryLineRepository.findAll(pageable), false);
    }

}
