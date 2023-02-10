package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.CatalogPricing;
import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.entities.TmsCatalogTransportAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.CatalogPricingImport;
import com.bagile.gmo.importModels.CatalogTransportAccountPricingImport;
import com.bagile.gmo.mapper.CatalogTransportAccountPricingMapper;
import com.bagile.gmo.repositories.CatalogTransportAccountPricingRepository;
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
public class CatalogTransportAccountPricingServiceImpl implements CatalogTransportAccountPricingService {
    private final CatalogTransportAccountPricingRepository catalogTransportAccountPricingRepository;
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
    public CatalogTransportAccountPricingServiceImpl(CatalogTransportAccountPricingRepository catalogTransportAccountPricingRepository) {
        this.catalogTransportAccountPricingRepository = catalogTransportAccountPricingRepository;
    }

    @Override
    public CatalogTransportAccountPricing save(CatalogTransportAccountPricing catalogTransportAccountPricing) {
        return CatalogTransportAccountPricingMapper.toDto(catalogTransportAccountPricingRepository.saveAndFlush(CatalogTransportAccountPricingMapper.toEntity(catalogTransportAccountPricing, false)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> saveAll(List<CatalogTransportAccountPricing> catalogTransportAccountPricings) throws AttributesNotFound, ErrorType {

        List<CatalogTransportAccountPricing> catalogTransportAccountPricingTypeList = new ArrayList<>();

        for (CatalogTransportAccountPricing catalogTransportAccountPricing : catalogTransportAccountPricings) {
            catalogTransportAccountPricingTypeList.add(save(catalogTransportAccountPricing));
        }

        return catalogTransportAccountPricingTypeList;

    }
    @Override
    public Long size() {
        return catalogTransportAccountPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogTransportAccountPricingRepository.existsById(id);
    }

    @Override
    public CatalogTransportAccountPricing findById(Long id) throws IdNotFound {
        return CatalogTransportAccountPricingMapper.toDto(catalogTransportAccountPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(Search.expression(search, TmsCatalogTransportAccountPricing.class)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(Search.expression(search, TmsCatalogTransportAccountPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogTransportAccountPricingRepository.count(Search.expression(search, TmsCatalogTransportAccountPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogTransportAccountPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogTransportAccountPricing catalogTransportAccountPricing) {
        catalogTransportAccountPricingRepository.delete(CatalogTransportAccountPricingMapper.toEntity(catalogTransportAccountPricing, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogTransportAccountPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogTransportAccountPricing> findAll() {
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CT" + catalogTransportAccountPricingRepository.getNextVal().get(0);
        return value;


    }

    @Override
    public List<CatalogTransportAccountPricingImport> loadingDataImport(List<CatalogTransportAccountPricingImport> catalogTransportAccountPricings) throws ErrorType, AttributesNotFound, IdNotFound {
        List<CatalogTransportAccountPricing> catalogTransportAccountPricingList = new ArrayList<>();
        CatalogTransportAccountPricing catalogTransportAccountPricing = new CatalogTransportAccountPricing();

        for (CatalogTransportAccountPricingImport catalogTransportAccountPricingImport : catalogTransportAccountPricings) {
            try {

                catalogTransportAccountPricing.setTransport((transportService.find("name:" + catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_Transport())).stream().findFirst().orElse(null));
                catalogTransportAccountPricing.setCompany((companyService.find("name:" + catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_Company())).stream().findFirst().orElse(null));


                catalogTransportAccountPricing.setTrajet((trajetService.find("code:" + catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_Trajet())).stream().findFirst().orElse(null));

                catalogTransportAccountPricing.setTurnType((turnTypeService.find("code:" + catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_TurnType())).stream().findFirst().orElse(null));
                catalogTransportAccountPricing.setVehicleCategory(vehicleCategoryService.find("code:"+ catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_VehicleCategory()).stream().findFirst().orElse(null));
                catalogTransportAccountPricing.setVehicleTray(vehicleTrayService.find("code:"+ catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_VehicleTray()).stream().findFirst().orElse(null));
                catalogTransportAccountPricing.setLoadingType(loadingTypeService.find("code:"+catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_LoadingType()).stream().findFirst().orElse(null));

                catalogTransportAccountPricing.setPurchaseAmountHt(new BigDecimal(catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_PurchaseAmountHt()));
                catalogTransportAccountPricing.setPurchaseVat(vatService.find("value:"+new BigDecimal(catalogTransportAccountPricingImport.getCatalogTransportAccountPricing_PurchaseVat())).stream().findFirst().orElse(null));
                catalogTransportAccountPricing.setPurchaseAmountTva((catalogTransportAccountPricing.getPurchaseAmountHt().divide(BigDecimal.valueOf(100))).multiply(catalogTransportAccountPricing.getPurchaseVat().getValue()));
                catalogTransportAccountPricing.setPurchaseAmountTtc(catalogTransportAccountPricing.getPurchaseAmountHt().add(catalogTransportAccountPricing.getPurchaseAmountTva()));



                catalogTransportAccountPricingList.add(save(catalogTransportAccountPricing));

            }catch (Exception e){
                LOGGER.error("error importing ");
            }
        }
        saveAll(catalogTransportAccountPricingList);

        return null;

    }


}

