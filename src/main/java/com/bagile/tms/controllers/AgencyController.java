package com.bagile.tms.controllers;

import com.bagile.tms.dto.Agency;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/agencies/")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @GetMapping(value = "/list")
    public List<Agency> getAgencies() throws AttributesNotFound, ErrorType {
        return agencyService.findAll();
    }

    @GetMapping(value = "/listPage")
    public List<Agency> getAgencies(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return agencyService.findAll(page, size);
        // return agencyService.findAll(pageable);
    }

    @GetMapping(value = "/size")
    public Long size() throws AttributesNotFound, ErrorType {
        return agencyService.size();
    }

    @GetMapping("/sizeSearch")
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return agencyService.size(search);
    }

    @GetMapping(value = "/exist")
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return agencyService.isExist(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Agency getAgency(@PathVariable("id") Long id) throws IdNotFound {
        return agencyService.findById(id);
    }

    @GetMapping(value = "/search")
    public List<Agency> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return agencyService.find(search);
    }

    @GetMapping(value = "/searchPage")
    public List<Agency> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return agencyService.find(search, page, size);
    }

    @PostMapping(value = "/save")
    public Agency add(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @PutMapping(value = "/save")
    public Agency set(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @PostMapping(value = "/delete")
    public void delete(@RequestBody Agency agency) {
        agencyService.delete(agency);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        agencyService.delete(id);
    }
}