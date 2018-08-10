package com.bagile.tms.controllers;

import com.bagile.tms.dto.Organisation;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Enissay on 14/04/2016.
 */
@Controller
@RequestMapping(value = "/organisation/")

public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;

    //@PreAuthorize("hasRole('ORGANISATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Organisation set(@RequestBody Organisation organisation) {
        return organisationService.save(organisation);
    }

    //@PreAuthorize("hasRole('ORGANISATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Organisation getOrganisation(@PathVariable("id") Long id) throws IdNotFound {
        return organisationService.findById(id);
    }

}
