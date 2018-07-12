package com.sinno.ems.mapperWms;

import java.math.BigDecimal;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperReceptionLine {


    public static com.sinno.wms.crud.modelbasic.receptions.ReceptionLine convertToWmsDto(com.sinno.ems.dto.ReceptionLine receptionLine) {

        com.sinno.wms.crud.modelbasic.receptions.ReceptionLine rcp = new com.sinno.wms.crud.modelbasic.receptions.ReceptionLine();

        if (null != receptionLine.getUom() && null != receptionLine.getUom().getCode())
            rcp.setUom(receptionLine.getUom().getCode());

        if (null != receptionLine.getQuantity())
            rcp.setQuantity(receptionLine.getQuantity());
        if (null != receptionLine.getQuantityReceived())
            rcp.setReceivedQuantity(receptionLine.getQuantityReceived());
        else
            rcp.setReceivedQuantity(BigDecimal.ZERO);

        if (null != receptionLine.getProduct() && null != receptionLine.getProduct().getCode())
            rcp.setProduct_code(receptionLine.getProduct().getCode());
        if (null != receptionLine.getLot())
            rcp.setLot(receptionLine.getLot());
        if (null != receptionLine.getLineNumber())
            rcp.setLine(receptionLine.getLineNumber());
        if (null != receptionLine.getReception() && null != receptionLine.getReception().getCode())
            rcp.setReception_code(receptionLine.getReception().getCode());
        if (null != receptionLine.getDlc())
            rcp.setExpiration_date(receptionLine.getDlc());


        return rcp;

    }

    public static com.sinno.ems.dto.ReceptionLine convertToEmsDto(com.sinno.ems.dto.ReceptionLine rl, com.sinno.wms.crud.modelbasic.receptions.ReceptionLine r) {


        if (null != r.getQuantity())
            rl.setQuantity(r.getQuantity());
        rl.setLineNumber(r.getLine());
        if (null != r.getLot())
            rl.setLot(r.getLot());
        if (null != r.getExpiration_date())
            rl.setDlc(r.getExpiration_date());
        if (null != r.getExpiration_date())
            rl.setDlc(r.getExpiration_date());

        if (null != r.getReception_code()) {
            Reception rec = new Reception();
            rec.setCode(r.getReception_code());
            rl.setReception(rec);
        }




 /*     rl.setDescription();
        rl.setReceptionDate();
        rl.setReceptionDate();
        rl.setReception();
        rl.setBlockedQuantity();
        rl.setBlockType();
        rl.setColor();
        rl.setDluo();
        rl.setLocation();
        rl.setOwner();
        rl.setProduct();
        rl.setQuality();
        rl.setQuantityClosed();
        rl.setQuantityReceived();
        rl.setBlockedQuantity();
        rl.setWarehouse();
        rl.setWeight();
        rl.setReceptionLineArcs();
        rl.setReceptionStockArcs();
        rl.setReceptionStocks();
        rl.setUomReceived();         */


        return rl;

    }
}
