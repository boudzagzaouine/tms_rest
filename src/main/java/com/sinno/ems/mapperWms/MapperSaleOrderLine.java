package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.*;

import java.math.BigDecimal;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperSaleOrderLine {


    public static com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine convertToWmsDto(DeliveryLine deliveryLine) {

        com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine sol = new com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine();

        if (null != deliveryLine.getContainerCode())
            sol.setContainer(deliveryLine.getContainerCode());
        sol.setLine(deliveryLine.getLineNumber());
        if (null != deliveryLine.getLot())
            sol.setLot(deliveryLine.getLot());
        if (null != deliveryLine.getProduct() && null != deliveryLine.getProduct().getCode())
            sol.setProduct_code(deliveryLine.getProduct().getCode());

        if (null != deliveryLine.getOrderedQuantity())
            sol.setQuantity(deliveryLine.getOrderedQuantity());
        if (null != deliveryLine.getQuantityServed())
            sol.setServedQuantity(deliveryLine.getQuantityServed());
        else
            sol.setServedQuantity(BigDecimal.ZERO);

        if (null != deliveryLine.getUom() && null != deliveryLine.getUom().getCode())
            sol.setUom(deliveryLine.getUom().getCode());
        if (null != deliveryLine.getDlc())
            sol.setExpiration_date(deliveryLine.getDlc());
        if (null != deliveryLine.getDelivery() && null != deliveryLine.getDelivery().getCode())
            sol.setSorder_code(deliveryLine.getDelivery().getCode());

        return sol;

    }

    public static SaleOrderLine convertToEmsDto(SaleOrderLine sl, com.sinno.wms.crud.modelbasic.saleorders.SaleOrderLine s) {


        if (null != s.getQuantity())
            sl.setQuantity(s.getQuantity());
        sl.setLineNumber(s.getLine());
        if (null != s.getLot())
            sl.setLot(s.getLot());
        if (null != s.getExpiration_date())
            sl.setDlc(s.getExpiration_date());
        if (null != s.getProduct_code()) {
            Product pr = new Product();
            pr.setCode(s.getProduct_code());
            sl.setProduct(pr);
        }





    /*  sl.setDescription();
        sl.setDate();
        sl.setColor();
        sl.setWarehouse();
        sl.setBlockType();
        sl.setLineNumber();
        sl.setSaleOrderStockArcs();
        sl.setOrderStatus();
        sl.setDlc();
        sl.setDluo();
        sl.setWarehouse();
        sl.setProduct();     */


        return sl;

    }
}
