package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.PdtAlias;
import com.sinno.wms.crud.model.ali.Alias;

public class AliasMapperWMS {

    private AliasMapperWMS() {  }


    public static Alias toModel(PdtAlias pdtAlias,String code, String operation) {
        Alias alias = new Alias();
        if(null == pdtAlias){
            return null;
        }
        if(!code.equals("")) {
            alias.setAliasCode(code);
            alias.setNewAliasCode(pdtAlias.getPdtAliasEanCode());
        }
        else{
            alias.setAliasCode(pdtAlias.getPdtAliasEanCode());
        }
        alias.setProductCode(pdtAlias.getPdtProduct().getPdtProductCode());
        alias.setOwnerCode(pdtAlias.getOwnOwner().getOwnOwnerCode());
        alias.setUomCode(pdtAlias.getPdtUom().getPdtUomCode());
        alias.setOperation(operation);
        return alias;
    }
}
