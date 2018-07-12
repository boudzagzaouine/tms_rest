package com.sinno.ems.mapper.wms;

import com.sinno.wms.crud.model.pre.ReceptionOrderHeader;
import com.sinno.wms.crud.model.pre.ReceptionOrderLines;

/**
 * Created by Salah on 31/05/2016.
 */
public class ReceptionOrderMapperWMS {

    private ReceptionOrderMapperWMS(){

       }

       public static ReceptionOrderHeader toModel(RcpReception rcpReception,String operation){
           ReceptionOrderHeader receptionOrderHeader = new ReceptionOrderHeader();
           if (null == rcpReception) {
               return null;
           }
           receptionOrderHeader.setRecOrderCode(rcpReception.getRcpPurshaseOrder().getRcpPurshaseOrderCode());
           receptionOrderHeader.setWarehouseCode(rcpReception.getWrhWarehouse().getWrhWarehouseCode());
           receptionOrderHeader.setSupplierCode(rcpReception.getRcpSupplier().getRcpSupplierCode());
           receptionOrderHeader.setCarrierCode(rcpReception.getTrpTransport().getTrpTransportCode());
           receptionOrderHeader.setDocument(rcpReception.getRcpReceptionOrderCode());
           receptionOrderHeader.setMainTransport(rcpReception.getRcpReceptionImmatriculation());
           receptionOrderHeader.setDescription(rcpReception.getRcpReceptionDescription());
           receptionOrderHeader.setExpectedDate(rcpReception.getRcpReceptionExpectedDate());
           receptionOrderHeader.setContainers(Double.valueOf(rcpReception.getRcpReceptionNumberOfContainers()));
               if(rcpReception.getPrmOrderType().getPrmOrderTypeDescription().equals("commande d'achat")) {
                   receptionOrderHeader.setOrderType("PO");
               }
               else if(rcpReception.getPrmOrderType().getPrmOrderTypeDescription().equals("commande de production")){
                   receptionOrderHeader.setOrderType("PRO");
               }
               else if(rcpReception.getPrmOrderType().getPrmOrderTypeDescription().equals("commande de retour")){
                   receptionOrderHeader.setOrderType("DEV");
               }
           if(rcpReception.getPrmOrderType().getPrmOrderTypeCode().equals("commande de retour")) {
               receptionOrderHeader.setAccountCode(rcpReception.getCmdAccount().getCmdAccountCode());
           }
           receptionOrderHeader.setDoorCode(rcpReception.getLocLocation().getLocLocationCode());
           receptionOrderHeader.setLineCount(rcpReception.getRcpReceptionLines().size());
           receptionOrderHeader.setOperation(operation);
           for (RcpReceptionLine rcpReceptionLine:rcpReception.getRcpReceptionLines()){
               receptionOrderHeader.getList().add(toModel(rcpReceptionLine,operation,"/"));
           }
           return  receptionOrderHeader;
       }

    public static ReceptionOrderLines toModel(RcpReceptionLine rcpReceptionLine,String operation,String detailLineStart){
        ReceptionOrderLines receptionOrderLines = new ReceptionOrderLines();
        receptionOrderLines.setDetailLineStart(detailLineStart);
        receptionOrderLines.setProductCode(rcpReceptionLine.getPdtProduct().getPdtProductCode());
        receptionOrderLines.setQuantity(rcpReceptionLine.getRcpReceptionLineQuantity().doubleValue());
        receptionOrderLines.setUomCode(rcpReceptionLine.getPdtUom().getPdtUomCode());
        receptionOrderLines.setLot(rcpReceptionLine.getRcpReceptionLineLot());
        receptionOrderLines.setExpDate(rcpReceptionLine.getRcpReception().getRcpReceptionExpectedDate());
        receptionOrderLines.setSerial(rcpReceptionLine.getRcpReceptionLineSerialNo());
        receptionOrderLines.setOwnerCode(rcpReceptionLine.getOwnOwner().getOwnOwnerCode());
        receptionOrderLines.setContainerNo(rcpReceptionLine.getRcpReceptionLineContainerCode());
            if(rcpReceptionLine.getPrmBlockType().getPrmBlockTypeDescription().equals("Endommag�")) {
                receptionOrderLines.setStockStatusCode("BRK");
            }
            else if(rcpReceptionLine.getPrmBlockType().getPrmBlockTypeDescription().equals("P�rim�")){
                receptionOrderLines.setStockStatusCode("EXP");
            }
            else if(rcpReceptionLine.getPrmBlockType().getPrmBlockTypeDescription().equals("Cach�")){
                receptionOrderLines.setStockStatusCode("HID");
            }
        receptionOrderLines.setReqManipulation(false);
        receptionOrderLines.setLineNumber(rcpReceptionLine.getRcpReceptionLineLineNumber().intValue());
        receptionOrderLines.setAllowRecLess(true);
        receptionOrderLines.setAllowRecMore(true);
        receptionOrderLines.setBestBeforeDate(rcpReceptionLine.getRcpReceptionLineDluo());
        receptionOrderLines.setQuality(rcpReceptionLine.getRcpReceptionLineQuality());
        receptionOrderLines.setShelfLife(rcpReceptionLine.getRcpReceptionSuppOfLife().doubleValue());
        receptionOrderLines.setSupplierCode(rcpReceptionLine.getRcpReception().getRcpSupplier().getRcpSupplierCode());

        //TODO
        //receptionOrderLines.setSizeCode(rcpReceptionLine.);

        receptionOrderLines.setColorCode(rcpReceptionLine.getPrmColor().getPrmColorCode());
        return receptionOrderLines;
    }
}
