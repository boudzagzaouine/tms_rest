package com.sinno.ems.controller;

import com.sinno.ems.dto.UserBox;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.UserBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userBoxs/")
public class UserBoxController {

    @Autowired
    private UserBoxService userBoxService;

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<UserBox> getUserBoxs() {
        return userBoxService.findAll();
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<UserBox> getUserBoxs(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmUserBoxUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return userBoxService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return userBoxService.size();
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return userBoxService.size(search);
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return userBoxService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public UserBox getUserBox(@PathVariable("id") Long id) throws IdNotFound {
        return userBoxService.findById(id);
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<UserBox> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return userBoxService.find(search);
    }

    @PreAuthorize("hasAnyRole('BOX_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<UserBox> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return userBoxService.find(search, pageable);
    }

    @PreAuthorize("hasRole('BOX_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserBox add(@RequestBody UserBox userBox) {
        return userBoxService.save(userBox);
    }

    @PreAuthorize("hasRole('BOX_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserBox set(@RequestBody UserBox userBox) {
        return userBoxService.save(userBox);
    }

    @PreAuthorize("hasRole('BOX_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody UserBox userBox) {

        userBoxService.delete(userBox);
    }

    @PreAuthorize("hasRole('BOX_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        userBoxService.delete(id);
    }
}