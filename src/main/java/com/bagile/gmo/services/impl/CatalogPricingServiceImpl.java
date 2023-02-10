package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.CatalogPricing;
import com.bagile.gmo.dto.TurnType;
import com.bagile.gmo.dto.Vat;
import com.bagile.gmo.entities.TmsCatalogPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.AddressDelivery;
import com.bagile.gmo.importModels.CatalogPricingImport;
import com.bagile.gmo.mapper.CatalogPricingMapper;
import com.bagile.gmo.repositories.CatalogPricingRepository;
import com.bagile.gmo.services.*;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CatalogPricingServiceImpl implements CatalogPricingService {
    private final CatalogPricingRepository catalogPricingRepository;

    @Autowired
    private TurnTypeService turnTypeService;
    @Autowired
    private PaysService paysService;
    @Autowired
    private VilleService villeService;
    @Autowired
    private VehicleCategoryService vehicleCategoryService;
    @Autowired
    private VehicleTrayService vehicleTrayService;

    @Autowired
    private  LoadingTypeService loadingTypeService;

    @Autowired
    private VatService vatService;

    @Autowired
    private TrajetService trajetService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(Address.class);
    public CatalogPricingServiceImpl(CatalogPricingRepository catalogPricingRepository) {
        this.catalogPricingRepository = catalogPricingRepository;
    }

    @Override
    public CatalogPricing save(CatalogPricing transport) {
        return CatalogPricingMapper.toDto(catalogPricingRepository.saveAndFlush(CatalogPricingMapper.toEntity(transport, false)), false);
    }

    @Override
    public List<CatalogPricing> saveAll(List<CatalogPricing> catalogPricings) throws AttributesNotFound, ErrorType {

        List<CatalogPricing> transportTypeList = new ArrayList<>();

        for (CatalogPricing catalogPricing : catalogPricings) {
            transportTypeList.add(save(catalogPricing));
        }

        return transportTypeList;

    }
    @Override
    public Long size() {
        return catalogPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogPricingRepository.existsById(id);
    }

    @Override
    public CatalogPricing findById(Long id) throws IdNotFound {
        return CatalogPricingMapper.toDto(catalogPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(Search.expression(search, TmsCatalogPricing.class)), false);
    }

    @Override
    public List<CatalogPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(Search.expression(search, TmsCatalogPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogPricingRepository.count(Search.expression(search, TmsCatalogPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogPricing transport) {
        catalogPricingRepository.delete(CatalogPricingMapper.toEntity(transport, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogPricing> findAll() {
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(pageable), false);
    }



    @Override
    public List<CatalogPricingImport> loadingDataImport(List<CatalogPricingImport> catalogPricingImports) throws ErrorType, AttributesNotFound, IdNotFound {
        List<CatalogPricing> catalogPricingList = new ArrayList<>();
        CatalogPricing catalogPricing = new CatalogPricing();

        for (CatalogPricingImport catalogPricingImport : catalogPricingImports) {
            try {

                catalogPricing.setTrajet((trajetService.find("code:" + catalogPricingImport.getCatalogPricing_Trajet())).stream().findFirst().orElse(null));

                catalogPricing.setTurnType((turnTypeService.find("code:" + catalogPricingImport.getCatalogPricing_TurnType())).stream().findFirst().orElse(null));
                catalogPricing.setVehicleCategory(vehicleCategoryService.find("code:"+ catalogPricingImport.getCatalogPricing_VehicleCategory()).stream().findFirst().orElse(null));
                catalogPricing.setVehicleTray(vehicleTrayService.find("code:"+ catalogPricingImport.getCatalogPricing_VehicleTray()).stream().findFirst().orElse(null));
                catalogPricing.setLoadingType(loadingTypeService.find("code:"+catalogPricingImport.getCatalogPricing_LoadingType()).stream().findFirst().orElse(null));

                catalogPricing.setPurchaseAmountHt(new BigDecimal(catalogPricingImport.getCatalogPricing_PurchaseAmountHt()));

                catalogPricing.setPurchaseVat(vatService.find("value:"+new BigDecimal(catalogPricingImport.getCatalogPricing_PurchaseVat())).stream().findFirst().orElse(null));                catalogPricing.setPurchaseAmountTva((catalogPricing.getPurchaseAmountHt().divide(BigDecimal.valueOf(100))).multiply(catalogPricing.getPurchaseVat().getValue()));
                catalogPricing.setPurchaseAmountTtc(catalogPricing.getPurchaseAmountHt().add(catalogPricing.getPurchaseAmountTva()));

                catalogPricing.setSaleAmountHt(new BigDecimal(catalogPricingImport.getCatalogPricing_SaleAmountHt()));
                catalogPricing.setSaleVat(vatService.find("value:"+new BigDecimal(catalogPricingImport.getCatalogPricing_SaleVat())).stream().findFirst().orElse(null));                catalogPricing.setPurchaseAmountTva((catalogPricing.getPurchaseAmountHt().divide(BigDecimal.valueOf(100))).multiply(catalogPricing.getPurchaseVat().getValue()));
                catalogPricing.setSaleAmountTva((catalogPricing.getSaleAmountHt().divide(BigDecimal.valueOf(100))).multiply(catalogPricing.getSaleVat().getValue()));
                catalogPricing.setSaleAmountTtc(catalogPricing.getSaleAmountHt().add(catalogPricing.getSaleAmountTva()));


                catalogPricingList.add(save(catalogPricing));

            }catch (Exception e){
                LOGGER.error("error importing ");
            }
        }
        saveAll(catalogPricingList);

        return null;

    }

}

