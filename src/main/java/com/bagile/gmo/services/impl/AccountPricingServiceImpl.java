package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.TmsAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.AccountPricingImport;
import com.bagile.gmo.importModels.CatalogPricingImport;
import com.bagile.gmo.mapper.AccountPricingMapper;
import com.bagile.gmo.repositories.AccountPricingRepository;
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
public class AccountPricingServiceImpl implements AccountPricingService {
    
    private final AccountPricingRepository actionTypeRepository;

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
    private final static Logger LOGGER = LoggerFactory
            .getLogger(Address.class);

    public AccountPricingServiceImpl(AccountPricingRepository actionTypeRepository) {
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public AccountPricing save(AccountPricing actionType) {
        return AccountPricingMapper.toDto(actionTypeRepository.saveAndFlush(AccountPricingMapper.toEntity(actionType, false)), false);
    }

    @Override
    public List<AccountPricing> saveAll(List<AccountPricing> accountPricings) throws AttributesNotFound, ErrorType {

        List<AccountPricing> accountPricingList = new ArrayList<>();

        for (AccountPricing accountPricing : accountPricings) {
            accountPricingList.add(save(accountPricing));
        }

        return accountPricingList;

    }

    @Override
    public Long size() {
        return actionTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionTypeRepository.existsById(id);
    }

    @Override
    public AccountPricing findById(Long id) throws IdNotFound {
        return AccountPricingMapper.toDto(actionTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AccountPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, TmsAccountPricing.class)), false);
    }

    @Override
    public List<AccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, TmsAccountPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionTypeRepository.count(Search.expression(search, TmsAccountPricing.class));
    }

    @Override
    public void delete(Long id) {
        actionTypeRepository.deleteById(id);
    }

    @Override
    public void delete(AccountPricing actionType) {
        actionTypeRepository.delete(AccountPricingMapper.toEntity(actionType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionTypeRepository.deleteById(id);        }
    }


    @Override
    public List<AccountPricing> findAll() {
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(), false);
    }

    @Override
    public List<AccountPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AccountPricingMapper.toDtos(actionTypeRepository.findAll(pageable), false);
    }

    @Override
    public AccountPricing findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }



    @Override
    public List<AccountPricingImport> loadingDataImport(List<AccountPricingImport> accountPricingImports) throws ErrorType, AttributesNotFound, IdNotFound {
        List<AccountPricing> accountPricingList = new ArrayList<>();
        AccountPricing accountPricing = new AccountPricing();

        for (AccountPricingImport accountPricingImport : accountPricingImports) {
            try {

                accountPricing.setCompany((companyService.find("name:" + accountPricingImport.getAccountPricing_Company())).stream().findFirst().orElse(null));
                accountPricing.setTrajet((trajetService.find("code:" + accountPricingImport.getAccountPricing_Trajet())).stream().findFirst().orElse(null));

                accountPricing.setTurnType((turnTypeService.find("code:" + accountPricingImport.getAccountPricing_TurnType())).stream().findFirst().orElse(null));
//                accountPricing.setPaysSource(paysService.findById(1L));
//                accountPricing.setVilleSource(villeService.find("code:"+ accountPricingImport.getCatalogPricing_VilleSource()).stream().findFirst().orElse(null));
//                accountPricing.setPaysDestination(paysService.findById(1L));
//                accountPricing.setVilleDestination(villeService.find("code:"+ accountPricingImport.getCatalogPricing_VilleDestination()).stream().findFirst().orElse(null));
//                accountPricing.setVehicleCategory(vehicleCategoryService.find("code:"+ accountPricingImport.getCatalogPricing_VehicleCategory()).stream().findFirst().orElse(null));
                accountPricing.setVehicleTray(vehicleTrayService.find("code:"+ accountPricingImport.getAccountPricing_VehicleTray()).stream().findFirst().orElse(null));
                accountPricing.setLoadingType(loadingTypeService.find("code:"+accountPricingImport.getAccountPricing_LoadingType()).stream().findFirst().orElse(null));
                accountPricing.setVehicleCategory(vehicleCategoryService.find("code:"+accountPricingImport.getAccountPricing_VehicleCategory()).stream().findFirst().orElse(null));

                accountPricing.setSaleAmountHt(new BigDecimal(accountPricingImport.getAccountPricing_SaleAmountHt()));

                accountPricing.setSaleVat(vatService.find("value:"+new BigDecimal(accountPricingImport.getAccountPricing_SaleVat())).stream().findFirst().orElse(null));
                accountPricing.setSaleAmountTva((accountPricing.getSaleAmountHt().divide(BigDecimal.valueOf(100))).multiply(accountPricing.getSaleVat().getValue()));
                accountPricing.setSaleAmountTtc(accountPricing.getSaleAmountHt().add(accountPricing.getSaleAmountTva()));


                accountPricingList.add(save(accountPricing));

            }catch (Exception e){
                LOGGER.error("error importing ");
            }
        }
        saveAll(accountPricingList);

        return null;

    }

}

