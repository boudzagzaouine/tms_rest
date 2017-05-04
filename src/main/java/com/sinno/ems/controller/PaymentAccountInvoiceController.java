package com.sinno.ems.controller;

import com.sinno.ems.dto.PaymentAccountInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PaymentAccountInvoiceService;
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
@RequestMapping(value = "/paymentAccountInvoices/")
public class PaymentAccountInvoiceController {
    @Autowired
    private PaymentAccountInvoiceService zoneService;


    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PaymentAccountInvoice> getPaymentAccountInvoices() throws AttributesNotFound, ErrorType {

        return zoneService.findAll();
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentAccountInvoice> getPaymentAccountInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {


        Pageable pageable = new PageRequest(page, size);
        return zoneService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return zoneService.size();
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return zoneService.size(search);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return zoneService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PaymentAccountInvoice getPaymentAccountInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return zoneService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentAccountInvoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return zoneService.find(search);
    }

    @PreAuthorize("hasAnyRole('ACCOUNT_INVOICE_PAYMENT_VIEW','PAYMENT_ACCOUNT_VIEW','ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentAccountInvoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return zoneService.find(search, page, size);
    }

    @PreAuthorize("hasRole('ACCOUNT_INVOICE_PAYMENT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentAccountInvoice add(@RequestBody PaymentAccountInvoice zone) {
        return zoneService.save(zone);
    }

    @PreAuthorize("hasRole('ACCOUNT_INVOICE_PAYMENT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentAccountInvoice set(@RequestBody PaymentAccountInvoice zone) {
        return zoneService.save(zone);
    }

    @PreAuthorize("hasRole('ACCOUNT_INVOICE_PAYMENT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentAccountInvoice zone) {

        zoneService.delete(zone);
    }

    @PreAuthorize("hasRole('ACCOUNT_INVOICE_PAYMENT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        zoneService.delete(id);
    }
}
