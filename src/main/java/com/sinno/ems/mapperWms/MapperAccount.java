package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.Account;
import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Company;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperAccount {


    public static com.sinno.wms.crud.modelbasic.accounts.Account convertToWmsDto(Account a) {

        com.sinno.wms.crud.modelbasic.accounts.Account acc = new com.sinno.wms.crud.modelbasic.accounts.Account();


        if (null != a.getCompany() && null != a.getCompany().getCode())
            acc.setCustomer_company(a.getCompany().getCode());

        if (null != a.getCode())
            acc.setAccount_code(a.getCode());

        if (null != a.getAddressByAccountDeliveryAddress() && null != a.getAddressByAccountDeliveryAddress().getCode() && null != a.getAddressByAccountDeliveryAddress().getLine1())
            acc.setAddress(a.getAddressByAccountDeliveryAddress().getCode() + " " + a.getAddressByAccountDeliveryAddress().getLine1());

        if (null != a.getAddressByAccountDeliveryAddress() && null != a.getAddressByAccountDeliveryAddress().getCity())
            acc.setCity(a.getAddressByAccountDeliveryAddress().getCity());

        if (null != a.getAddressByAccountDeliveryAddress() && null != a.getAddressByAccountDeliveryAddress().getCountry())
            acc.setCountry(a.getAddressByAccountDeliveryAddress().getCountry());

        if (null != a.getDescription())
            acc.setDescription(a.getDescription());

        if (null != a.getAddressByAccountDeliveryAddress() && null != a.getAddressByAccountDeliveryAddress().getState())
            acc.setState(a.getAddressByAccountDeliveryAddress().getState());
        if (null != a.getAddressByAccountDeliveryAddress() && null != a.getAddressByAccountDeliveryAddress().getContactTel())
            acc.setTelephone(a.getAddressByAccountDeliveryAddress().getContactTel());

        if (null != a.getTransport() && null != a.getTransport().getCode())
            acc.setCarrier_code(a.getTransport().getCode());

        if (null != a.getContact() && null != a.getContact().getFax())
            acc.setFax(a.getContact().getFax());

        if(null!=a.getContact()&&null!=a.getContact().getSurName())
            acc.setContact_surname(a.getContact().getSurName());

        if(null!=a.getOwner())
            acc.setOwner_code(a.getOwner().getCode());
       /* acc.setExtension(); */


        return acc;
    }

    public static Account convertToEmsDto(Account accountt,com.sinno.wms.crud.modelbasic.accounts.Account a) {

        Account account = new Account();

        if (null != a.getAccount_code())
            account.setCode(a.getAccount_code());

        if (null != a.getDescription())
            account.setDescription(a.getDescription());

        if (null != a.getAddress()) {
            Address b = new Address();
            b.setLine1(a.getAddress_line1());
            b.setLine2(a.getAddress_line2());
            account.setAddressByAccountDeliveryAddress(b);}

        if(null!=a.getDescription())
        account.setComment(a.getCommentaire());
        if(null != a.getActive())
        account.setActive(a.getActive());
        if(null != a.getAccount_code())
        account.setName(a.getAccount_name());

        //   account.setAddressByAccountDeliveryAddress(new Address(a.get  ) );
        //   account.setCompany(a.getCustomer_company());


        return account;

    }

}