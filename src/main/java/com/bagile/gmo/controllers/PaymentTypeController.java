package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.PaymentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.PaymentStatusService;
import com.bagile.gmo.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Controller
@RequestMapping(value = "/paymentTypes/")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PaymentType> getPaymentTypes() throws AttributesNotFound, ErrorType {
        return paymentTypeService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentType> getPaymentTypes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return search("", page, size);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return paymentTypeService.size();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return paymentTypeService.size(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return paymentTypeService.isExist(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PaymentType getPaymentType(@PathVariable("id") Long id) throws IdNotFound {
        return paymentTypeService.findById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return paymentTypeService.find(search);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return paymentTypeService.find(search, page, size);
    }

    @PreAuthorize("hasRole('PAYMENT_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentType add(@RequestBody PaymentType paymentType) {
        return paymentTypeService.save(paymentType);
    }

    @PreAuthorize("hasRole('PAYMENT_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentType set(@RequestBody PaymentType paymentType) {
        return paymentTypeService.save(paymentType);
    }

    @PreAuthorize("hasRole('PAYMENT_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentType paymentType) {

        paymentTypeService.delete(paymentType);
    }

    @PreAuthorize("hasRole('PAYMENT_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        paymentTypeService.delete(id);
    }
}