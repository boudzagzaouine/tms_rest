package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SupplierService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/suppliers/")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Supplier> getSuppliers() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return supplierService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Supplier> getSuppliers(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return supplierService.find(userDetailsService.getOwners().toString(),page,size);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return supplierService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return supplierService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Supplier getSupplier(@PathVariable("id") Long id) throws IdNotFound {
        return supplierService.findById(id);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Supplier> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }

        return supplierService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_VIEW','PURSHASE_ORDER_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','DELIVERY_VIEW','STOCK_VIEW','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Supplier> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return supplierService.find(search + userDetailsService.getOwners().toString(), page,size);
    }

    @PreAuthorize("hasRole('SUPPLIER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier add(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier set(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Supplier supplier) {

        supplierService.delete(supplier);
    }

    @PreAuthorize("hasRole('SUPPLIER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }
}