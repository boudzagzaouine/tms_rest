package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.*;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperSaleOrder {


    public static com.sinno.wms.crud.modelbasic.saleorders.SaleOrder convertToWmsDto(Delivery s) {

        com.sinno.wms.crud.modelbasic.saleorders.SaleOrder so = new com.sinno.wms.crud.modelbasic.saleorders.SaleOrder();


        if (null != s.getOwner() && null != s.getOwner().getCode()) {
            so.setOwner_code(s.getOwner().getCode());
        }
        if (null != s.getDescription())
            so.setDescription(s.getDescription());
        if (null != s.getAccount() && null != s.getAccount().getCode()) {
            so.setAccount_code(s.getAccount().getCode());
        }
       /* if (null != s.getSupplier() && null != s.getSupplier().getCode()) {
            so.setSupplier_code(s.getSupplier().getCode());
        }*/
        if (null != s.getTransport() && null != s.getTransport().getCode())
            so.setCarrier_code(s.getTransport().getCode());
        if (null != s.getRemarks())
            so.setDocument(s.getRemarks());
        if (null != s.getCode())
            so.setSorder_code(s.getCode());
        if (null != s.getOrderType() && null != s.getOrderType().getCode()) {
            if (10012L == s.getOrderType().getId())
                so.setSorder_type_code("CUSTOMER");
            else if (10015L == s.getOrderType().getId())
                so.setSorder_type_code("RETURN");
        }


      /* so.setDock_code();
        so.setDoor_code();
        so.setRelease_date();
        so.setSource();        */


        return so;

    }

    public static SaleOrder convertToEmsDto(SaleOrder saleOrder, com.sinno.wms.crud.modelbasic.saleorders.SaleOrder s) {


        if (null != s.getDescription())
            saleOrder.setDescription(s.getDescription());
        if (null != s.getDocument())
            saleOrder.setRemarks(s.getDocument());
        if (null != s.getSorder_code())
            saleOrder.setCode(s.getSorder_code());


        if (null != s.getOwner_code()) {
            Owner o = new Owner();
            o.setCode(s.getOwner_code());
            saleOrder.setOwner(o);
        }

        if (null != s.getSupplier_code()) {
            Supplier s1 = new Supplier();
            s1.setCode(s.getSupplier_code());
            saleOrder.setSupplier(s1);
        }

        if (null != s.getAccount_code()) {
            Account a = new Account();
            a.setCode(s.getAccount_code());
            saleOrder.setAccount(a);
        }

        if (null != s.getCarrier_code()) {
            Transport t = new Transport();
            t.setCode(s.getCarrier_code());
            saleOrder.setTransport(t);
        }
        saleOrder.setExpectedDate(s.getRelease_date());

     /*   if (null != s.getSorder_code()) {
            OrderType o = new OrderType();
            o.setCode(s.getSorder_code());
            saleOrder.setOrderType(o);
        }*/


    /*  saleOrder.setOwner();
        saleOrder.setOrderStatus();
        saleOrder.setOwner();
        saleOrder.setExpectedDate();
        saleOrder.setWarehouse();
        saleOrder.setContainers();
        saleOrder.setAddressBySaleOrderDeliveryAddress();
        saleOrder.setAddressBySaleOrderInvoiceAddress();
        saleOrder.setImmatriculation();
        saleOrder.setLines();
        saleOrder.setAccount();
        saleOrder.setStockArcs();
        saleOrder.setSupplier();
        saleOrder.setTransportContact();
        saleOrder.setTransport();
        saleOrder.setTransfertCode();
        saleOrder.setStockReserveds();
        saleOrder.setStocks();           */


        return saleOrder;

    }
}
