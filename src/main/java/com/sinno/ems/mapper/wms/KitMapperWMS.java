package com.sinno.ems.mapper.wms;


import com.sinno.ems.entities.PdtKit;
import com.sinno.wms.crud.model.Kit;

/**
 * Created by Salah on 03/05/2016.
 */
public class KitMapperWMS {

    private KitMapperWMS() {
    }

    public static Kit toModel(PdtKit pdtKit, String operation) {

        Kit kit = new Kit();
        if (null == pdtKit) {
            return null;
        }
        if (null != pdtKit.getPdtProduct()) {
            kit.setKitProductCode(pdtKit.getPdtProduct().getPdtProductCode());
        }
        if (null != pdtKit.getPdtKitComponent()) {
            kit.setKitProductCode(pdtKit.getPdtKitComponent().getPdtProductCode());
        }
        if (null != pdtKit.getPdtProduct()) {
            kit.setOwnerCode(pdtKit.getPdtProduct().getOwnOwner().getOwnOwnerCode());
        }
        if (null != pdtKit.getPdtKitComponentUom()) {
            kit.setUomCode(pdtKit.getPdtKitComponentUom().getPdtUomCode());
        }
        kit.setQuantity(pdtKit.getPdtKitQuantity().doubleValue());
        kit.setMasterComponent(false);
        kit.setOperation(operation);
        return kit;
    }
}
