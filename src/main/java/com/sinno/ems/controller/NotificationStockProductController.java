package com.sinno.ems.controller;

import com.sinno.ems.service.NotificationStockProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Enissay on 07/10/2016.
 */
@Controller
@RequestMapping(value = "/notificationStockProducts/")
public class NotificationStockProductController {
    @Autowired
    private NotificationStockProductService notificationStockProductService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<NotificationStockProduct> getNotificationStockProducts() {
        return notificationStockProductService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<NotificationStockProduct> getNotificationStockProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return notificationStockProductService.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return notificationStockProductService.size();
    }

}
