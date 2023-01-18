package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportAccountService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportAccountServiceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportAccountServices")
public class TransportAccountServiceController {

    private final TransportAccountServiceService transportAccountServiceService;

    public TransportAccountServiceController(TransportAccountServiceService transportAccountServiceService) {
        this.transportAccountServiceService = transportAccountServiceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportAccountService> getAll() {
        return transportAccountServiceService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportAccountService> getAll(@RequestParam int page, @RequestParam int size) {
        return transportAccountServiceService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportAccountService getOne(@PathVariable("id") Long id) throws IdNotFound {
        return transportAccountServiceService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportAccountServiceService.size();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportAccountServiceService.size(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportAccountServiceService.isExist(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportAccountService> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportAccountServiceService.find(search);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportAccountService> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportAccountServiceService.find(search, page, size);

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportAccountService add(@RequestBody TransportAccountService transportAccountService) {
        return transportAccountServiceService.save(transportAccountService);
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportAccountService set(@RequestBody TransportAccountService transportAccountService) {
        return transportAccountServiceService.save(transportAccountService);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportAccountService transportAccountService) {
        transportAccountServiceService.delete(transportAccountService);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportAccountServiceService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportAccountServiceService.deleteAll (Arrays.asList(ids));
    }

}
