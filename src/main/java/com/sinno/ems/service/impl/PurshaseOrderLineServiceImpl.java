package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Product;
import com.sinno.ems.dto.PurshaseOrderLine;
import com.sinno.ems.dto.Setting;
import com.sinno.ems.entities.RcpPurshaseOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.PurshaseOrderLineMapper;
import com.sinno.ems.mapper.SettingMapper;
import com.sinno.ems.repositories.ContainerRepository;
import com.sinno.ems.repositories.PurshaseOrderLineRepository;
import com.sinno.ems.repositories.SettingRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.PurshaseOrderLineArcService;
import com.sinno.ems.service.PurshaseOrderLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurshaseOrderLineServiceImpl implements PurshaseOrderLineService {

    @Autowired
    private PurshaseOrderLineRepository purshaseOrderLineRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private SettingRepository settingRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PurshaseOrderLineService.class);

    @Override
    public PurshaseOrderLine save(PurshaseOrderLine purshaseOrderLine) throws ProductControls {
        LOGGER.info("save PurchaseOrderLine");
        purshaseOrderLine = checkControls(purshaseOrderLine);
        purshaseOrderLine.setUpdateDate(EmsDate.getDateNow());
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;


        if (0 >= purshaseOrderLine.getId()) {
            if (!containerManagement) {
                purshaseOrderLine.setContainerCode(getContainerCode());
            }
            purshaseOrderLine.setCreationDate(EmsDate.getDateNow());
        }
        return PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.saveAndFlush(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false)), false);
    }

    private PurshaseOrderLine checkControls(PurshaseOrderLine purshaseOrderLine) throws ProductControls {
        Product product = purshaseOrderLine.getProduct();

        if (null != product.getDlcControl()) {
            if (product.getDlcControl() && null == purshaseOrderLine.getDlc()) {
                throw new ProductControls("Dlc");
            }
        }
        if (null != product.getDluoControl()) {
            if (product.getDluoControl() && null == purshaseOrderLine.getDluo()) {
                throw new ProductControls("Dluo");
            }
        }
        if (null != product.getLotControl()) {
            if (product.getLotControl() && null == purshaseOrderLine.getLot()) {
                throw new ProductControls("Lot");
            }
        }
        if (null != product.getColorControl()) {
            if (product.getColorControl() && null == purshaseOrderLine.getColor()) {
                throw new ProductControls("Coleur");
            }
        }
        if (null != product.getSerialNoControl()) {
            if (product.getSerialNoControl() && null == purshaseOrderLine.getSerialNo()) {
                throw new ProductControls("SerialNo");
            }
        }
        if (null != product.getWeightControl()) {
            if (product.getWeightControl() && null == purshaseOrderLine.getWeight()) {
                throw new ProductControls("Poid");
            }
        }
        if (null != product.getQualityOfControl()) {
            if (product.getQualityOfControl() && null == purshaseOrderLine.getQuality()) {
                throw new ProductControls("Qualité");
            }
        }

        return purshaseOrderLine;
    }

    @Override
    public Long size() {
        return purshaseOrderLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderLineRepository.exists(id);
    }

    @Override
    public PurshaseOrderLine findById(Long id) throws IdNotFound {
        PurshaseOrderLine purshaseOrderLine = PurshaseOrderLineMapper.toDto(purshaseOrderLineRepository.findOne(id), false);
        if (null != purshaseOrderLine) {
            return purshaseOrderLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PurshaseOrderLine> find(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(Search.expression(search, RcpPurshaseOrderLine.class)), false);
    }

    @Override
    public List<PurshaseOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "rcpPurshaseOrderLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(Search.expression(search, RcpPurshaseOrderLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineRepository.count(Search.expression(search, RcpPurshaseOrderLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PurchaseOrderLine");
        purshaseOrderLineRepository.delete(id);
    }

    @Override
    public void delete(PurshaseOrderLine purshaseOrderLine) {
        LOGGER.info("delete PurchaseOrderLine");
        purshaseOrderLineRepository.delete(PurshaseOrderLineMapper.toEntity(purshaseOrderLine, false));
    }

    @Override
    public List<PurshaseOrderLine> findAll() {
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrderLine> findAll(Pageable pageable) {
        return PurshaseOrderLineMapper.toDtos(purshaseOrderLineRepository.findAll(pageable), false);
    }

    private String getContainerCode() {
        return "CTN" + containerRepository.getNextVal().get(0).toString();
    }

}