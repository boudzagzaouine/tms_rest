package com.sinno.ems.mapperWms;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperSupplier {


    public static com.sinno.wms.crud.modelbasic.suppliers.Supplier convertToWmsDto(Supplier s) {

        com.sinno.wms.crud.modelbasic.suppliers.Supplier sup = new com.sinno.wms.crud.modelbasic.suppliers.Supplier();


        if (null != s.getDescription())
            sup.setDescription(s.getDescription());
        if (null != s.getAddress() && null != s.getAddress().getLine1() && null != s.getAddress().getLine2())
            sup.setAddress_name(s.getAddress().getLine1() + " " + s.getAddress().getLine2());
        if (null != s.getAddress() && null != s.getAddress().getCity())
            sup.setCity(s.getAddress().getCity());
        if (null != s.getContact() && null != s.getContact().getName())
            sup.setContact_name(s.getContact().getName());
        if (null != s.getAddress() && null != s.getAddress().getCountry())
            sup.setCountry(s.getAddress().getCountry());
        if (null != s.getTerms())
            sup.setTerms(s.getTerms());
        if (null != s.getAddress() && null != s.getAddress().getState())
            sup.setState(s.getAddress().getState());
        if (null != s.getCode())
            sup.setSupplier_code(s.getCode());
        if (null != s.getAddress() && null != s.getAddress().getZip())
            sup.setPostal_code(s.getAddress().getZip());
        if (null != s.getContact() && null != s.getContact().getFax())
            sup.setFax(s.getContact().getFax());
        if (null != s.getTransport() && null != s.getTransport().getName())
            sup.setDefault_carrier(s.getTransport().getName());
        if (null != s.getContact() && null != s.getContact().getTel1())
            sup.setTelephone(s.getContact().getTel1());


     /*
        sup.setExtension();
        sup.setCif();
          */


        return sup;

    }

    public static Supplier convertToEmsDto(Supplier supplier, com.sinno.wms.crud.modelbasic.suppliers.Supplier s) {


        if (null != s.getTerms())
            supplier.setTerms(s.getTerms());
        if (null != s.getSupplier_code())
            supplier.setCode(s.getSupplier_code());
        if (null != s.getDescription())
            supplier.setDescription(s.getDescription());
        supplier.setComment(s.getComment());
        supplier.setActive(s.getActive());
        supplier.setComment(s.getComment());
        supplier.setTerms(s.getCondition());



   /*   supplier.setContact();
        supplier.setOwner();
        supplier.setStocks();
        supplier.setReceptions();
        supplier.getSaleOrders();
        supplier.setComment();
        supplier.setActive();
        supplier.setAddress();
        supplier.setStockReserveds();
        supplier.setProducts();
        supplier.setReceptions();
        supplier.setReceptionStocks();
        supplier.setReceptionStockArcs();
        supplier.setReceptionArcs();            */

        return supplier;

    }
}
