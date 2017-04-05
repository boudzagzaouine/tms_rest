package com.sinno.ems.controller;

import com.sinno.ems.dto.Badge;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.BadgeService;
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
 * Created by khalil on 31/03/2017.
 */
@Controller
@RequestMapping(value="/badges/")
public class BadgeController {
    @Autowired
   private BadgeService badgeService;
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Badge> getBadges() {
        return badgeService.findAll();
    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Badge> getBadges(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmColorUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return badgeService.findAll(pageable);

    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return badgeService.size();
    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return badgeService.size(search);
    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return badgeService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Badge getBadge(@PathVariable("id") Long id) throws IdNotFound {
        return badgeService.findById(id);
    }
    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Badge> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return badgeService.find(search);
    }

    @PreAuthorize("hasAnyRole('BADGE_VIEW','PURSHASE_ORDER_LINE_VIEW','RECEPTION_LINE_VIEW','SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Badge> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return badgeService.find(search, pageable);
    }
    @PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Badge add(@RequestBody Badge badge) {
        return badgeService.save(badge);
    }
    @PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Badge set(@RequestBody Badge badge) {
        return badgeService.save(badge);
    }
    @PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Badge badge) {

        badgeService.delete(badge);
    }
    @PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        badgeService.delete(id);
    }

}
