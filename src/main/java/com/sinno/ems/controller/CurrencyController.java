package com.sinno.ems.controller;

import com.sinno.ems.dto.Currency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 22/12/2016.
 */
@Controller
@RequestMapping(value = "/currencys/")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Currency> getCurrencys() {
        return currencyService.findAll();
    }

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Currency> getCurrencys(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmCurrencyUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return currencyService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return currencyService.size();
    }

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return currencyService.size(search);
    }


    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")

    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return currencyService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Currency getCurrency(@PathVariable("id") Long id) throws IdNotFound {
        return currencyService.findById(id);
    }

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Currency> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return currencyService.find(search);
    }

    @PreAuthorize("hasAnyRole('CURRENCY_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','PRODUCT_VIEW','DEVIS_VIEW','ACCOUNT_INVOICE_VIEW','SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Currency> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return currencyService.find(search, page,size);
    }

    @PreAuthorize("hasRole('CURRENCY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Currency add(@RequestBody Currency orderType) {
        return currencyService.save(orderType);
    }

    @PreAuthorize("hasRole('CURRENCY_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Currency set(@RequestBody Currency orderType) {
        return currencyService.save(orderType);
    }

    @PreAuthorize("hasRole('CURRENCY_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Currency orderType) {

        currencyService.delete(orderType);
    }

    @PreAuthorize("hasRole('CURRENCY_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        currencyService.delete(id);
    }
}
