package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/08/2016.
 */
@Controller
@RequestMapping(value = "/printers/")
public class PrinterController {
    @Autowired
    private PrinterService printerService;

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Printer> getPrinters() {
        return printerService.findAll();
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Printer> getPrinters(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return printerService.findAll(pageable);
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return printerService.size();
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return printerService.size(search);
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return printerService.isExist(id);
    }    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Printer getBlockType(@PathVariable("id") Long id) throws IdNotFound {
        return printerService.findById(id);
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Printer> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return printerService.find(search);
    }

    @PreAuthorize("hasRole('PRINTER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Printer> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return printerService.find(search, pageable);
    }

    @PreAuthorize("hasRole('PRINTER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Printer add(@RequestBody Printer blockType) {
        return printerService.save(blockType);
    }

    @PreAuthorize("hasRole('PRINTER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Printer set(@RequestBody Printer blockType) {
        return printerService.save(blockType);
    }

    @PreAuthorize("hasRole('PRINTER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Printer blockType) {

        printerService.delete(blockType);
    }

    @PreAuthorize("hasRole('PRINTER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        printerService.delete(id);
    }
}
