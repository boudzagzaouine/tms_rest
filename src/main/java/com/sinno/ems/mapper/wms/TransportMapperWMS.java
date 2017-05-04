package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.TrpTransport;
import com.sinno.wms.crud.model.car.Carriers;

public class TransportMapperWMS {


    private TransportMapperWMS() {

    }


    public static Carriers toModel(TrpTransport trpTransport, String operation) {
        Carriers carriers = new Carriers();
        if (null == trpTransport) {
            return null;
        }
        carriers.setCarrierCode(trpTransport.getTrpTransportCode());
        carriers.setCarrierName(trpTransport.getTrpTransportName());
        carriers.setDescription(trpTransport.getTrpTransportDescription());
        if (null != trpTransport.getPrmContact()) {
            carriers.setContact(trpTransport.getPrmContact().getPrmContactName());
        }
        carriers.setAttribute1(trpTransport.getTrpTransportVariable1());
        carriers.setAttribute2(trpTransport.getTrpTransportVariable2());
        carriers.setAttribute3(trpTransport.getTrpTransportVariable3());
        carriers.setAttribute4(trpTransport.getTrpTransportVariable4());
        carriers.setAttribute5(trpTransport.getTrpTransportVariable5());
        carriers.setAttribute6(trpTransport.getTrpTransportVariable6());
        carriers.setAttribute7(trpTransport.getTrpTransportVariable7());
        carriers.setAttribute8(trpTransport.getTrpTransportVariable8());
        carriers.setAttribute9(trpTransport.getTrpTransportVariable9());
        carriers.setAttribute10(trpTransport.getTrpTransportVariable10());
        carriers.setOperation(operation);
        return carriers;
    }
}
