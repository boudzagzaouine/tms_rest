package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ReceptionStockArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptionStockArcs/")
public class ReceptionStockArcController {

    @Autowired
    private ReceptionStockArcService receptionStockArcService;

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ReceptionStockArc> getReceptionStockArcs() {
        return receptionStockArcService.findAll();
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionStockArc> getReceptionStockArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return receptionStockArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return receptionStockArcService.size();
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return receptionStockArcService.size(search);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionStockArcService.isExist(id);
    }    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ReceptionStockArc getReceptionStockArc(@PathVariable("id") Long id) throws IdNotFound {
        return receptionStockArcService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionStockArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return receptionStockArcService.find(search);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionStockArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return receptionStockArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStockArc add(@RequestBody ReceptionStockArc receptionStockArc) {
        return receptionStockArcService.save(receptionStockArc);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStockArc set(@RequestBody ReceptionStockArc receptionStockArc) {
        return receptionStockArcService.save(receptionStockArc);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionStockArc receptionStockArc) {

        receptionStockArcService.delete(receptionStockArc);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionStockArcService.delete(id);
    }
}