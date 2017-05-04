package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.CmdSaleOrder;
import com.sinno.ems.entities.CmdSaleOrderLine;
import com.sinno.wms.crud.model.sor.OrderHeader;
import com.sinno.wms.crud.model.sor.OrderLines;

/**
 * Created by CODING on 30/05/2016.
 */
public class SaleOrderMapperWMS {

    private SaleOrderMapperWMS() {
    }

    public static OrderHeader toModel(CmdSaleOrder cmdSaleOrder, String operation) {
        OrderHeader orderHeaderModel = new OrderHeader();

        orderHeaderModel.setOperation(operation);
        orderHeaderModel.setSorderCode(cmdSaleOrder.getCmdSaleOrderCode());
        //wharehouse source au destination
        orderHeaderModel.setWarehouseCode(cmdSaleOrder.getWrhWarehouseDestination().getWrhWarehouseCode());
        orderHeaderModel.setDescription(cmdSaleOrder.getCmdSaleOrderDescription());//comment
        //
        orderHeaderModel.setComment("");
        switch (cmdSaleOrder.getPrmOrderType().getPrmOrderTypeCode()) {
            case "commande client":
                orderHeaderModel.setTypeCode("CORDER");
            case "commande de production":
                orderHeaderModel.setTypeCode("PRODUCTION");
            case "fournisseur":
                orderHeaderModel.setTypeCode("RETURN");
            default:
                orderHeaderModel.setTypeCode("NOT SPECIFIED");
        }

        orderHeaderModel.setTypeDescription(cmdSaleOrder.getPrmOrderType().getPrmOrderTypeDescription());
        //TODO
        orderHeaderModel.setPriority(0);
        //TODO
        orderHeaderModel.setAccountCode(cmdSaleOrder.getOwnOwner().getOwnOwnerCode());
        //TODO emplacement ..?
        orderHeaderModel.setDoorCode("doorcode");
        orderHeaderModel.setCarrierCode(cmdSaleOrder.getTrpTransport().getTrpTransportCode());

        orderHeaderModel.setDeliveryInst(cmdSaleOrder.getCmdSaleOrderRemarks());
        orderHeaderModel.setShippingDate(cmdSaleOrder.getCmdSaleOrderExpectedDate());
        orderHeaderModel.setPlannedLoadDate(cmdSaleOrder.getCmdSaleOrderLoadDate());
        orderHeaderModel.setVerifyStock(false);
        orderHeaderModel.setFollowSequence(0);
        if ("RETURN".equals(cmdSaleOrder.getPrmOrderType().getPrmOrderTypeCode())) {
            orderHeaderModel.setSupplierCode(cmdSaleOrder.getRcpSupplier().getRcpSupplierCode());
        }
        orderHeaderModel.setNumLines(cmdSaleOrder.getCmdSaleOrderLines().size());
        for (CmdSaleOrderLine cmdSaleOrderLine : cmdSaleOrder.getCmdSaleOrderLines()) {
            orderHeaderModel.getList().add(toModel(cmdSaleOrderLine, operation, "/"));
        }

        return orderHeaderModel;
    }

    public static OrderLines toModel(CmdSaleOrderLine cmdSaleOrderLine, String operation, String detailStart) {
        OrderLines orderLinesModel = new OrderLines();
        orderLinesModel.setDetailLineStart(detailStart);
        orderLinesModel.setOperation(operation);
        //FOLLOW_SEQUENCE est fixer avec 2 dans l'en-tete,si le cas de 2 alors n est spécifier
        //TODO orderLinesModel.setLineNumber(??);

        orderLinesModel.setLotCode(cmdSaleOrderLine.getCmdSaleOrderLineLot());
        orderLinesModel.setQuantity(cmdSaleOrderLine.getCmdSaleOrderLineQuantity().doubleValue());
        orderLinesModel.setSerialNo(cmdSaleOrderLine.getCmdSaleOrderLineSerialNo());

        orderLinesModel.setExpirationDate(cmdSaleOrderLine.getCmdSaleOrderLineDlc());

        //TODO SHELF_DAY n'existe pas cmdsor
        //  orderLinesModel.setShelfDays(cmdSaleOrderLine.get);


        orderLinesModel.setUomCode(cmdSaleOrderLine.getPdtUom().getPdtUomCode());
        orderLinesModel.setComment(cmdSaleOrderLine.getCmdSaleOrderLineComment());
        orderLinesModel.setCustspLineNo(String.valueOf(cmdSaleOrderLine.getCmdSaleOrderLineLineNumber()));
        //TODO n'existe pas
        //orderLinesModel.setExpectedDate(cmdSaleOrderLine.getd);

        orderLinesModel.setCustomerCode(cmdSaleOrderLine.getCmdSaleOrder().getCmdSaleOrderCustomerCode());
        orderLinesModel.setOwnerCode(cmdSaleOrderLine.getOwnOwner().getOwnOwnerCode());
        orderLinesModel.setContainerNo(cmdSaleOrderLine.getStkContainer().getStkContainerCode());
        orderLinesModel.setSerieControl(false);
        orderLinesModel.setQuality(cmdSaleOrderLine.getCmdSaleOrderLineQuality());
        orderLinesModel.setBestBeforeDate(cmdSaleOrderLine.getCmdSaleOrderLineDluo());
        orderLinesModel.setCatchWeight(false);
        orderLinesModel.setDisableAltProduct(false);


        return orderLinesModel;
    }
}
