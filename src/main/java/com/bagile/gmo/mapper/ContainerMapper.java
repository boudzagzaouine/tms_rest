package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Container;
import com.bagile.gmo.entities.StkContainer;

import java.util.*;

public class ContainerMapper {
    private ContainerMapper(){

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
        map.put("active","stkContainerActive");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static StkContainer toEntity(Container container, boolean lazy) {
        if (null == container) {
            return null;
        }
        StkContainer stkContainer = new StkContainer();
        stkContainer.setStkContainerId(container.getId());
        stkContainer.setStkContainerCode(container.getCode());
        stkContainer.setStkContainerReceptionDate(container.getReceptionDate());
        stkContainer.setStkContainerCreationDate(container.getCreationDate());
        stkContainer.setStkContainerUpdateDate(container.getUpdateDate());
        stkContainer.setStkContainerOutBoundDate(container.getOutBoundDate());
        stkContainer.setStkContainerVariable1(container.getVariable1());
        stkContainer.setStkContainerVariable2(container.getVariable2());
        stkContainer.setStkContainerVariable3(container.getVariable3());
        stkContainer.setStkContainerVariable4(container.getVariable4());
        stkContainer.setStkContainerVariable5(container.getVariable5());
        stkContainer.setStkContainerVariable6(container.getVariable6());
        stkContainer.setStkContainerVariable7(container.getVariable7());
        stkContainer.setStkContainerVariable8(container.getVariable8());
        stkContainer.setStkContainerVariable9(container.getVariable9());
        stkContainer.setStkContainerVariable10(container.getVariable10());
        stkContainer.setStkContainerActive(container.getActive());
        stkContainer.setUpdatedBy(container.getUpdatedBy());
        stkContainer.setCreatedBy(container.getCreatedBy());
        if (!lazy) {
            stkContainer.setLocLocation(LocationMapper.toEntity(container.getLocation(), true));
            stkContainer.setWrhWarehouse(WarehouseMapper.toEntity(container.getWarehouse(), true));
            stkContainer.setOwnOwner(OwnerMapper.toEntity(container.getOwner(), true));
//            stkContainer.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(container.getSaleOrderStocks(), true));
//            stkContainer.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(container.getSaleOrderStockArcs(), true));
//            stkContainer.setStkStockArcs(StockArcMapper.toEntities(container.getStockArcs(), true));
           stkContainer.setStkStocks(StockMapper.toEntities(container.getStocks(), false));
        }
        return stkContainer;
    }

    public static Container toDto(StkContainer stkContainer, boolean lazy) {
        if (null == stkContainer) {
            return null;
        }
        Container container = new Container();
        container.setId(stkContainer.getStkContainerId());
        container.setCode(stkContainer.getStkContainerCode());
        container.setReceptionDate(stkContainer.getStkContainerReceptionDate());
        container.setCreationDate(stkContainer.getStkContainerCreationDate());
        container.setUpdateDate(stkContainer.getStkContainerUpdateDate());
        container.setOutBoundDate(stkContainer.getStkContainerOutBoundDate());
        container.setVariable1(stkContainer.getStkContainerVariable1());
        container.setVariable2(stkContainer.getStkContainerVariable2());
        container.setVariable3(stkContainer.getStkContainerVariable3());
        container.setVariable4(stkContainer.getStkContainerVariable4());
        container.setVariable5(stkContainer.getStkContainerVariable5());
        container.setVariable6(stkContainer.getStkContainerVariable6());
        container.setVariable7(stkContainer.getStkContainerVariable7());
        container.setVariable8(stkContainer.getStkContainerVariable8());
        container.setVariable9(stkContainer.getStkContainerVariable9());
        container.setVariable10(stkContainer.getStkContainerVariable10());
        container.setActive(stkContainer.getStkContainerActive());
        container.setUpdatedBy(stkContainer.getUpdatedBy());
        container.setCreatedBy(stkContainer.getCreatedBy());
        if (!lazy) {
            container.setLocation(LocationMapper.toDto(stkContainer.getLocLocation(), true));
            container.setWarehouse(WarehouseMapper.toDto(stkContainer.getWrhWarehouse(), true));
            container.setOwner(OwnerMapper.toDto(stkContainer.getOwnOwner(), true));
         container.setSaleOrderStocks(SaleOrderStockMapper.toDtos(stkContainer.getCmdSaleOrderStocks(), true));
   //         container.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(stkContainer.getCmdSaleOrderStockArcs(), true));
          //  container.setStockArcs(StockArcMapper.toDtos(stkContainer.getStkStockArcs(), true));
         container.setStocks(StockMapper.toDtos(stkContainer.getStkStocks(), false));
        }
        return container;
    }



    public static List<Container> toDtos(List<StkContainer> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        List<Container> containers = new ArrayList<>();
        for (StkContainer stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }



    public static List<Container> toDtos(Iterable<StkContainer> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        List<Container> containers = new ArrayList<>();
        for (StkContainer stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }



    public static Set<StkContainer> toEntities(Set<Container> containers, boolean lazy) {
        if (null == containers) {
            return null;
        }
        Set<StkContainer> stkContainers = new HashSet<>();
        for (Container container : containers) {
            stkContainers.add(toEntity(container, lazy));
        }
        return stkContainers;
    }

    public static Set<Container> toDtos(Set<StkContainer> stkContainers, boolean lazy) {
        if (null == stkContainers) {
            return null;
        }
        Set<Container> containers = new HashSet<>();
        for (StkContainer stkContainer : stkContainers) {
            containers.add(toDto(stkContainer, lazy));
        }
        return containers;
    }
}
