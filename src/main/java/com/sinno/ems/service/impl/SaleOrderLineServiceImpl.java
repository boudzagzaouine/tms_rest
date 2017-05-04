package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdSaleOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperSaleOrderLine;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.SaleOrderLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerCompany;
import com.sinno.wms.crud.convertbasic.ConvertManagerSaleOdrerLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Exception;
import java.util.List;

@Service
public class SaleOrderLineServiceImpl implements SaleOrderLineService {

    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UomRepository uomRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderLineService.class);

    @Override
    public SaleOrderLine save(SaleOrderLine saleOrderLine) throws ProductControls {
        LOGGER.info("save SaleOrderLine");
        saleOrderLine.setUpdateDate(EmsDate.getDateNow());
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;
        if (containerManagement) {
            Container container = ContainerMapper.toDto(containerRepository.findOne(saleOrderLine.getContainer().getId()), false);
            saleOrderLine.setLocation(container.getLocation());
        } else {
            Container container = createContainer(saleOrderLine);
            saleOrderLine.setContainer(container);
        }
        if (0 >= saleOrderLine.getId()) {
            saleOrderLine.setCreationDate(EmsDate.getDateNow());
        }

        saleOrderLine = SaleOrderLineMapper.toDto(saleOrderLineRepository.saveAndFlush(SaleOrderLineMapper.toEntity(saleOrderLine, false)), false);

        //  writeFileSaleOrderLine(saleOrderLine);
        return saleOrderLine;

    }




    @Override
    public Long size() {
        return saleOrderLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderLineRepository.exists(id);
    }

    @Override
    public SaleOrderLine findById(Long id) throws IdNotFound {
        SaleOrderLine saleOrderLine = SaleOrderLineMapper.toDto(saleOrderLineRepository.findOne(id), false);
        if (null != saleOrderLine) {
            return saleOrderLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrderLine> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class)), false);
    }

    @Override
    public List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdSaleOrderLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderLineRepository.count(Search.expression(search, CmdSaleOrderLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrderLine");
        saleOrderLineRepository.delete(id);
    }

    @Override
    public void delete(SaleOrderLine saleOrderLine) {
        LOGGER.info("delete SaleOrderLine");
        saleOrderLineRepository.delete(SaleOrderLineMapper.toEntity(saleOrderLine, false));
    }

    @Override
    public List<SaleOrderLine> findAll() {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderLine> findAll(Pageable pageable) {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(pageable), false);
    }

    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    private Container createContainer(SaleOrderLine saleOrderLine) {
        Container container = new Container();
        container.setCode(getContainerCode());
        container.setLocation(saleOrderLine.getLocation());
        container.setOwner(saleOrderLine.getOwner());
        container.setWarehouse(saleOrderLine.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    @Override
    @Transactional
    public SaleOrderLine loadWmsSaleOrderLine(com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine saleOrderLine) {
        SaleOrder emsSaleOrder = SaleOrderMapper.toDto(saleOrderRepository.findByCmdSaleOrderCode(saleOrderLine.getSorder_code()), false);
        SaleOrderLine emsSaleOrderLine = null;
        try {
            emsSaleOrderLine = SaleOrderLineMapper.toDto(saleOrderLineRepository.findOne(Search.expression("lineNumber:" + saleOrderLine.getLine() + ",saleOrder.code:" + saleOrderLine.getSorder_code(), CmdSaleOrderLine.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        if (null != emsSaleOrder) {
            Product product = ProductMapper.toDto(productRepository.findByPdtProductCode(saleOrderLine.getProduct_code()), false);
            Uom uom = UomMapper.toDto(uomRepository.findByPdtUomCode(saleOrderLine.getUom()), false);
            Container container = ContainerMapper.toDto(containerRepository.findByStkContainerCode(saleOrderLine.getContainer()), false);

            if (null == uom) {
                uom = new Uom();
                uom.setCode(saleOrderLine.getUom());
                uom.setOwner(emsSaleOrder.getOwner());
                uom = UomMapper.toDto(uomRepository.saveAndFlush(UomMapper.toEntity(uom, false)), false);
            }
            if (null == container && null != saleOrderLine.getContainer()) {
                container = new Container();
                container.setCode(saleOrderLine.getContainer());
                container.setOwner(emsSaleOrder.getOwner());
                container.setWarehouse(emsSaleOrder.getWarehouse());
                container.setUpdateDate(EmsDate.getDateNow());
                container.setCreationDate(EmsDate.getDateNow());
                container.setReceptionDate(EmsDate.getDateNow());
                container = ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
            }
            if (null == emsSaleOrderLine) {
                emsSaleOrderLine = new SaleOrderLine();
                emsSaleOrderLine.setUpdateDate(EmsDate.getDateNow());
            }
            emsSaleOrderLine = MapperSaleOrderLine.convertToEmsDto(emsSaleOrderLine, saleOrderLine);
            emsSaleOrderLine.setUpdateDate(EmsDate.getDateNow());
            emsSaleOrderLine.setContainer(container);
            emsSaleOrderLine.setSaleOrder(emsSaleOrder);
            emsSaleOrderLine.setOwner(emsSaleOrder.getOwner());
            emsSaleOrderLine.setProduct(product);
            emsSaleOrderLine.setUom(uom);
            emsSaleOrderLine.setWarehouse(emsSaleOrder.getWarehouse());
            emsSaleOrderLine = SaleOrderLineMapper.toDto(saleOrderLineRepository.saveAndFlush(SaleOrderLineMapper.toEntity(emsSaleOrderLine, false)), false);
            return emsSaleOrderLine;

        } else {
            return null;
        }
    }
}