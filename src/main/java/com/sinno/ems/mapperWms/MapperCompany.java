package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.Company;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperCompany {


    public static com.sinno.wms.crud.modelbasic.companies.Company convertToWmsDto(Company c1) {

        com.sinno.wms.crud.modelbasic.companies.Company comp = new com.sinno.wms.crud.modelbasic.companies.Company();

        if (null != c1.getCode())
            comp.setCompany_code(c1.getCode());
        if (null != c1.getComment())
            comp.setComment(c1.getComment());
        if (null != c1.getSiret())
            comp.setCif(c1.getSiret());
        if (null != c1.getName())
            comp.setName(c1.getName());
        if (null != c1.getOwner())
            comp.setOwner_code(c1.getOwner().getCode());

        return comp;

    }

    public static Company convertToEmsDto(Company emsCompany, com.sinno.wms.crud.modelbasic.companies.Company wmsCompany) {


        if (null != wmsCompany.getCompany_code())
            emsCompany.setCode(wmsCompany.getCompany_code());
        if (null != wmsCompany.getComment())
            emsCompany.setComment(wmsCompany.getComment());
        if (null != wmsCompany.getCif())
            emsCompany.setSiret(wmsCompany.getCif());
        if (null != wmsCompany.getName())
            emsCompany.setName(wmsCompany.getName());

     /*  emsCompany.setUpdateDate();
         emsCompany.setOwner();
         emsCompany.setAccounts();
         emsCompany.setUserBoxCreationDate();

           */


        return emsCompany;

    }
}
