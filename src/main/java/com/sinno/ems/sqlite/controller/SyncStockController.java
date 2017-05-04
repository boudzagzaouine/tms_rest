package com.sinno.ems.sqlite.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.sqlite.service.SyncStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Enissay on 17/11/2016.
 */
@Controller
@RequestMapping(value = "/syncStock/")
public class SyncStockController {
    @Autowired
    private SyncStockService syncStockService;

    @RequestMapping(method = RequestMethod.GET, value = "/sycStock")
    @ResponseBody
    public void syncStocks() throws AttributesNotFound, ProductControls, ErrorType {
        syncStockService.syncStocks();
    }

}