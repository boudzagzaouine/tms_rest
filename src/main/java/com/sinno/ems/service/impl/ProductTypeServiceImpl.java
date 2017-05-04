package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Owner;
import com.sinno.ems.dto.ProductType;
import com.sinno.ems.entities.OwnOwner;
import com.sinno.ems.entities.PdtProductType;
import com.sinno.ems.entities.PrmMsgSend;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.OwnerMapper;
import com.sinno.ems.mapper.ProductTypeMapper;
import com.sinno.ems.mapperWms.MapperProductType;
import com.sinno.ems.repositories.MsgSendRepository;
import com.sinno.ems.repositories.OwnerRepository;
import com.sinno.ems.repositories.ProductTypeRepository;
import com.sinno.ems.repositories.SettingRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.ProductTypeService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import com.sinno.wms.crud.convertbasic.ConvertManagerProductType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private MsgSendRepository msgSendRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ProductTypeService.class);
    @Autowired
    private SettingRepository settingRepository;

    @Override
    public ProductType save(ProductType productType) {
        LOGGER.info("save ProductType");
        PrmMsgSend msgSend = getPrmMsgSend();
        productType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= productType.getId()) {
            productType.setCreationDate(EmsDate.getDateNow());
        }
        productType = ProductTypeMapper.toDto(productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false)), false);

        boolean syncWms = settingRepository.findOne(2L).getPrmSettingValue().equals("1") ? true : false;
        if (syncWms) {
            if (null != msgSend && msgSend.isPrmMsgSendActive() && "xls".equals(msgSend.getPrmMsgSendFormat().trim())) {

                writeFileProductType(msgSend.getPrmMsgSendPath(), productType);
                writeFileProductType(msgSend.getPrmMsgSendArcPath(), productType);
            }
        }
        return productType;

    }

    private PrmMsgSend getPrmMsgSend() {
        try {
            Iterable<PrmMsgSend> msgSends = msgSendRepository.findAll(Search
                    .expression("fileType:PRT", PrmMsgSend.class));
            if (null != msgSends && null != msgSends.iterator()) {
                if (msgSends.iterator().hasNext()) {
                    return msgSends.iterator().next();
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
        } catch (ErrorType errorType) {
        }
        return null;
    }

    private void writeFileProductType(String path, ProductType proT) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            com.sinno.wms.crud.modelbasic.products.ProductType productType = com.sinno.ems.mapperWms.MapperProductType.convertToWmsDto(proT);
            ConvertManagerProductType.writeFileProductType(path + File.separator + "IPT01" + dateFormat.format(new Date()) + ".xls", langue, productType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeFileProductType(String path, List<ProductType> productTypes) {

        try {
            //  String date = new SimpleDateFormat("yyyyMMddHHmmssS").format(Calendar.getInstance().getTime());
            path = path.replace("\\", File.separator);
            String langue = "FR";
            List<com.sinno.wms.crud.modelbasic.products.ProductType> productTypeList = new ArrayList<>();
            for (ProductType proT : productTypes) {
                productTypeList.add(com.sinno.ems.mapperWms.MapperProductType.convertToWmsDto(proT));
            }
            ConvertManagerProductType.writeFileProductType(path + File.separator + "IPT01" + dateFormat.format(new Date()) + ".xls", langue, productTypeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   /*     public void readFileProductType(com.sinno.wms.crud.modelbasic.products.ProductType proT){
                try {
                    proT = ConvertManagerProductType.readFileProductType("IPT01.xls").get(0);
                    ProductType productType=new ProductType();
                    productType = MapperProductType.convertToEmsDto(proT);
                    productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(productType, false));

                }catch(Exception e){
                    e.printStackTrace();
                }

            }  */

    @Override
    public Long size() {
        return productTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return productTypeRepository.exists(id);
    }

    @Override
    public ProductType findById(Long id) throws IdNotFound {
        ProductType productType = ProductTypeMapper.toDto(productTypeRepository.findOne(id), false);
        if (null != productType) {
            return productType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ProductType> find(String search) throws AttributesNotFound, ErrorType {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class)), false);
    }

    @Override
    public List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "pdtProductTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(Search.expression(search, PdtProductType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return productTypeRepository.count(Search.expression(search, PdtProductType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ProductType");
        productTypeRepository.delete(id);
    }

    @Override
    public void delete(ProductType productType) {
        LOGGER.info("delete ProductType");
        productTypeRepository.delete(ProductTypeMapper.toEntity(productType, false));
    }

    @Override
    public List<ProductType> findAll() {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(), false);
    }

    @Override
    public List<ProductType> findAll(Pageable pageable) {
        return ProductTypeMapper.toDtos(productTypeRepository.findAll(pageable), false);
    }

    @Override
    @Transactional
    public ProductType loadWmsProductType(com.sinno.wms.crud.modelbasic.products.ProductType productType) {
        PdtProductType pdtProductType = productTypeRepository.findByPdtProductTypeCode(productType.getProduct_type_code());
        ProductType productParentType = ProductTypeMapper.toDto(productTypeRepository.findByPdtProductTypeCode(productType.getParent_type_code()), false);
        ProductType pdtType = null;
        Owner owner = null;
        try {
            owner = OwnerMapper.toDto(ownerRepository.findOne(Search.expression("organisation.id:1", OwnOwner.class)), false);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }
        if (null != pdtProductType) {
            pdtType = ProductTypeMapper.toDto(pdtProductType, false);
        } else {
            // NEW PRODUCT_TYPE
            pdtType = new ProductType();
            pdtType.setCreationDate(EmsDate.getDateNow());
        }
        if (null != pdtType) {
            pdtType = MapperProductType.convertToEmsDto(pdtType, productType);
            pdtType.setUpdateDate(EmsDate.getDateNow());
            pdtType.setProductType(productParentType);
            pdtType.setOwner(owner);
            pdtType = ProductTypeMapper.toDto(productTypeRepository.saveAndFlush(ProductTypeMapper.toEntity(pdtType, false)), false);
            return pdtType;
        }
        return null;
    }

    @Override
    public List<ProductType> exportWmsProductType(List<ProductType> productTypes) {
        writeFileProductType(null != getPrmMsgSend() ? getPrmMsgSend().getPrmMsgSendPath() : System.getenv("APPDATA"), productTypes);
        return productTypes;
    }
}
