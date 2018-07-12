package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PaymentSupplierInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */
@Controller
@RequestMapping(value = "/paymentSupplierInvoices/")
public class PaymentSupplierInvoiceController {
    @Autowired
    private PaymentSupplierInvoiceService zoneService;


    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<PaymentSupplierInvoice> getPaymentSupplierInvoices() throws AttributesNotFound, ErrorType {

        return zoneService.findAll();
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentSupplierInvoice> getPaymentSupplierInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);

        return zoneService.findAll(pageable);    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return zoneService.size();
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return zoneService.size(search);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return zoneService.isExist(id);
    }           @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public PaymentSupplierInvoice getPaymentSupplierInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return zoneService.findById(id);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentSupplierInvoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return zoneService.find(search);
    }

    @PreAuthorize("hasAnyRole('SUPPLIER_INVOICE_PAYMENT_VIEW','PAYMENT_SUPPLIER_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentSupplierInvoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return zoneService.find(search, page,size);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_PAYMENT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentSupplierInvoice add(@RequestBody PaymentSupplierInvoice zone) {
        return zoneService.save(zone);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_PAYMENT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentSupplierInvoice set(@RequestBody PaymentSupplierInvoice zone) {
        return zoneService.save(zone);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_PAYMENT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentSupplierInvoice zone) {

        zoneService.delete(zone);
    }

    @PreAuthorize("hasRole('SUPPLIER_INVOICE_PAYMENT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        zoneService.delete(id);
    }
}
