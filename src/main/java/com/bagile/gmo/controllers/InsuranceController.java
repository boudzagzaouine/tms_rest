package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Insurance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.InsuranceService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/insurances")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

  //  @GetMapping(value = "getVehicle/{idVehicle}")
    @RequestMapping(method = RequestMethod.GET, value = "/getVehicle/{idVehicle}")
    @ResponseBody
    public Insurance getvehicule(@PathVariable Long idVehicle){

        return insuranceService.findByPatrimony(idVehicle);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Insurance> getInsurances() throws AttributesNotFound, ErrorType {
        return insuranceService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Insurance> getInsurances(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return insuranceService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return insuranceService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return insuranceService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return insuranceService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Insurance getInsurance(@PathVariable("id") Long id) throws IdNotFound {
        return insuranceService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Insurance> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return insuranceService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Insurance> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return insuranceService.find(search, page, size);
    }
    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Insurance add(@RequestBody Insurance insurance) {
        return insuranceService.save(insurance);
    }
    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Insurance set(@RequestBody Insurance insurance) {


        return insuranceService.save(insurance);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Insurance insurance) {
        insuranceService.delete(insurance);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        insuranceService.delete(id);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        insuranceService.deleteAll (Arrays.asList(ids));
    }
   /* @RequestMapping(method = RequestMethod.GET, value = "/findAvailable")
    @ResponseBody
    public List<Insurance> findAvailableInsurances() throws AttributesNotFound, ErrorType {
        return insuranceService.findAvailableInsurances ();
    }*/
}
