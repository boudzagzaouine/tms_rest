package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.*;

/**
 * Created by Administrateur on 11/10/2016.
 */

public class MapperReception {


    public static com.sinno.wms.crud.modelbasic.receptions.Reception convertToWmsDto(Reception r) {

        com.sinno.wms.crud.modelbasic.receptions.Reception rec = new com.sinno.wms.crud.modelbasic.receptions.Reception();

        if (null != r.getCode())
            rec.setReceptionCode(r.getCode());
        if (null != r.getReceptionDate())
            rec.setArrival_date(r.getReceptionDate());
        if (null != r.getDescription())
            rec.setDescription(r.getDescription());
        if (null != r.getOwner() && null != r.getOwner().getCode())
            rec.setOwner_code(r.getOwner().getCode());
        if (null != r.getSupplier() && null != r.getSupplier().getCode())
            rec.setSupplier_code(r.getSupplier().getCode());
        if (null != r.getExpectedDate())
            rec.setExpected_date(r.getExpectedDate());
        if (null != r.getLocation() && null != r.getLocation().getCode())
            rec.setDock_code(r.getLocation().getCode());
        if (null != r.getTransport() && null != r.getTransport().getCode())
            rec.setCarrier_code(r.getTransport().getCode());
        if (null != r.getOrderType() && null != r.getOrderType().getCode()) {
            if (1L == r.getOrderType().getId())
                rec.setReception_type_code("STANDARD ");
            else if (10010L == r.getOrderType().getId()) {
                rec.setReception_type_code("RETURN ");
            }
        }
        if (null != r.getRemarks())
            rec.setDocument(r.getRemarks());

        //   rec.setDoor_code();


        return rec;

    }

    public static Reception convertToEmsDto(Reception reception, com.sinno.wms.crud.modelbasic.receptions.Reception r) {


        if (null != r.getReceptionCode())
            reception.setCode(r.getReceptionCode());
        if (null != r.getDescription())
            reception.setDescription(r.getDescription());
        if (null != r.getExpected_date())
            reception.setExpectedDate(r.getExpected_date());
        if (null != r.getArrival_date())
            reception.setReceptionDate(r.getArrival_date());
        if (null != r.getDocument())
            reception.setRemarks(r.getDocument());


/*
        if (null != r.getOwner_code()) {
            Owner o = new Owner();
            o.setCode(r.getOwner_code());
            reception.setOwner(o);
        }

        if (null != r.getSupplier_code()) {
            Supplier s = new Supplier();
            s.setCode(r.getSupplier_code());
            reception.setSupplier(s);
        }

        if (null !=r.getDock_code()) {
            Location l = new Location();
            l.setCode(r.getDock_code());
            reception.setLocation(l);
        }

        if (null !=r.getCarrier_code()) {
            Transport t = new Transport();
            t.setCode(r.getCarrier_code());
            reception.setTransport(t);
        }


        if (null !=r.getReception_type_code()){
            OrderType o = new OrderType();
            o.setCode(r.getReception_type_code());
            reception.setOrderType(o);
        }



    /*  reception.setImmatriculation();
        reception.setWarehouse();
        reception.setOwner();
        reception.setUserBoxCreationDate();
        reception.setDelivery();
        reception.setAccount();
        reception.setAddress();
        reception.setTransfertCode();
        reception.setTransport();
        reception.setTransportContact();
        reception.setTransportTel();
        reception.setOrderType();     */


        return reception;

    }
}
