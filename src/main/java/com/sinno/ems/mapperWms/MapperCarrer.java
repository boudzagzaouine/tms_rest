package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.Account;
import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Owner;
import com.sinno.ems.dto.Transport;
import com.sinno.wms.crud.modelbasic.carriers.Carrier;

import java.math.BigDecimal;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperCarrer {

    public static com.sinno.wms.crud.modelbasic.carriers.Carrier convertToWmsDto(Transport t) {

        com.sinno.wms.crud.modelbasic.carriers.Carrier car = new com.sinno.wms.crud.modelbasic.carriers.Carrier();

        if (null != t.getDescription())
            car.setDescription(t.getDescription());
        if (null != t.getAddress() && null != t.getAddress().getLine1() && null != t.getAddress().getLine2())
            car.setAddress(t.getAddress().getLine1() + " " + t.getAddress().getLine2());
        if (null != t.getAddress() && null != t.getAddress().getCode())
            car.setCarrier_Code(t.getCode());
        if (null != t.getContact() && null != t.getAddress().getCountry())
            car.setContact_Name(t.getContact().getName());
        if (null != t.getAddress() && null != t.getAddress().getCountry())
            car.setCountry(t.getAddress().getCountry());
        if (null != t.getAddress() && null != t.getAddress().getState())
            car.setState(t.getAddress().getState());
        if (null != t.getAddress() && null != t.getAddress().getContactTel())
            car.setTelephone(t.getAddress().getContactTel());
        if (null != t.getAddress() && null != t.getAddress().getZip())
            car.setPostal_Code(t.getAddress().getZip());
        if (null != t.getSiret())
            car.setCif(t.getSiret().toString());
        if (null != t.getAddress() && null != t.getAddress().getCity())
            car.setCity(t.getAddress().getCity());
        if (null != t.getContact() && null != t.getContact().getFax())
            car.setFax(t.getContact().getFax());

       /*   car.setExtension();  */


        return car;

    }

    public static Transport convertToEmsDto(Transport transport,com.sinno.wms.crud.modelbasic.carriers.Carrier c) {


        if (null != c.getCarrier_Code())
            transport.setCode(c.getCarrier_Code());
        if (null != c.getDescription())
            transport.setDescription(c.getDescription());
        if (null != c.getCif())
            transport.setSiret(new BigDecimal(c.getCif()));

        if (null != c.getAddress()) {
            Address a = new Address();
            a.setLine1(c.getAddress_line1());
            a.setLine2(c.getAddress_line2());
            transport.setAddress(a);
        }
        if(null!=c.getComment())
        transport.setComment(c.getComment());
        if(null!=c.getCarrier_name())
        transport.setName(c.getCarrier_name());

        return transport;

    }
}
