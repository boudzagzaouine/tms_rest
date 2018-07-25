package com.bagile.tms.controllers;

import com.bagile.tms.dto.PoliceAssurance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.PoliceInsuranceService;
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
 * Created by bouzi on 4/4/2017.
 */
@Controller
@RequestMapping(value = "/naturePoliceInsurances/")
public class PoliceInsuranceController {
    @Autowired
    private PoliceInsuranceService policeInsuranceService;

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<PoliceAssurance> getPoliceAssurances() {
        return policeInsuranceService.findAll();
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<PoliceAssurance> getPoliceAssurances(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC/*, "prmColorUpdateDate"*/);
        Pageable pageable = PageRequest.of(page, size,sort);
        return policeInsuranceService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return policeInsuranceService.size();
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return policeInsuranceService.size(search);
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return policeInsuranceService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public PoliceAssurance getPoliceAssurance(@PathVariable("id") Long id) throws IdNotFound {
        return policeInsuranceService.findById(id);
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<PoliceAssurance> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return policeInsuranceService.find(search);
    }

    @PreAuthorize("hasAnyRole('POLICEINSURANCE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<PoliceAssurance> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return policeInsuranceService.find(search, pageable);
    }

    @PreAuthorize("hasRole('POLICEINSURANCE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PoliceAssurance add(@RequestBody PoliceAssurance policeAssurance) {
        return policeInsuranceService.save(policeAssurance);
    }

    @PreAuthorize("hasRole('POLICEINSURANCE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PoliceAssurance set(@RequestBody PoliceAssurance policeAssurance) {
        return policeInsuranceService.save(policeAssurance);
    }

    @PreAuthorize("hasRole('POLICEINSURANCE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody PoliceAssurance policeAssurance) {

        policeInsuranceService.delete(policeAssurance);
    }

    @PreAuthorize("hasRole('POLICEINSURANCE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        policeInsuranceService.delete(id);
    }
}
