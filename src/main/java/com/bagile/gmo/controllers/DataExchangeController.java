package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.dto.Trajet;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.*;
import com.bagile.gmo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/dataExchanges")
public class DataExchangeController {

    @Autowired
    private  AddressService addressService;
    @Autowired
    private  CatalogPricingService catalogPricingService;
    @Autowired
    private AccountPricingService accountPricingService;

    @Autowired
    private CatalogTransportAccountPricingService catalogTransportAccountPricingService;
    @Autowired
    private CatalogTransportPricingService catalogTransportPricingService;
    @Autowired
    private ProductServiceService productServiceService;

    @Autowired
    private TrajetService trajetService;

    @Autowired
    private CompanyService companyService;
    public DataExchangeController() {

    }

    @RequestMapping(value = "/saveAddressDeliverys", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AddressDelivery> saveAddressDeliverys(@RequestBody List<AddressDelivery> addressDeliveries) throws IdNotFound, ErrorType, AttributesNotFound {
       return  addressService.loadingDataImport(addressDeliveries);

    }

    @RequestMapping(value = "/saveCatalogPricings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CatalogPricingImport> saveCatalogPricings(@RequestBody List<CatalogPricingImport> catalogPricingImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  catalogPricingService.loadingDataImport(catalogPricingImports);

    }

    @RequestMapping(value = "/saveAccountPricings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AccountPricingImport> saveAccountPricings(@RequestBody List<AccountPricingImport> accountPricingImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  accountPricingService.loadingDataImport(accountPricingImports);

    }

    @RequestMapping(value = "/saveCatalogTransportAccountPricings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CatalogTransportAccountPricingImport> saveCatalogTransportAccountPricings(@RequestBody List<CatalogTransportAccountPricingImport> catalogTransportAccountPricingImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  catalogTransportAccountPricingService.loadingDataImport(catalogTransportAccountPricingImports);

    }

    @RequestMapping(value = "/saveCatalogTransportPricings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CatalogTransportPricingImport> saveCatalogTransportPricings(@RequestBody List<CatalogTransportPricingImport> catalogTransportPricingImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  catalogTransportPricingService.loadingDataImport(catalogTransportPricingImports);

    }

    @RequestMapping(value = "/saveTrajets", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Trajet> saveTrajets(@RequestBody List<TrajetImport> trajetImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  trajetService.loadingDataImport(trajetImports);

    }

    @RequestMapping(value = "/updateCompanies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Company> saveCompanys(@RequestBody List<CompanyImport> companyImports) throws IdNotFound, ErrorType, AttributesNotFound {
        return  companyService.loadingDataImport(companyImports);

    }




}
