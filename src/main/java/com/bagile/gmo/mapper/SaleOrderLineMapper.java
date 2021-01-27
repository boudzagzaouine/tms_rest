/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.SaleOrderLine;
import com.bagile.gmo.entities.CmdSaleOrderLine;
import com.bagile.gmo.util.EmsDate;


import java.util.*;

/**
 * @author aelguezzar
 */
public class SaleOrderLineMapper {
    private SaleOrderLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdSaleOrderLineId");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("blockType", "prmBlockType");
        map.put("color", "prmColor");
        map.put("orderStatus", "prmOrderStatus");
        map.put("transport", "trpTransport");
        map.put("warehouse", "wrhWarehouse");
        map.put("lineNumber", "cmdSaleOrderLineLineNumber");
        map.put("quantity", "cmdSaleOrderLineQuantity");
        map.put("quantityReserved", "cmdSaleOrderLineReserved");
        map.put("quantityPrepare", "cmdSaleOrderLinePrepare");
        map.put("quantityDeliver", "cmdSaleOrderLineDeliver");

        map.put("quantityServed", "cmdSaleOrderLineQuantityServed");
        map.put("description", "cmdSaleOrderLineDescription");
        map.put("container", "stkContainer");
        map.put("dlc", "cmdSaleOrderLineDlc");
        map.put("dluo", "cmdSaleOrderLineDluo");
        map.put("serialNo", "cmdSaleOrderLineSerialNo");
        map.put("lot", "cmdSaleOrderLineLot");
        map.put("date", "cmdSaleOrderLineDate");
        map.put("creationDate", "cmdSaleOrderLineCreationDate");
        map.put("updateDate", "cmdSaleOrderLineUpdateDate");
        map.put("variable1", "cmdSaleOrderLineVariable1");
        map.put("variable2", "cmdSaleOrderLineVariable2");
        map.put("variable3", "cmdSaleOrderLineVariable3");
        map.put("variable4", "cmdSaleOrderLineVariable4");
        map.put("variable5", "cmdSaleOrderLineVariable5");
        map.put("variable6", "cmdSaleOrderLineVariable6");
        map.put("variable7", "cmdSaleOrderLineVariable7");
        map.put("variable8", "cmdSaleOrderLineVariable8");
        map.put("variable9", "cmdSaleOrderLineVariable9");
        map.put("variable10", "cmdSaleOrderLineVariable10");
        map.put("comment", "cmdSaleOrderLineComment");
        map.put("weight", "cmdSaleOrderLineWeight");
        map.put("quality", "cmdSaleOrderLineQuality");
        map.put("containerCode", "cmdSaleOrderLineContainerCode");
        map.put("saleOrderLine", "cmdSaleOrderLine");
        map.put("devisLine", "cmdDevisLine");
        map.put("productDimension", "pdtProductDimension");
        map.put("menu", "pdtMenu");
        map.put("menuNumber", "cmdSaleOrderLineMenuNumber");
        map.put("menuQuantity", "cmdSaleOrderLineMenuQuantity");
        map.put("parentService", "parentService");
        map.put("productPack", "pdtProductPack");
        map.put("isPromotion", "cmdSaleOrderLineIsPromotion");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static SaleOrderLine toDto(CmdSaleOrderLine cmdSaleOrderLine, boolean lazy) {
        if (null == cmdSaleOrderLine) {
            return null;
        }
        SaleOrderLine saleOrderLine = new SaleOrderLine();
        saleOrderLine.setCreationDate(cmdSaleOrderLine.getCmdSaleOrderLineCreationDate());
        saleOrderLine.setDate(cmdSaleOrderLine.getCmdSaleOrderLineDate());
        saleOrderLine.setDescription(cmdSaleOrderLine.getCmdSaleOrderLineDescription());
        saleOrderLine.setDlc(cmdSaleOrderLine.getCmdSaleOrderLineDlc());
        saleOrderLine.setDluo(cmdSaleOrderLine.getCmdSaleOrderLineDluo());
        saleOrderLine.setId(cmdSaleOrderLine.getCmdSaleOrderLineId());
        saleOrderLine.setLineNumber(cmdSaleOrderLine.getCmdSaleOrderLineLineNumber());
        saleOrderLine.setLot(cmdSaleOrderLine.getCmdSaleOrderLineLot());
        saleOrderLine.setQuantity(cmdSaleOrderLine.getCmdSaleOrderLineQuantity());
        saleOrderLine.setQuantityReserved(cmdSaleOrderLine.getCmdSaleOrderLineReserved());
        saleOrderLine.setQuantityPrepare(cmdSaleOrderLine.getCmdSaleOrderLinePrepare());
        saleOrderLine.setQuantityDeliver(cmdSaleOrderLine.getCmdSaleOrderLineDeliver());

        saleOrderLine.setQuantityServed(cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed());
        saleOrderLine.setQantityToLoad (cmdSaleOrderLine.getCmdSaleOrderLineQuantityToLoad ());
        saleOrderLine.setRemainingQuantity (cmdSaleOrderLine.getCmdSaleOrderLineRemainingQuantity ());
        saleOrderLine.setSerialNo(cmdSaleOrderLine.getCmdSaleOrderLineSerialNo());
        saleOrderLine.setUpdateDate(cmdSaleOrderLine.getCmdSaleOrderLineUpdateDate());
        saleOrderLine.setVariable1(cmdSaleOrderLine.getCmdSaleOrderLineVariable1());
        saleOrderLine.setVariable2(cmdSaleOrderLine.getCmdSaleOrderLineVariable2());
        saleOrderLine.setVariable3(cmdSaleOrderLine.getCmdSaleOrderLineVariable3());
        saleOrderLine.setVariable4(cmdSaleOrderLine.getCmdSaleOrderLineVariable4());
        saleOrderLine.setVariable5(cmdSaleOrderLine.getCmdSaleOrderLineVariable5());
        saleOrderLine.setVariable6(cmdSaleOrderLine.getCmdSaleOrderLineVariable6());
        saleOrderLine.setVariable7(cmdSaleOrderLine.getCmdSaleOrderLineVariable7());
        saleOrderLine.setVariable8(cmdSaleOrderLine.getCmdSaleOrderLineVariable8());
        saleOrderLine.setVariable9(cmdSaleOrderLine.getCmdSaleOrderLineVariable9());
        saleOrderLine.setVariable10(cmdSaleOrderLine.getCmdSaleOrderLineVariable10());
        saleOrderLine.setComment(cmdSaleOrderLine.getCmdSaleOrderLineComment());
        saleOrderLine.setQuality(cmdSaleOrderLine.getCmdSaleOrderLineQuality());
        saleOrderLine.setWeight(cmdSaleOrderLine.getCmdSaleOrderLineWeight());
        saleOrderLine.setContainerCode(cmdSaleOrderLine.getCmdSaleOrderLineContainerCode());
        saleOrderLine.setTotalPriceHT(cmdSaleOrderLine.getCmdSaleOrderLineTotalPriceHT());
        saleOrderLine.setTotalPriceTTC(cmdSaleOrderLine.getCmdSaleOrderLineTotalPriceTTC());
        saleOrderLine.setDiscount(cmdSaleOrderLine.getCmdSaleOrderLineDiscount());
        saleOrderLine.setSalePrice(cmdSaleOrderLine.getCmdSaleOrderLineSalePrice());
        saleOrderLine.setMenuNumber(cmdSaleOrderLine.getCmdSaleOrderLineMenuNumber());
        saleOrderLine.setMenuQuantity(cmdSaleOrderLine.getCmdSaleOrderLineMenuQuantity());
        saleOrderLine.setPromotion(cmdSaleOrderLine.getCmdSaleOrderLineIsPromotion());
        saleOrderLine.setUpdatedBy(cmdSaleOrderLine.getUpdatedBy());
        saleOrderLine.setCreatedBy(cmdSaleOrderLine.getCreatedBy());
        if (!lazy) {

            saleOrderLine.setMenu(ProductMapper.toDto(cmdSaleOrderLine.getPdtMenu(), true));
            saleOrderLine.setVat(VatMapper.toDto(cmdSaleOrderLine.getPrmVat(), true));
            saleOrderLine.setOrderStatus(OrderStatusMapper.toDto(cmdSaleOrderLine.getPrmOrderStatus(), true));
            saleOrderLine.setOwner(OwnerMapper.toDto(cmdSaleOrderLine.getOwnOwner(), true));
            saleOrderLine.setProduct(ProductMapper.toDto(cmdSaleOrderLine.getPdtProduct(), true));
            saleOrderLine.setSaleOrder(SaleOrderMapper.toDto(cmdSaleOrderLine.getCmdSaleOrder(), true));
            saleOrderLine.setTransport(TransportMapper.toDto(cmdSaleOrderLine.getTrpTransport(), true));
            saleOrderLine.setUom(UomMapper.toDto(cmdSaleOrderLine.getPdtUom(), true));
            saleOrderLine.setWarehouse(WarehouseMapper.toDto(cmdSaleOrderLine.getWrhWarehouse(), true));
            saleOrderLine.setParentService(toDto(cmdSaleOrderLine.getServiceParent(), true));
            saleOrderLine.setServices(toDtos(cmdSaleOrderLine.getServices(), false));
            saleOrderLine.setProductPack(ProductPackMapper.toDto(cmdSaleOrderLine.getPdtProductPack(), false));

        }
        return saleOrderLine;
    }

