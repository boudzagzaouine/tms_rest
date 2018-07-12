package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 24/01/2017.
 */
@Controller
@RequestMapping(value = "/promotions/")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Promotion> getPromotions() {
        return promotionService.findAll();
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Promotion> getPromotions(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return promotionService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return promotionService.size();
    }

    @PreAuthorize("hasRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return promotionService.size(search);
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return promotionService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Promotion getPromotion(@PathVariable("id") Long id) throws IdNotFound {
        return promotionService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Promotion> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return promotionService.find(search);
    }

    @PreAuthorize("hasAnyRole('PROMOTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Promotion> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return promotionService.find(search, page, size);
    }

    @PreAuthorize("hasRole('PROMOTION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Promotion add(@RequestBody Promotion promotion) {
        return promotionService.save(promotion);
    }

    @PreAuthorize("hasRole('PROMOTION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Promotion set(@RequestBody Promotion promotion) {
        return promotionService.save(promotion);
    }

    @PreAuthorize("hasRole('PROMOTION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Promotion promotion) {

        promotionService.delete(promotion);
    }

    @PreAuthorize("hasRole('PROMOTION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        promotionService.delete(id);
    }
}
