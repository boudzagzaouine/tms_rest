package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.dto.SupplierInvoice;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.services.PaymentStatusService;
import com.bagile.gmo.services.SupplierInvoiceService;
import com.bagile.gmo.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/supplierInvoices/")
public class SupplierInvoiceController {

    @Autowired
    private SupplierInvoiceService supplierInvoiceService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SupplierInvoice> getSupplierInvoices() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return supplierInvoiceService.find(userDetailsService.getOwners().toString());

    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierInvoice> getSupplierInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }

        return supplierInvoiceService.find(userDetailsService.getOwners().toString(),page,size);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return supplierInvoiceService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return supplierInvoiceService.size(search +userDetailsService.getOwners().toString());

        // return supplierInvoiceService.size(EncoderDecoder.decode(search));
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {

        return supplierInvoiceService.isExist(id);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SupplierInvoice getSupplierInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return supplierInvoiceService.findById(id);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierInvoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return supplierInvoiceService.find(search + userDetailsService.getOwners().toString());

    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierInvoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return supplierInvoiceService.find(search + userDetailsService.getOwners().toString(), page, size);

        //  return supplierService.find(EncoderDecoder.decode(search), pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice add(@RequestBody SupplierInvoice supplierInvoice) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return supplierInvoiceService.save(supplierInvoice);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/genereteInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice generateInvoice(@RequestBody PurshaseOrder purshaseOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return supplierInvoiceService.generateSupplierInvoice(purshaseOrder);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice set(@RequestBody SupplierInvoice supplierInvoice) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return supplierInvoiceService.save(supplierInvoice);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierInvoice supplierInvoice) {

        supplierInvoiceService.delete(supplierInvoice);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws IdNotFound {
        supplierInvoiceService.delete(id);
    }


    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return supplierInvoiceService.getNextVal();
    }
    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/merge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice merge(@RequestBody SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return supplierInvoiceService.merge(supplierInvoice);
    }
    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/generateSupplierInvoiceFromOrders", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice generateSupplierInvoiceFromOrders(@RequestBody SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return supplierInvoiceService.generateSupplierInvoiceFromOrders(supplierInvoice);
    }
    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/generateSupplierInvoiceFromReceptions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice generateSupplierInvoiceFromReceptions(@RequestBody SupplierInvoice supplierInvoice) throws IdNotFound, AttributesNotFound, ErrorType, CustomException, ProductControls, ContainerException {
        return supplierInvoiceService.generateSupplierInvoiceFromReceptions(supplierInvoice);
    }
}