    public static CmdSaleOrderLine toEntity(SaleOrderLine saleOrderLine, boolean lazy) {
        if (null == saleOrderLine) {
            return null;
        }
        CmdSaleOrderLine cmdSaleOrderLine = new CmdSaleOrderLine();
        cmdSaleOrderLine.setCmdSaleOrderLineCreationDate(saleOrderLine.getCreationDate());
        cmdSaleOrderLine.setCmdSaleOrderLineDate(saleOrderLine.getDate());
        cmdSaleOrderLine.setCmdSaleOrderLineDescription(saleOrderLine.getDescription());
        cmdSaleOrderLine.setCmdSaleOrderLineDlc(saleOrderLine.getDlc());
        cmdSaleOrderLine.setCmdSaleOrderLineDluo(saleOrderLine.getDluo());
        cmdSaleOrderLine.setCmdSaleOrderLineId(saleOrderLine.getId());
        cmdSaleOrderLine.setCmdSaleOrderLineLineNumber(saleOrderLine.getLineNumber());
        cmdSaleOrderLine.setCmdSaleOrderLineLot(saleOrderLine.getLot());
        cmdSaleOrderLine.setCmdSaleOrderLineQuantity(saleOrderLine.getQuantity());
        cmdSaleOrderLine.setCmdSaleOrderLineReserved(saleOrderLine.getQuantityReserved());
        cmdSaleOrderLine.setCmdSaleOrderLinePrepare(saleOrderLine.getQuantityPrepare());
        cmdSaleOrderLine.setCmdSaleOrderLineDeliver(saleOrderLine.getQuantityDeliver());



        cmdSaleOrderLine.setCmdSaleOrderLineQuantityServed(saleOrderLine.getQuantityServed());
        cmdSaleOrderLine.setCmdSaleOrderLineRemainingQuantity (saleOrderLine.getRemainingQuantity ());
        cmdSaleOrderLine.setCmdSaleOrderLineQuantityToLoad (saleOrderLine.getQantityToLoad ());
        cmdSaleOrderLine.setCmdSaleOrderLineSerialNo(saleOrderLine.getSerialNo());
        cmdSaleOrderLine.setCmdSaleOrderLineUpdateDate(saleOrderLine.getUpdateDate());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable1(saleOrderLine.getVariable1());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable2(saleOrderLine.getVariable2());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable3(saleOrderLine.getVariable3());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable4(saleOrderLine.getVariable4());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable5(saleOrderLine.getVariable5());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable6(saleOrderLine.getVariable6());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable7(saleOrderLine.getVariable7());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable8(saleOrderLine.getVariable8());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable9(saleOrderLine.getVariable9());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable10(saleOrderLine.getVariable10());
        cmdSaleOrderLine.setCmdSaleOrderLineComment(saleOrderLine.getComment());
        cmdSaleOrderLine.setCmdSaleOrderLineQuality(saleOrderLine.getQuality());
        cmdSaleOrderLine.setCmdSaleOrderLineWeight(saleOrderLine.getWeight());
        cmdSaleOrderLine.setCmdSaleOrderLineContainerCode(saleOrderLine.getContainerCode());
        cmdSaleOrderLine.setCmdSaleOrderLineTotalPriceHT(saleOrderLine.getTotalPriceHT());
        cmdSaleOrderLine.setCmdSaleOrderLineTotalPriceTTC(saleOrderLine.getTotalPriceTTC());
        cmdSaleOrderLine.setCmdSaleOrderLineDiscount(saleOrderLine.getDiscount());
        cmdSaleOrderLine.setCmdSaleOrderLineSalePrice(saleOrderLine.getSalePrice());
        cmdSaleOrderLine.setCmdSaleOrderLineMenuQuantity(saleOrderLine.getMenuQuantity());
        cmdSaleOrderLine.setCmdSaleOrderLineMenuNumber(saleOrderLine.getMenuNumber());
        cmdSaleOrderLine.setCmdSaleOrderLineIsPromotion(saleOrderLine.getPromotion());
        cmdSaleOrderLine.setUpdatedBy(saleOrderLine.getUpdatedBy());
        cmdSaleOrderLine.setCreatedBy(saleOrderLine.getCreatedBy());
        if (!lazy) {
            cmdSaleOrderLine.setPdtMenu(ProductMapper.toEntity(saleOrderLine.getMenu(), true));
            cmdSaleOrderLine.setPrmVat(VatMapper.toEntity(saleOrderLine.getVat(), true));
            cmdSaleOrderLine.setCmdSaleOrder(SaleOrderMapper.toEntity(saleOrderLine.getSaleOrder(), true));
            cmdSaleOrderLine.setOwnOwner(OwnerMapper.toEntity(saleOrderLine.getOwner(), true));
            cmdSaleOrderLine.setPdtProduct(ProductMapper.toEntity(saleOrderLine.getProduct(), true));
            cmdSaleOrderLine.setPdtUom(UomMapper.toEntity(saleOrderLine.getUom(), true));
            cmdSaleOrderLine.setPrmOrderStatus(OrderStatusMapper.toEntity(saleOrderLine.getOrderStatus(), true));
            cmdSaleOrderLine.setTrpTransport(TransportMapper.toEntity(saleOrderLine.getTransport(), true));
            cmdSaleOrderLine.setWrhWarehouse(WarehouseMapper.toEntity(saleOrderLine.getWarehouse(), true));
            cmdSaleOrderLine.setServiceParent(toEntity(saleOrderLine.getParentService(), true));
            cmdSaleOrderLine.setServices(toEntities(saleOrderLine.getServices(), false));
            cmdSaleOrderLine.setPdtProductPack(ProductPackMapper.toEntity(saleOrderLine.getProductPack(), true));

            oneToMany(cmdSaleOrderLine);
        }
        return cmdSaleOrderLine;
    }

