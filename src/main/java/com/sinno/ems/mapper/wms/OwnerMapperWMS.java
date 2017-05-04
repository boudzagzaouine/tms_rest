package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.OwnOwner;
import com.sinno.wms.crud.model.own.Owners;

public class OwnerMapperWMS {

    private OwnerMapperWMS() {
        // TODO Auto-generated constructor stub
    }


    public static Owners toModel(OwnOwner ownOwner, String operation) {
        if (null == ownOwner) {
            return null;
        }
        Owners own = new Owners();
        own.setOwnerCode(ownOwner.getOwnOwnerCode());
        own.setDescription(ownOwner.getOwnOwnerDescription());
        own.setSiret(ownOwner.getOwnOwnerSiret());
        own.setAddrLine1(ownOwner.getAdrAddress().getAdrAddressLine1());
        own.setAddrLine2(ownOwner.getAdrAddress().getAdrAdressLine2());
        own.setCity(ownOwner.getAdrAddress().getAdrAddressCity());
        own.setState(ownOwner.getAdrAddress().getAdrAddressState());
        own.setCountry(ownOwner.getAdrAddress().getAdrAddressCountry());
        own.setZip(ownOwner.getAdrAddress().getAdrAddressZip());
        own.setContactName(ownOwner.getOwnOwnerName());
        own.setContactTel(ownOwner.getOwnOwnerPrimaryTel());
        own.setContactExt(ownOwner.getOwnOwnerSecondaryTel());

        own.setComment(ownOwner.getOwnOwnerComment());


        own.setAttribute1(ownOwner.getOwnOwnerVariable1());
        own.setAttribute2(ownOwner.getOwnOwnerVariable2());
        own.setAttribute3(ownOwner.getOwnOwnerVariable3());
        own.setAttribute4(ownOwner.getOwnOwnerVariable4());
        own.setAttribute5(ownOwner.getOwnOwnerVariable5());
        own.setAttribute6(ownOwner.getOwnOwnerVariable6());
        own.setAttribute7(ownOwner.getOwnOwnerVariable7());
        own.setAttribute8(ownOwner.getOwnOwnerVariable8());
        own.setAttribute9(ownOwner.getOwnOwnerVariable9());
        own.setAttribute10(ownOwner.getOwnOwnerVariable10());
        own.setOperation(operation);
        return own;

    }
}
