package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.PaymentStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(value = "/paymentStatuss/")
public class PaymentStatusController {

    @Autowired
    private PaymentStatusService paymentStatusService;

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PaymentStatus> getPaymentStatuss() {
        return paymentStatusService.findAll();
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentStatus> getPaymentStatuss(@RequestParam int page, @RequestParam int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return paymentStatusService.findAll(pageable);
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return paymentStatusService.size();
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return paymentStatusService.size(search);
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return paymentStatusService.isExist(id);
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PaymentStatus getPaymentStatus(@PathVariable("id") Long id) throws IdNotFound {
        return paymentStatusService.findById(id);
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentStatus> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return paymentStatusService.find(search);
    }

           @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentStatus> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return paymentStatusService.find(search, pageable);
    }

    @PreAuthorize("hasRole('PAYMENT_STATUS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentStatus add(@RequestBody PaymentStatus paymentStatus) {
        return paymentStatusService.save(paymentStatus);
    }

    @PreAuthorize("hasRole('PAYMENT_STATUS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentStatus set(@RequestBody PaymentStatus paymentStatus) {
        return paymentStatusService.save(paymentStatus);
    }

    @PreAuthorize("hasRole('PAYMENT_STATUS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentStatus paymentStatus) {

        paymentStatusService.delete(paymentStatus);
    }

    @PreAuthorize("hasRole('PAYMENT_STATUS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        paymentStatusService.delete(id);
    }
}