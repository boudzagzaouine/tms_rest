package com.sinno.ems.controller;

import com.sinno.ems.dto.PaymentAccount;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PaymentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/paymentAccounts/")
public class PaymentAccountController {

    @Autowired
    private PaymentAccountService paymentAccountService;

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PaymentAccount> getPaymentAccounts() throws AttributesNotFound, ErrorType {

        return paymentAccountService.findAll();

        //  return paymentAccountService.findAll();
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PaymentAccount> getPaymentAccounts(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Sort sort = new Sort(Sort.Direction.DESC, "invPaymentAccountUpdateDate");
        Pageable pageable= new PageRequest(page,size, sort);
        return paymentAccountService.findAll(pageable);
        // return paymentAccountService.findAll(pageable);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return paymentAccountService.size();
        //return paymentAccountService.size();
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return paymentAccountService.size(search );

        // return paymentAccountService.size(search);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return paymentAccountService.isExist(id);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PaymentAccount getPaymentAccount(@PathVariable("id") Long id) throws IdNotFound {
        return paymentAccountService.findById(id);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PaymentAccount> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return paymentAccountService.find(search);

        // return paymentAccountService.find(search);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PaymentAccount> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return paymentAccountService.find(search  , page, size);

        //  return paymentAccountService.find(search, pageable);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentAccount add(@RequestBody PaymentAccount paymentAccount) throws IOException {
        return paymentAccountService.save(paymentAccount);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PaymentAccount set(@RequestBody PaymentAccount paymentAccount) throws IOException {
        return paymentAccountService.save(paymentAccount);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PaymentAccount paymentAccount) {

        paymentAccountService.delete(paymentAccount);
    }

    @PreAuthorize("hasRole('PAYMENT_ACCOUNT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        paymentAccountService.delete(id);
    }
}