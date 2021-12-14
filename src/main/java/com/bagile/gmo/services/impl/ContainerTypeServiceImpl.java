package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.ContainerType;
import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.entities.PrmContainerType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ContainerTypeMapper;
import com.bagile.gmo.repositories.ContainerTypeRepository;
import com.bagile.gmo.services.ContainerTypeService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class ContainerTypeServiceImpl implements ContainerTypeService {
    @Autowired
    private ContainerTypeRepository containerTypeRepository;
   // @Autowired
    //private ProductPackContainerTypeService productPackContainerTypeService;
    @Autowired
    private SettingService settingService;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ContainerTypeService.class);


    @Override
    public ContainerType save(ContainerType containerType) {
        LOGGER.info("save ContainerType");
        containerType.setUpdateDate(EmsDate.getDateNow());
        if (0 >= containerType.getId()) {
            containerType.setCreationDate(EmsDate.getDateNow());
        }
        return ContainerTypeMapper.toDto(containerTypeRepository.saveAndFlush(ContainerTypeMapper.toEntity(containerType, false)), false);
    }

    @Override
    public Long size() {
        return containerTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return containerTypeRepository.existsById(id);
    }

    @Override
    public ContainerType findById(Long id) throws IdNotFound {
        ContainerType containerType = ContainerTypeMapper.toDto(containerTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != containerType) {
            return containerType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ContainerType> find(String search) throws AttributesNotFound, ErrorType {
        return ContainerTypeMapper.toDtos(containerTypeRepository.findAll(Search.expression(search, PrmContainerType.class)), false);
    }

    @Override
    public ContainerType findOne(String search) throws AttributesNotFound, ErrorType {
        return ContainerTypeMapper.toDto(containerTypeRepository.findOne(Search.expression(search, PrmContainerType.class)).orElseThrow(() -> new AttributesNotFound(search)), false);

    }


    @Override
    public List<ContainerType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.DESC, "prmContainerTypeUpdateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return ContainerTypeMapper.toDtos(containerTypeRepository.findAll(Search.expression(search, PrmContainerType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return containerTypeRepository.count(Search.expression(search, PrmContainerType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ContainerType");
        containerTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ContainerType containerType) {
        LOGGER.info("delete ContainerType");
        containerTypeRepository.delete(ContainerTypeMapper.toEntity(containerType, false));
    }

    @Override
    public List<ContainerType> findAll() {
        return ContainerTypeMapper.toDtos(containerTypeRepository.findAll(), false);
    }

    @Override
    public List<ContainerType> findAll(Pageable pageable) {
        return ContainerTypeMapper.toDtos(containerTypeRepository.findAll(pageable), false);
    }

    @Override
    public ContainerType findByCode(String code) {
        return ContainerTypeMapper.toDto(containerTypeRepository.findByPrmContainerTypeCode(code), false);
    }

    @Override
    public boolean containerCanHandelProduct(ProductPack productPack, ContainerType containerType, BigDecimal quantity) throws AttributesNotFound, ErrorType {
        return false;
    }

  /*  @Override
    public boolean containerCanHandelProduct(ProductPack productPack, ContainerType containerType, BigDecimal quantity) throws AttributesNotFound, ErrorType {
        if (settingService.containerTypeManagement()) {
            ProductPackContainerType productPackContainerType = productPackContainerTypeService.findOne("uom.id:" + productPack.getUom().getId() + ",product.id:" + productPack.getProduct().getId() + ",containerType.id:" + containerType.getId());
            if (productPackContainerType == null) {
                return true;
            } else if (productPackContainerType.getQuantity().compareTo(quantity) > -1 && (productPack.getWeight() == null ||containerType.getMaxWeight()==null || (containerType.getMaxWeight().compareTo(quantity.multiply(productPack.getWeight())) > -1))) {
                return true;
            } else return false;
        }
        else return true;
    }*/


}
