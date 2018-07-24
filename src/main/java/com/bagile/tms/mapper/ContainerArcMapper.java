package com.bagile.tms.mapper;

import java.util.*;

public class ContainerArcMapper {
    private ContainerArcMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","stkContainerId");
        map.put("location","locLocation");
        map.put("owner","ownOwner");
        map.put("warehouse","wrhWarehouse");
        map.put("code","stkContainerCode");
        map.put("receptionDate","stkContainerReceptionDate");
        map.put("creationDate","stkContainerCreationDate");
        map.put("updateDate","stkContainerUpdateDate");
        map.put("variable1","stkContainerVariable1");
        map.put("variable2","stkContainerVariable2");
        map.put("variable3","stkContainerVariable3");
        map.put("variable4","stkContainerVariable4");
        map.put("variable5","stkContainerVariable5");
        map.put("variable6","stkContainerVariable6");
        map.put("variable7","stkContainerVariable7");
        map.put("variable8","stkContainerVariable8");
        map.put("variable9","stkContainerVariable9");
        map.put("variable10","stkContainerVariable10");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static StkContainerArc toEntity(ContainerArc containerArc, boolean lazy) {
        if (null == containerArc) {
            return null;
        }
        StkContainerArc stkContainerArc = new StkContainerArc();
        stkContainerArc.setStkContainerId(containerArc.getId());
        stkContainerArc.setStkContainerCode(containerArc.getCode());
        stkContainerArc.setStkContainerReceptionDate(containerArc.getReceptionDate());
        stkContainerArc.setStkContainerCreationDate(containerArc.getCreationDate());
        stkContainerArc.setStkContainerUpdateDate(containerArc.getUpdateDate());
        stkContainerArc.setStkContainerVariable1(containerArc.getVariable1());
        stkContainerArc.setStkContainerVariable2(containerArc.getVariable2());
        stkContainerArc.setStkContainerVariable3(containerArc.getVariable3());
        stkContainerArc.setStkContainerVariable4(containerArc.getVariable4());
        stkContainerArc.setStkContainerVariable5(containerArc.getVariable5());
        stkContainerArc.setStkContainerVariable6(containerArc.getVariable6());
        stkContainerArc.setStkContainerVariable7(containerArc.getVariable7());
        stkContainerArc.setStkContainerVariable8(containerArc.getVariable8());
        stkContainerArc.setStkContainerVariable9(containerArc.getVariable9());
        stkContainerArc.setStkContainerVariable10(containerArc.getVariable10());
        if (!lazy) {
            stkContainerArc.setLocLocation(LocationMapper.toEntity(containerArc.getLocation(), true));
            stkContainerArc.setWrhWarehouse(WarehouseMapper.toEntity(containerArc.getWarehouse(), true));
            stkContainerArc.setOwnOwner(OwnerMapper.toEntity(containerArc.getOwner(), true));
//            stkContainerArc.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(container.getSaleOrderStocks(), true));
//            stkContainerArc.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(container.getSaleOrderStockArcs(), true));
//            stkContainerArc.setStkStockArcs(StockArcMapper.toEntities(container.getStockArcs(), true));
//            stkContainerArc.setStkStocks(StockMapper.toEntities(container.getStocks(), true));
        }
        return stkContainerArc;
    }

    public static ContainerArc toDto(StkContainerArc stkContainer, boolean lazy) {
        if (null == stkContainer) {
            return null;
        }
        ContainerArc containerArc = new ContainerArc();
        containerArc.setId(stkContainer.getStkContainerId());
        containerArc.setCode(stkContainer.getStkContainerCode());
        containerArc.setReceptionDate(stkContainer.getStkContainerReceptionDate());
        containerArc.setCreationDate(stkContainer.getStkContainerCreationDate());
        containerArc.setUpdateDate(stkContainer.getStkContainerUpdateDate());
        containerArc.setVariable1(stkContainer.getStkContainerVariable1());
        containerArc.setVariable2(stkContainer.getStkContainerVariable2());
        containerArc.setVariable3(stkContainer.getStkContainerVariable3());
        containerArc.setVariable4(stkContainer.getStkContainerVariable4());
        containerArc.setVariable5(stkContainer.getStkContainerVariable5());
        containerArc.setVariable6(stkContainer.getStkContainerVariable6());
        containerArc.setVariable7(stkContainer.getStkContainerVariable7());
        containerArc.setVariable8(stkContainer.getStkContainerVariable8());
        containerArc.setVariable9(stkContainer.getStkContainerVariable9());
        containerArc.setVariable10(stkContainer.getStkContainerVariable10());
        if (!lazy) {
            containerArc.setLocation(LocationMapper.toDto(stkContainer.getLocLocation(), true));
            containerArc.setWarehouse(WarehouseMapper.toDto(stkContainer.getWrhWarehouse(), true));
            containerArc.setOwner(OwnerMapper.toDto(stkContainer.getOwnOwner(), true));
//            containerArc.setSaleOrderStocks(SaleOrderStockMapper.toDtos(stkContainer.getCmdSaleOrderStocks(), true));
//            containerArc.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(stkContainer.getCmdSaleOrderStockArcs(), true));
//            containerArc.setStockArcs(StockArcMapper.toDtos(stkContainer.getStkStockArcs(), true));
//            containerArc.setStocks(StockMapper.toDtos(stkContainer.getStkStocks(), true));
        }
        return containerArc;
    }

    public static List<ContainerArc> toDtos(List<StkContainerArc> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        List<ContainerArc> containers = new ArrayList<>();
        for (StkContainerArc stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }

    public static List<ContainerArc> toDtos(Iterable<StkContainerArc> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        List<ContainerArc> containers = new ArrayList<>();
        for (StkContainerArc stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }

    public static Set<StkContainerArc> toEntities(Set<ContainerArc> containers, boolean lazy) {
        if (null == containers) {
            return null;
        }
        Set<StkContainerArc> stkContainers = new HashSet<>();
        for (ContainerArc container : containers) {
            stkContainers.add(toEntity(container, lazy));
        }
        return stkContainers;
    }

    public static Set<ContainerArc> toDtos(Set<StkContainerArc> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        Set<ContainerArc> containers = new HashSet<>();
        for (StkContainerArc stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }
}
