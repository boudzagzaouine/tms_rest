package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.*;
import com.sinno.ems.mapperWms.MapperReceptionLine;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.ReceptionLineService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerReceptionLine;
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
public class ReceptionLineServiceImpl implements ReceptionLineService {

    @Autowired
    private ReceptionLineRepository receptionLineRepository;
    @Autowired
    private SettingRepository settingRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UomRepository uomRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionLineService.class);

    @Override
    public ReceptionLine save(ReceptionLine receptionLine) throws ProductControls {
        LOGGER.info("save ReceptionLine");
        receptionLine = checkControls(receptionLine);
        receptionLine.setUpdateDate(EmsDate.getDateNow());
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;

        if (0 >= receptionLine.getId()) {
            receptionLine.setCreationDate(EmsDate.getDateNow());
            if (!containerManagement) {
                receptionLine.setContainerCode(receptionLine.getPurshaseOrderLine().getContainerCode());
            }
        }
      receptionLine=  ReceptionLineMapper.toDto(receptionLineRepository.saveAndFlush(ReceptionLineMapper.toEntity(receptionLine, false)), false);


     //  writeFileReceptionLine(receptionLine);
        return receptionLine;

    }

    private void writeFileReceptionLine(ReceptionLine rl){

        try {
            com.sinno.wms.crud.modelbasic.receptions.ReceptionLine receptionLine = com.sinno.ems.mapperWms.MapperReceptionLine.convertToWmsDto(rl);
            String langue="FR";
            ConvertManagerReceptionLine.writeFileReceptionLine("ReceptionLines.xls",langue, receptionLine);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ReceptionLine checkControls(ReceptionLine receptionLine) throws ProductControls {
        Product product = receptionLine.getProduct();

        if (null != product.getDlcControl()) {
            if (product.getDlcControl() && null == receptionLine.getDlc()) {
                throw new ProductControls("Dlc");
            }
        }
        if (null != product.getDluoControl()) {
            if (product.getDluoControl() && null == receptionLine.getDluo()) {
                throw new ProductControls("Dluo");
            }
        }
        if (null != product.getLotControl()) {
            if (product.getLotControl() && null == receptionLine.getLot()) {
                throw new ProductControls("Lot");
            }
        }
        if (null != product.getColorControl()) {
            if (product.getColorControl() && null == receptionLine.getColor()) {
                throw new ProductControls("Coleur");
            }
        }
        if (null != product.getSerialNoControl()) {
            if (product.getSerialNoControl() && null == receptionLine.getSerialNo()) {
                throw new ProductControls("SerialNo");
            }
        }
        if (null != product.getWeightControl()) {
            if (product.getWeightControl() && null == receptionLine.getWeight()) {
                throw new ProductControls("Poid");
            }
        }
        if (null != product.getQualityOfControl()) {
            if (product.getQualityOfControl() && null == receptionLine.getQuality()) {
                throw new ProductControls("Qualit�");
            }
        }


        return receptionLine;

    }

    @Override
    public Long size() {
        return receptionLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionLineRepository.exists(id);
    }

    @Override
    public ReceptionLine findById(Long id) throws IdNotFound {
        ReceptionLine receptionLine = ReceptionLineMapper.toDto(receptionLineRepository.findOne(id), false);
        if (null != receptionLine) {
            return receptionLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ReceptionLine> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(Search.expression(search, RcpReceptionLine.class)), false);
    }

    @Override
    public List<ReceptionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "rcpReceptionLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(Search.expression(search, RcpReceptionLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionLineRepository.count(Search.expression(search, RcpReceptionLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ReceptionLine");
        receptionLineRepository.delete(id);
    }

    @Override
    public void delete(ReceptionLine receptionLine) {
        LOGGER.info("delete ReceptionLine");
        receptionLineRepository.delete(ReceptionLineMapper.toEntity(receptionLine, false));
    }

    @Override
    public List<ReceptionLine> findAll() {
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(), false);
    }

    @Override
    public List<ReceptionLine> findAll(Pageable pageable) {
        return ReceptionLineMapper.toDtos(receptionLineRepository.findAll(pageable), false);
    }


    @Override
    @Transactional
    public ReceptionLine loadWmsReceptionLine(com.sinno.wms.crud.modelbasic.receptions.ReceptionLine receptionLine) {

        Reception emsReception = ReceptionMapper.toDto(receptionRepository.findByRcpReceptionCode(receptionLine.getReception_code()), false);
        ReceptionLine emsReceptionLine = null;
        try {
            emsReceptionLine = ReceptionLineMapper.toDto(receptionLineRepository.findOne(Search.expression("lineNumber:" + receptionLine.getLine() + ",reception.code:" + receptionLine.getReception_code(), RcpReceptionLine.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        if (null != emsReception) {
            Product product = ProductMapper.toDto(productRepository.findByPdtProductCode(receptionLine.getProduct_code()), false);
            Uom uom = UomMapper.toDto(uomRepository.findByPdtUomCode(receptionLine.getUom()), false);

            if (null == uom) {
                uom = new Uom();
                uom.setCode(receptionLine.getUom());
                uom.setOwner(emsReception.getOwner());
                uom = UomMapper.toDto(uomRepository.saveAndFlush(UomMapper.toEntity(uom, false)), false);
            }
                    if (null == emsReceptionLine) {
                emsReceptionLine = new ReceptionLine();
                emsReceptionLine.setUpdateDate(EmsDate.getDateNow());
            }
            emsReceptionLine = MapperReceptionLine.convertToEmsDto(emsReceptionLine, receptionLine);
            emsReceptionLine.setUpdateDate(EmsDate.getDateNow());
            emsReceptionLine.setReception(emsReception);
            emsReceptionLine.setOwner(emsReception.getOwner());
            emsReceptionLine.setProduct(product);
            emsReceptionLine.setUom(uom);
            emsReceptionLine.setWarehouse(emsReception.getWarehouse());
            emsReceptionLine = ReceptionLineMapper.toDto(receptionLineRepository.saveAndFlush(ReceptionLineMapper.toEntity(emsReceptionLine, false)), false);
            return emsReceptionLine;

        } else {
            return null;
        }
    }


}