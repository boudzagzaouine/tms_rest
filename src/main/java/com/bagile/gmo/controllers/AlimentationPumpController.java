package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.AlimentationPump;
import com.bagile.gmo.dto.FuelPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.AlimentationPumpService;
import com.bagile.gmo.services.FuelPumpService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/alimentationPumps")
public class AlimentationPumpController {
    private final AlimentationPumpService alimentationPumpService;
    private final FuelPumpService fuelPumpService;

    public AlimentationPumpController(AlimentationPumpService alimentationPumpService,
                                      FuelPumpService fuelPumpService) {
        this.alimentationPumpService = alimentationPumpService;
        this.fuelPumpService=fuelPumpService;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<AlimentationPump> getAlimentationPumps() {
        return alimentationPumpService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AlimentationPump> getAlimentationPumps(@RequestParam int page, @RequestParam int size) {
        return alimentationPumpService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return alimentationPumpService.size();
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return alimentationPumpService.size(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return alimentationPumpService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public AlimentationPump getAlimentationPump(@PathVariable("id") Long id) throws IdNotFound {
        return alimentationPumpService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AlimentationPump> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return alimentationPumpService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AlimentationPump> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return alimentationPumpService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AlimentationPump add(@RequestBody AlimentationPump alimentationPump) throws IdNotFound, AttributesNotFound, ErrorType, CustomException, IOException {
        return alimentationPumpService.save(alimentationPump);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AlimentationPump set(@RequestBody AlimentationPump alimentationPump) throws AttributesNotFound, ErrorType, IdNotFound, CustomException, IOException {
        FuelPump fuelPump ;
        BigDecimal quantityAlimentation,quantityfuelpump,res;
        fuelPump = fuelPumpService.findById(alimentationPump.getFuelPump().getId());
        quantityfuelpump=fuelPump.getQuantity();
        quantityAlimentation=alimentationPump.getQuantity();
        res=quantityfuelpump.add(quantityAlimentation) ;
        fuelPump.setQuantity(res);
        fuelPumpService.save(fuelPump);

        return alimentationPumpService.save(alimentationPump);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AlimentationPump alimentationPump) {
        alimentationPumpService.delete(alimentationPump);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        alimentationPumpService.delete(id);
    }



    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        alimentationPumpService.deleteAll (Arrays.asList(ids));
    }

}
