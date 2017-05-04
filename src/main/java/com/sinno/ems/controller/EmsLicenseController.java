package com.sinno.ems.controller;

import com.sinno.ems.entities.EmsLicense;
import com.sinno.ems.service.EmsLicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 28/11/2016.
 */
@Controller
@RequestMapping(value = "/emsLicenses/")
public class EmsLicenseController {
    @Autowired
    private EmsLicenceService emsLicenceService;
    @PreAuthorize("hasRole('EMS_LICENSE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<EmsLicense> getLicenses() {
        return emsLicenceService.findAll();
    }

    @PreAuthorize("hasRole('EMS_LICENSE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<EmsLicense> getLicenses(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return emsLicenceService.findAll(pageable);
    }

    @PreAuthorize("hasRole('EMS_LICENSE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return emsLicenceService.size();
    }

    @PreAuthorize("hasRole('EMS_LICENSE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmsLicense add(@RequestBody EmsLicense edi) {
        return emsLicenceService.save(edi);
    }

    @PreAuthorize("hasRole('EMS_LICENSE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmsLicense set(@RequestBody EmsLicense edi) {
        return emsLicenceService.save(edi);
    }

    @PreAuthorize("hasRole('EMS_LICENSE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody EmsLicense edi) {

        emsLicenceService.delete(edi);
    }

    
}
