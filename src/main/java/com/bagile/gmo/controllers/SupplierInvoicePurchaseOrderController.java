package com.bagile.gmo.controllers;


import com.bagile.gmo.dto.SupplierInvoicePurchaseOrder;
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

@Controller
@RequestMapping(value = "/supplierInvoicePurchaseOrders/")
public class SupplierInvoicePurchaseOrderController {

    @Autowired
    private SupplierInvoicePurchaseOrderService supplierInvoicePurchaseOrderService;

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SupplierInvoicePurchaseOrder> getSupplierInvoicePurchaseOrders() {
        return supplierInvoicePurchaseOrderService.findAll();
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierInvoicePurchaseOrder> getSupplierInvoicePurchaseOrders(@RequestParam int page, @RequestParam int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return supplierInvoicePurchaseOrderService.findAll(pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return supplierInvoicePurchaseOrderService.size();
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return supplierInvoicePurchaseOrderService.size(search);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierInvoicePurchaseOrderService.isExist(id);
    }    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SupplierInvoicePurchaseOrder getSupplierInvoicePurchaseOrder(@PathVariable("id") Long id) throws IdNotFound {
        return supplierInvoicePurchaseOrderService.findById(id);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierInvoicePurchaseOrder> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return supplierInvoicePurchaseOrderService.find(search);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierInvoicePurchaseOrder> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return supplierInvoicePurchaseOrderService.find(search, pageable);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoicePurchaseOrder add(@RequestBody SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder) {
        return supplierInvoicePurchaseOrderService.save(supplierInvoicePurchaseOrder);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoicePurchaseOrder set(@RequestBody SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder) {
        return supplierInvoicePurchaseOrderService.save(supplierInvoicePurchaseOrder);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierInvoicePurchaseOrder supplierInvoicePurchaseOrder) {

        supplierInvoicePurchaseOrderService.delete(supplierInvoicePurchaseOrder);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierInvoicePurchaseOrderService.delete(id);
    }
}