    public static List<SaleOrderLine> toDtos(List<CmdSaleOrderLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<SaleOrderLine> saleOrderLines = new ArrayList<>();
        for (CmdSaleOrderLine cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }

    public static List<SaleOrderLine> toDtos(Iterable<CmdSaleOrderLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<SaleOrderLine> saleOrderLines = new ArrayList<>();
        for (CmdSaleOrderLine cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }
    public static void oneToMany(CmdSaleOrderLine saleOrderline) {
        if (null != saleOrderline.getServices()) {
            saleOrderline.getServices().stream().forEach(sl -> {
                sl.setOwnOwner(saleOrderline.getOwnOwner());
                sl.setCmdSaleOrderLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getCmdSaleOrderLineId()) {
                    sl.setCmdSaleOrderLineCreationDate(EmsDate.getDateNow());
                    sl.setCmdSaleOrderLineId(0L);
                    sl.setServiceParent(saleOrderline);
                }
            });
        }
    }

    public static Set<CmdSaleOrderLine> toEntities(Set<SaleOrderLine> saleOrderLines, boolean lazy) {
        if (null == saleOrderLines) {
            return null;
        }
        Set<CmdSaleOrderLine> cmdSaleOrderLines = new HashSet<>();
        for (SaleOrderLine saleOrderLine : saleOrderLines) {
            cmdSaleOrderLines.add(toEntity(saleOrderLine, lazy));
        }
        return cmdSaleOrderLines;
    }

    public static Set<SaleOrderLine> toDtos(Set<CmdSaleOrderLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        Set<SaleOrderLine> saleOrderLines = new HashSet<>();
        for (CmdSaleOrderLine cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }



}
