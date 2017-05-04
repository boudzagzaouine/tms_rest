package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.CmdAccount;
import com.sinno.wms.crud.model.acc.CustomerHeader;

/**
 * Created by CODING on 05/05/2016.
 */
public class AccountMapperWMS {
    private AccountMapperWMS() {
    }

    public static CustomerHeader toModel(CmdAccount account, String operation){
        CustomerHeader customerHeaderModel = new CustomerHeader();

        customerHeaderModel.setOperation(operation);
        customerHeaderModel.setAccountCode(account.getCmdAccountCode());
        customerHeaderModel.setName(account.getCmdAccountName());
        customerHeaderModel.setAddrName(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAddressCode());
        customerHeaderModel.setAddrLine1(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAddressLine1());
        customerHeaderModel.setAddrLine2(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAdressLine2());
        customerHeaderModel.setCity(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAddressCity());

        customerHeaderModel.setCountry(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAddressCountry());
        customerHeaderModel.setZip(account.getAdrAddressByCmdAccountDeliveryAddressId().getAdrAddressZip());
        customerHeaderModel.setContactName(account.getPrmContact().getPrmContactName());
        customerHeaderModel.setContactTel(account.getPrmContact().getPrmContactTel1());
        customerHeaderModel.setContactExt(account.getPrmContact().getPrmContactTel2());
        customerHeaderModel.setContactFax(account.getPrmContact().getPrmContactFax());
        customerHeaderModel.setComment(account.getCmdAccountComment());
        customerHeaderModel.setCarrierCode(account.getTrpTransport().getTrpTransportCode());
        customerHeaderModel.setDescription(account.getTrpTransport().getTrpTransportDescription());
        //TODO customerHeaderModel.setTerms(account.getTerms());
        customerHeaderModel.setCompanyCode(account.getCmdCompany().getCmdCompanyCode());
        /// 0 1 ..?
        customerHeaderModel.setAllowSplit(false);
        customerHeaderModel.setActiveFusion(true);

        customerHeaderModel.setAttribute1(account.getCmdAccountVariable1());
        customerHeaderModel.setAttribute2(account.getCmdAccountVariable2());
        customerHeaderModel.setAttribute3(account.getCmdAccountVariable3());
        customerHeaderModel.setAttribute4(account.getCmdAccountVariable4());
        customerHeaderModel.setAttribute5(account.getCmdAccountVariable5());
        customerHeaderModel.setAttribute6(account.getCmdAccountVariable6());
        customerHeaderModel.setAttribute7(account.getCmdAccountVariable7());
        customerHeaderModel.setAttribute8(account.getCmdAccountVariable8());
        customerHeaderModel.setAttribute9(account.getCmdAccountVariable9());
        customerHeaderModel.setAttribute10(account.getCmdAccountVariable10());

        return customerHeaderModel;
    }
}
