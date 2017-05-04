package com.sinno.ems.controller;

import com.sinno.ems.dto.PaymentSupplier;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PaymentSupplierService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/paymentSuppliers/")
public class PaymentSupplierController {

    @Autowired
    private PaymentSupplierService paymentSupplierService;

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PaymentSupplier> getPaymentSuppliers() throws AttributesNotFound, ErrorType {

        return paymentSupplierService.findAll();

        //  return paymentSupplierService.findAll();
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentSupplier> getPaymentSuppliers(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return paymentSupplierService.findAll(pageable);
        // return paymentSupplierService.findAll(pageable);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return paymentSupplierService.size();
        //return paymentSupplierService.size();
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return paymentSupplierService.size(search );

        // return paymentSupplierService.size(search);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return paymentSupplierService.isExist(id);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PaymentSupplier getPaymentSupplier(@PathVariable("id") Long id) throws IdNotFound {
        return paymentSupplierService.findById(id);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentSupplier> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return paymentSupplierService.find(search);

        // return paymentSupplierService.find(search);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentSupplier> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return paymentSupplierService.find(search  , page, size);

        //  return paymentSupplierService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentSupplier add(@RequestBody PaymentSupplier paymentSupplier) throws IOException {
        return paymentSupplierService.save(paymentSupplier);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentSupplier set(@RequestBody PaymentSupplier paymentSupplier) throws IOException {
        return paymentSupplierService.save(paymentSupplier);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentSupplier paymentSupplier) {

        paymentSupplierService.delete(paymentSupplier);
    }

    //@PreAuthorize("hasRole('PAYMENT_SUPPLIER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        paymentSupplierService.delete(id);
    }
}