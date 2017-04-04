package com.sinno.ems.controller;

import com.sinno.ems.dto.Color;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ColorService;
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
@RequestMapping(value = "/colors/")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @PreAuthorize("hasAnyRole('COLOR_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Color> getColors() {
        return colorService.findAll();
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Color> getColors(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return colorService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return colorService.size();
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return colorService.size(search);
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return colorService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Color getColor(@PathVariable("id") Long id) throws IdNotFound {
        return colorService.findById(id);
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Color> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return colorService.find(search);
    }

    @PreAuthorize("hasAnyRole('COLOR_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Color> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return colorService.find(search, pageable);
    }

    @PreAuthorize("hasRole('COLOR_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Color add(@RequestBody Color color) {
        return colorService.save(color);
    }

    @PreAuthorize("hasRole('COLOR_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Color set(@RequestBody Color color) {
        return colorService.save(color);
    }

    @PreAuthorize("hasRole('COLOR_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Color color) {

        colorService.delete(color);
    }

    @PreAuthorize("hasRole('COLOR_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        colorService.delete(id);
    }
}