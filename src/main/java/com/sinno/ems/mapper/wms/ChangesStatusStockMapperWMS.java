package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.StkStock;
import com.sinno.wms.crud.model.cst.ChangesStatusMaterial;

/**
 * Created by TM161 on 31/05/2016.
 */
public class ChangesStatusStockMapperWMS {
    private ChangesStatusStockMapperWMS() {
    }

    public static ChangesStatusMaterial toModel(StkStock stock, String operation) {
        if (stock == null) {
            return null;
        }
        ChangesStatusMaterial changesStatusMaterial = new ChangesStatusMaterial();
        if (stock.getStkContainer() != null) {
            changesStatusMaterial.setWarehouseCode(stock.getStkContainer().getWrhWarehouse().getWrhWarehouseCode());
            changesStatusMaterial.setContainerNo(stock.getStkContainer().getStkContainerCode());
        }
        if (stock.getPdtProduct() != null) {
            changesStatusMaterial.setProductCode(stock.getPdtProduct().getPdtProductCode());
            changesStatusMaterial.setShelfLife((double) stock.getPdtProduct().getPdtProductDaysOfLife());
        }
        changesStatusMaterial.setLotCode(stock.getStkStockLot());
        changesStatusMaterial.setSerialNo(stock.getStkStockSerialNo());
        if (stock.getOwnOwner() != null) {
            changesStatusMaterial.setOwnerCode(stock.getOwnOwner().getOwnOwnerCode());
        }
        if (stock.getPrmBlockType() != null) {
            changesStatusMaterial.setStatusCode(stock.getPrmBlockType().getPrmBlockTypeCode());
        }
        changesStatusMaterial.setOperation(operation);
        changesStatusMaterial.setQuality(stock.getStkStockQuality());
        changesStatusMaterial.setBestBeforeDate(stock.getStkStockDluo());
        //TODO changesStatusMaterial.setComment(stock.get);
        if (stock.getPrmColor() != null) {
            changesStatusMaterial.setColorCode(stock.getPrmColor().getPrmColorCode());
        }
        return changesStatusMaterial;
    }
}
