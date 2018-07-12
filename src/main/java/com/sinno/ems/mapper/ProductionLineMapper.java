package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/04/2017.
 */
public class ProductionLineMapper {
    private ProductionLineMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prcProductionId");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("production", "prcProduction");
        map.put("quantity", "prcProductionLineQuantity");
        map.put("price", "prcProductionLinePrice");
        map.put("discount", "prcProductionLineDiscount");
        map.put("vat", "prmVat");
        map.put("totalPriceHT", "prcProductionLineTotalPriceHT");
        map.put("totalPriceTTC", "prcProductionLineTotalPriceTTC");
        map.put("producedQuantity", "prcProductionLineProducedQuantity");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PrcProductionLine toEntity(ProductionLine productionLine, boolean lazy) {
        if(null==productionLine){
            return null;
        }
        PrcProductionLine prcProductionLine = new PrcProductionLine();
        prcProductionLine.setPrcProductionLineId(productionLine.getId());
        prcProductionLine.setPrcProductionLineQuantity(productionLine.getQuantity());
        prcProductionLine.setPrcProductionLineDiscount(productionLine.getDiscount());
        prcProductionLine.setPrcProductionLinePrice(productionLine.getPrice());
        prcProductionLine.setPrcProductionLineTotalPriceHT(productionLine.getTotalPriceHT());
        prcProductionLine.setPrcProductionLineTotalPriceTTC(productionLine.getTotalPriceTTC());
        prcProductionLine.setPrcProductionLineProducedQuantity(productionLine.getProducedQuantity());
        if (!lazy) {
            prcProductionLine.setPrmVat(VatMapper.toEntity(productionLine.getVat(),true));
            prcProductionLine.setPdtProduct(ProductMapper.toEntity(productionLine.getProduct(), true));
            prcProductionLine.setPdtUom(UomMapper.toEntity(productionLine.getUom(), true));
            prcProductionLine.setPrcProduction(ProductionMapper.toEntity(productionLine.getProduction(), true));

        }
        return prcProductionLine;
    }

    public static ProductionLine toDto(PrcProductionLine prcProductionLine, boolean lazy) {
        if(null==prcProductionLine){
            return null;
        }
        ProductionLine productionLine = new ProductionLine();
        productionLine.setId(prcProductionLine.getPrcProductionLineId());
        productionLine.setQuantity(prcProductionLine.getPrcProductionLineQuantity());
        productionLine.setDiscount(prcProductionLine.getPrcProductionLineDiscount());
        productionLine.setPrice(prcProductionLine.getPrcProductionLinePrice());
        productionLine.setTotalPriceHT(prcProductionLine.getPrcProductionLineTotalPriceHT());
        productionLine.setTotalPriceTTC(prcProductionLine.getPrcProductionLineTotalPriceTTC());
        productionLine.setProducedQuantity(prcProductionLine.getPrcProductionLineProducedQuantity());
        if (!lazy) {
            productionLine.setVat(VatMapper.toDto(prcProductionLine.getPrmVat(),true));
            productionLine.setProduct(ProductMapper.toDto(prcProductionLine.getPdtProduct(), true));
            productionLine.setUom(UomMapper.toDto(prcProductionLine.getPdtUom(), true));
            productionLine.setProduction(ProductionMapper.toDto(prcProductionLine.getPrcProduction(), true));
        }
        return productionLine;
    }

    public static List<ProductionLine> toDtos(List<PrcProductionLine> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        List<ProductionLine> productionLines = new ArrayList<>();
        for (PrcProductionLine pdtProcess : prcProductions) {
            productionLines.add(toDto(pdtProcess, lazy));
        }
        return productionLines;
    }

    public static List<ProductionLine> toDtos(Iterable<PrcProductionLine> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        List<ProductionLine> productionLines = new ArrayList<>();
        for (PrcProductionLine pdtProcess : prcProductions) {
            productionLines.add(toDto(pdtProcess, lazy));
        }
        return productionLines;
    }

    public static Set<PrcProductionLine> toEntities(Set<ProductionLine> productionLines, boolean lazy) {
        if (null == productionLines) {
            return null;
        }
        Set<PrcProductionLine> prcProductions = new HashSet<>();
        for (ProductionLine production : productionLines) {
            prcProductions.add(toEntity(production, lazy));
        }
        return prcProductions;
    }

    public static Set<ProductionLine> toDtos(Set<PrcProductionLine> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        Set<ProductionLine> productionLines = new HashSet<>();
        for (PrcProductionLine pdtProcess : prcProductions) {
            productionLines.add(toDto(pdtProcess, lazy));
        }
        return productionLines;
    }
}
