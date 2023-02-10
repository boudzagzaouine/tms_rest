package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.entities.TmsCatalogTransportPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.CatalogTransportAccountPricingImport;
import com.bagile.gmo.importModels.CatalogTransportPricingImport;
import com.bagile.gmo.mapper.CatalogTransportPricingMapper;
import com.bagile.gmo.repositories.CatalogTransportPricingRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogTransportPricingServiceImpl implements CatalogTransportPricingService {
    private final CatalogTransportPricingRepository catalogTransportPricingRepository;

    @Autowired
    private VehicleCategoryService vehicleCategoryService;
    @Autowired
    private VehicleTrayService vehicleTrayService;

    @Autowired
    private LoadingTypeService loadingTypeService;

    @Autowired
    private VatService vatService;
    @Autowired
    private TurnTypeService turnTypeService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private TrajetService trajetService;

    @Autowired
    private TransportService  transportService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(Address.class);
    
    public CatalogTransportPricingServiceImpl(CatalogTransportPricingRepository catalogTransportPricingRepository) {
        this.catalogTransportPricingRepository = catalogTransportPricingRepository;
    }

    @Override
    public CatalogTransportPricing save(CatalogTransportPricing catalogTransportPricing) {
        return CatalogTransportPricingMapper.toDto(catalogTransportPricingRepository.saveAndFlush(CatalogTransportPricingMapper.toEntity(catalogTransportPricing, false)), false);
    }

    @Override
    public List<CatalogTransportPricing> saveAll(List<CatalogTransportPricing> catalogTransportPricings) throws AttributesNotFound, ErrorType {

        List<CatalogTransportPricing> catalogTransportPricingTypeList = new ArrayList<>();

        for (CatalogTransportPricing catalogTransportPricing : catalogTransportPricings) {
            catalogTransportPricingTypeList.add(save(catalogTransportPricing));
        }

        return catalogTransportPricingTypeList;

    }
    @Override
    public Long size() {
        return catalogTransportPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogTransportPricingRepository.existsById(id);
    }

    @Override
    public CatalogTransportPricing findById(Long id) throws IdNotFound {
        return CatalogTransportPricingMapper.toDto(catalogTransportPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogTransportPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(Search.expression(search, TmsCatalogTransportPricing.class)), false);
    }

    @Override
    public List<CatalogTransportPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(Search.expression(search, TmsCatalogTransportPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogTransportPricingRepository.count(Search.expression(search, TmsCatalogTransportPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogTransportPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogTransportPricing catalogTransportPricing) {
        catalogTransportPricingRepository.delete(CatalogTransportPricingMapper.toEntity(catalogTransportPricing, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogTransportPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogTransportPricing> findAll() {
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogTransportPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CT" + catalogTransportPricingRepository.getNextVal().get(0);
        return value;


    }

    @Override
    public List<CatalogTransportPricingImport> loadingDataImport(List<CatalogTransportPricingImport> catalogTransportPricings) throws ErrorType, AttributesNotFound, IdNotFound {
        List<CatalogTransportPricing> catalogTransportPricingList = new ArrayList<>();
        CatalogTransportPricing catalogTransportPricing = new CatalogTransportPricing();

        for (CatalogTransportPricingImport catalogTransportPricingImport : catalogTransportPricings) {
            try {

                catalogTransportPricing.setTransport((transportService.find("name:" + catalogTransportPricingImport.getCatalogTransportPricing_Transport())).stream().findFirst().orElse(null));


                catalogTransportPricing.setTrajet((trajetService.find("code:" + catalogTransportPricingImport.getCatalogTransportPricing_Trajet())).stream().findFirst().orElse(null));

                catalogTransportPricing.setTurnType((turnTypeService.find("code:" + catalogTransportPricingImport.getCatalogTransportPricing_TurnType())).stream().findFirst().orElse(null));
                catalogTransportPricing.setVehicleCategory(vehicleCategoryService.find("code:"+ catalogTransportPricingImport.getCatalogTransportPricing_VehicleCategory()).stream().findFirst().orElse(null));
                catalogTransportPricing.setVehicleTray(vehicleTrayService.find("code:"+ catalogTransportPricingImport.getCatalogTransportPricing_VehicleTray()).stream().findFirst().orElse(null));
                catalogTransportPricing.setLoadingType(loadingTypeService.find("code:"+catalogTransportPricingImport.getCatalogTransportPricing_LoadingType()).stream().findFirst().orElse(null));

                catalogTransportPricing.setPurchaseAmountHt(new BigDecimal(catalogTransportPricingImport.getCatalogTransportPricing_PurchaseAmountHt()));
                catalogTransportPricing.setPurchaseVat(vatService.find("value:"+new BigDecimal(catalogTransportPricingImport.getCatalogTransportPricing_PurchaseVat())).stream().findFirst().orElse(null));
                catalogTransportPricing.setPurchaseAmountTva((catalogTransportPricing.getPurchaseAmountHt().divide(BigDecimal.valueOf(100))).multiply(catalogTransportPricing.getPurchaseVat().getValue()));
                catalogTransportPricing.setPurchaseAmountTtc(catalogTransportPricing.getPurchaseAmountHt().add(catalogTransportPricing.getPurchaseAmountTva()));



                catalogTransportPricingList.add(save(catalogTransportPricing));

            }catch (Exception e){
                LOGGER.error("error importing ");
            }
        }
        saveAll(catalogTransportPricingList);

        return null;

    }


}

