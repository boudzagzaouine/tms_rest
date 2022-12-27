package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.importModels.AddressDelivery;
import com.bagile.gmo.services.ActionTypeService;
import com.bagile.gmo.services.AddressService;
import org.elasticsearch.cluster.metadata.AliasAction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/dataExchanges")
public class DataExchangeController {

    private final AddressService addressService;

    public DataExchangeController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/saveAddressDeliverys", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AddressDelivery> saveProducts(@RequestBody List<AddressDelivery> addressDeliveries) throws IdNotFound, ErrorType, AttributesNotFound {
       return  addressService.loadingDataImport(addressDeliveries);

    }

}
