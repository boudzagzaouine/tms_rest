package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.SupplierInvoiceReception;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.List;

@Controller
@RequestMapping(value = "/supplierInvoiceReceptions/")
public class SupplierInvoiceReceptionController {

    @Autowired
    private SupplierInvoiceReceptionService supplierInvoiceReceptionService;

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SupplierInvoiceReception> getSupplierInvoiceReceptions() {
        return supplierInvoiceReceptionService.findAll();
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierInvoiceReception> getSupplierInvoiceReceptions(@RequestParam int page, @RequestParam int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return supplierInvoiceReceptionService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return supplierInvoiceReceptionService.size();
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return supplierInvoiceReceptionService.size(search);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierInvoiceReceptionService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SupplierInvoiceReception getSupplierInvoiceReception(@PathVariable("id") Long id) throws IdNotFound {
        return supplierInvoiceReceptionService.findById(id);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierInvoiceReception> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return supplierInvoiceReceptionService.find(search);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierInvoiceReception> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return supplierInvoiceReceptionService.find(search, pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoiceReception add(@RequestBody SupplierInvoiceReception supplierInvoiceReception) {
        return supplierInvoiceReceptionService.save(supplierInvoiceReception);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoiceReception set(@RequestBody SupplierInvoiceReception supplierInvoiceReception) {
        return supplierInvoiceReceptionService.save(supplierInvoiceReception);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierInvoiceReception supplierInvoiceReception) {

        supplierInvoiceReceptionService.delete(supplierInvoiceReception);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierInvoiceReceptionService.delete(id);
    }
}