package com.sinno.ems.controller;

import com.sinno.ems.dto.*;
import com.sinno.ems.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enissay on 24/10/2016.
 */
@Controller
@RequestMapping(value = "/dataExchanges/")
public class DataExchangeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private ReceptionService receptionService;
    @Autowired
    private SaleOrderLineService saleOrderLineService;
    @Autowired
    private ReceptionLineService receptionLineService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private UomService uomService;
    @Autowired
    private ContainerService containerService;
    @Autowired
    private WarehouseService warehouseService;
    //TODO Warehouse OrderType
    @Autowired
    private OrganisationService organisationService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(value = "/saveProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> saveProducts(@RequestBody List<com.sinno.wms.crud.modelbasic.products.Product> products) {

        List<Product> emsProductList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.products.Product product : products) {
            Product emsProduct = productService.loadWmsProduct(product);
            if (null != emsProduct) {
                emsProductList.add(emsProduct);
            }
        }
        return emsProductList;
    }

    @RequestMapping(value = "/saveAccounts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> saveAccounts(@RequestBody List<com.sinno.wms.crud.modelbasic.accounts.Account> accounts) {

        List<Account> emsAccountList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.accounts.Account wmsAccount : accounts) {
            Account emsAccount = accountService.loadWmsAccount(wmsAccount);
            emsAccountList.add(emsAccount);

        }
        return emsAccountList;

    }

    @RequestMapping(value = "/saveSuppliers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Supplier> saveSuppliers(@RequestBody List<com.sinno.wms.crud.modelbasic.suppliers.Supplier> suppliers) {

        List<Supplier> emsSupplierList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.suppliers.Supplier supplier : suppliers) {
            Supplier emsSupplier = supplierService.loadWmsSupplier(supplier);
            emsSupplierList.add(emsSupplier);
        }
        return emsSupplierList;
    }

    @RequestMapping(value = "/saveOwners", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Owner> saveOwners(@RequestBody List<com.sinno.wms.crud.modelbasic.owners.Owner> owners) {

        List<Owner> emsOwnerList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.owners.Owner owner : owners) {
            Owner emsOwner = ownerService.loadWmsOwner(owner);
            emsOwnerList.add(emsOwner);
        }
        return emsOwnerList;
    }

    @RequestMapping(value = "/saveTransports", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Transport> saveTransports(@RequestBody List<com.sinno.wms.crud.modelbasic.carriers.Carrier> carriers) {

        List<Transport> emsTransportList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.carriers.Carrier carrier : carriers) {
            Transport emsTransport = transportService.loadWmsTransport(carrier);
            emsTransportList.add(emsTransport);
        }
        return emsTransportList;
    }

    @RequestMapping(value = "/saveCompanies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Company> saveCompanies(@RequestBody List<com.sinno.wms.crud.modelbasic.companies.Company> companies) {

        List<Company> emsCompanyList = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.companies.Company company : companies) {
            Company emsCompany = companyService.loadWmsCompany(company);
            emsCompanyList.add(emsCompany);
        }
        return emsCompanyList;
    }

    @RequestMapping(value = "/saveProductTypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductType> saveProductType(@RequestBody List<com.sinno.wms.crud.modelbasic.products.ProductType> productTypes) {

        List<ProductType> emsProductTypes = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.products.ProductType productType : productTypes) {
            ProductType emsProductType = productTypeService.loadWmsProductType(productType);
            emsProductTypes.add(emsProductType);
        }
        return emsProductTypes;
    }

    @RequestMapping(value = "/saveSaleOrders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SaleOrder> saveSaleOrder(@RequestBody List<com.sinno.wms.crud.modelbasic.saleorders.SaleOrder> saleOrders) {

        List<SaleOrder> emsSaleOrders = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.saleorders.SaleOrder saleOrder : saleOrders) {
            SaleOrder emsSaleOrder = saleOrderService.loadWmsSaleOrder(saleOrder);
            emsSaleOrders.add(emsSaleOrder);
        }
        return emsSaleOrders;
    }

    @RequestMapping(value = "/saveSaleOrderLines", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SaleOrderLine> saveSaleOrderLine(@RequestBody List<com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine> saleOrderLines) {

        List<SaleOrderLine> emsSaleOrderLines = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine saleOrderLine : saleOrderLines) {
            SaleOrderLine emsSaleOrderLine = saleOrderLineService.loadWmsSaleOrderLine(saleOrderLine);
            emsSaleOrderLines.add(emsSaleOrderLine);
        }
        return emsSaleOrderLines;
    }

    @RequestMapping(value = "/saveReceptions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Reception> saveReception(@RequestBody List<com.sinno.wms.crud.modelbasic.receptions.Reception> receptions) {

        List<Reception> emsReceptions = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.receptions.Reception reception : receptions) {
            Reception emsReception = receptionService.loadWmsReception(reception);
            emsReceptions.add(emsReception);
        }
        return emsReceptions;

    }

    @RequestMapping(value = "/saveReceptionLines", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ReceptionLine> saveReceptionLine(@RequestBody List<com.sinno.wms.crud.modelbasic.receptions.ReceptionLine> receptionsLines) {

        List<ReceptionLine> emsReceptionLines = new ArrayList<>();
        for (com.sinno.wms.crud.modelbasic.receptions.ReceptionLine receptionLine : receptionsLines) {
            ReceptionLine emsReceptionLine = receptionLineService.loadWmsReceptionLine(receptionLine);
            emsReceptionLines.add(emsReceptionLine);
        }
        return emsReceptionLines;
    }

    //////////// Export //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////


    @RequestMapping(value = "/exportProducts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> exportProducts(@RequestBody List<Product> products) {
        return productService.exportWmsProduct(products);

    }

    @RequestMapping(value = "/exportAccounts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> exportAccounts(@RequestBody List<Account> accounts) {

        return accountService.exportWmsAccount(accounts);

    }

    @RequestMapping(value = "/exportSuppliers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Supplier> exportSuppliers(@RequestBody List<Supplier> suppliers) {

          return supplierService.exportWmsSupplier(suppliers);
    }

    @RequestMapping(value = "/exportOwners", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Owner> exportOwners(@RequestBody List<Owner> owners) {

            return ownerService.exportWmsOwner(owners);
    }

    @RequestMapping(value = "/exportTransports", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Transport> exportTransports(@RequestBody List<Transport> transports) {

            return transportService.exportWmsTransport(transports);

    }

    @RequestMapping(value = "/exportCompanies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Company> exportCompanies(@RequestBody List<Company> companies) {

        return companyService.exportWmsCompany(companies);

    }

    @RequestMapping(value = "/exportProductTypes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductType> exportProductType(@RequestBody List<ProductType> productTypes) {

        return productTypeService.exportWmsProductType(productTypes);
    }

    @RequestMapping(value = "/exportSaleOrders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Delivery> exportSaleOrder(@RequestBody List<Delivery> deliveries) {


            return deliveryService.exportWmsSaleOrder(deliveries);

    }

    //@RequestMapping(value = "/exportSaleOrderLines", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    //@ResponseBody
    //public List<SaleOrderLine> exportSaleOrderLine(@RequestBody List<SaleOrderLine> saleOrderLines) {
    //    List<SaleOrderLine> emsSaleOrderLines = new ArrayList<>();
    //    for (SaleOrderLine saleOrderLine : saleOrderLines) {
    //        SaleOrderLine emsSaleOrderLine = saleOrderLineService.exportWmsSaleOrderLine(saleOrderLine);
    //        emsSaleOrderLines.add(emsSaleOrderLine);
    //    }
    //    return emsSaleOrderLines;
    //}

    @RequestMapping(value = "/exportReceptions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Reception> exportReception(@RequestBody List<Reception> receptions) {


        return receptionService.exportWmsReception(receptions);


    }

  // @RequestMapping(value = "/exportReceptionLines", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  // @ResponseBody
  // public List<ReceptionLine> exportReceptionLine(@RequestBody List<com.sinno.wms.crud.modelbasic.receptions.ReceptionLine> receptionsLines) {

  //     List<ReceptionLine> emsReceptionLines = new ArrayList<>();
  //     for (com.sinno.wms.crud.modelbasic.receptions.ReceptionLine receptionLine : receptionsLines) {
  //         ReceptionLine emsReceptionLine = receptionLineService.loadWmsReceptionLine(receptionLine);
  //         emsReceptionLines.add(emsReceptionLine);
  //     }
  //     return emsReceptionLines;
  // }

}


