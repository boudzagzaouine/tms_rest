/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.Warehouse;
import com.sinno.ems.entities.WrhWarehouse;

import java.util.*;

/**
 * @author aelguezzar
 */
public class WarehouseMapper {
    private WarehouseMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "wrhWarehouseId");
        map.put("address", "adrAddress");
        map.put("code", "wrhWarehouseCode");
        map.put("description", "wrhWarehouseDescription");
        map.put("creationDate", "wrhWarehouseCreationDate");
        map.put("updateDate", "wrhWarehouseUpdateDate");
        map.put("email", "wrhWarehouseEmail");
        map.put("telephone", "wrhWarehouseTel");
        map.put("active", "wrhWarehouseIsActive");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static Warehouse toDto(WrhWarehouse wrhWarehouse, boolean lazy) {
        if (null == wrhWarehouse) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setCode(wrhWarehouse.getWrhWarehouseCode());
        warehouse.setUpdateDate(wrhWarehouse.getWrhWarehouseUpdateDate());
        warehouse.setCreationDate(wrhWarehouse.getWrhWarehouseCreationDate());
        warehouse.setDescription(wrhWarehouse.getWrhWarehouseDescription());
        warehouse.setId(wrhWarehouse.getWrhWarehouseId());
        warehouse.setEmail(wrhWarehouse.getWrhWarehouseEmail());
        warehouse.setTelephone(wrhWarehouse.getWrhWarehouseTel());
        warehouse.setActive(wrhWarehouse.getWrhWarehouseIsActive());
        if (!lazy) {
            warehouse.setAddress(AddressMapper.toDto(wrhWarehouse.getAdrAddress(), true));
//            warehouse.setAisles(AisleMapper.toDtos(wrhWarehouse.getLocAisles(), true));
//            warehouse.setZones(ZoneMapper.toDtos(wrhWarehouse.getLocZones(), true));
//            warehouse.setContainerArcs(ContainerArcMapper.toDtos(wrhWarehouse.getStkContainerArcs(), true));
//            warehouse.setContainers(ContainerMapper.toDtos(wrhWarehouse.getStkContainers(), true));
//            warehouse.setLocations(LocationMapper.toDtos(wrhWarehouse.getLocLocations(), true));
//            warehouse.setProducts(ProductMapper.toDtos(wrhWarehouse.getPdtProducts(), true));
//            warehouse.setProducts_1(ProductMapper.toDtos(wrhWarehouse.getPdtProducts_1(), true));
//            warehouse.setPurshaseOrderLineArcs(
//                    PurshaseOrderLineArcMapper.toDtos(wrhWarehouse.getRcpPurshaseOrderLineArcs(), true));
//            warehouse.setPurshaseOrderLines(PurshaseOrderLineMapper.toDtos(wrhWarehouse.getRcpPurshaseOrderLines(), true));
//            warehouse.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(wrhWarehouse.getRcpReceptionLineArcs(), true));
//            warehouse.setReceptionLines(ReceptionLineMapper.toDtos(wrhWarehouse.getRcpReceptionLines(), true));
//            warehouse.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(wrhWarehouse.getRcpReceptionStockArcs(), true));
//            warehouse.setReceptionStocks(ReceptionStockMapper.toDtos(wrhWarehouse.getRcpReceptionStocks(), true));
//            warehouse.setSaleOrderArcs(SaleOrderArcMapper.toDtos(wrhWarehouse.getCmdSaleOrderArcs(), true));
//            warehouse.setSaleOrderLineArcs(SaleOrderLineArcMapper.toDtos(wrhWarehouse.getCmdSaleOrderLineArcs(), true));
//            warehouse.setSaleOrderLines(SaleOrderLineMapper.toDtos(wrhWarehouse.getCmdSaleOrderLines(), true));
//            warehouse.setSaleOrders(SaleOrderMapper.toDtos(wrhWarehouse.getCmdSaleOrders(), true));
//            warehouse.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(wrhWarehouse.getCmdSaleOrderStockArcs(), true));
//            warehouse.setSaleOrderStocks(SaleOrderStockMapper.toDtos(wrhWarehouse.getCmdSaleOrderStocks(), true));
//            warehouse.setStockArcs(StockArcMapper.toDtos(wrhWarehouse.getStkStockArcs(), true));
//            warehouse.setStockReserveds(StockReservedMapper.toDtos(wrhWarehouse.getStkStockReserveds(), true));
//            warehouse.setStocks(StockMapper.toDtos(wrhWarehouse.getStkStocks(), true));
        }
        return warehouse;
    }

    public static WrhWarehouse toEntity(Warehouse warehouse, boolean lazy) {
        if (null == warehouse) {
            return null;
        }
        WrhWarehouse wrhWarehouse = new WrhWarehouse();
        wrhWarehouse.setWrhWarehouseCode(warehouse.getCode() != null ? warehouse.getCode().toUpperCase() : null);
        wrhWarehouse.setWrhWarehouseCreationDate(warehouse.getCreationDate());
        wrhWarehouse.setWrhWarehouseDescription(warehouse.getDescription());
        wrhWarehouse.setWrhWarehouseId(warehouse.getId());
        wrhWarehouse.setWrhWarehouseUpdateDate(warehouse.getUpdateDate());
        wrhWarehouse.setWrhWarehouseEmail(warehouse.getEmail());
        wrhWarehouse.setWrhWarehouseTel(warehouse.getTelephone());
        wrhWarehouse.setWrhWarehouseIsActive(warehouse.getActive());
        if (!lazy) {
            wrhWarehouse.setAdrAddress(AddressMapper.toEntity(warehouse.getAddress(), true));
//            wrhWarehouse.setCmdSaleOrderArcs(SaleOrderArcMapper.toEntities(warehouse.getSaleOrderArcs(), true));
//            wrhWarehouse.setCmdSaleOrderLineArcs(SaleOrderLineArcMapper.toEntities(warehouse.getSaleOrderLineArcs(), true));
//            wrhWarehouse.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(warehouse.getSaleOrderLines(), true));
//            wrhWarehouse.setCmdSaleOrders(SaleOrderMapper.toEntities(warehouse.getSaleOrders(), true));
//            wrhWarehouse.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(warehouse.getSaleOrderStockArcs(), true));
//            wrhWarehouse.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(warehouse.getSaleOrderStocks(), true));
//            wrhWarehouse.setLocAisles(AisleMapper.toEntities(warehouse.getAisles(), true));
//            wrhWarehouse.setLocLocations(LocationMapper.toEntities(warehouse.getLocations(), true));
//            wrhWarehouse.setLocZones(ZoneMapper.toEntities(warehouse.getZones(), true));
//            wrhWarehouse.setPdtProducts(ProductMapper.toEntities(warehouse.getProducts(), true));
//            wrhWarehouse.setPdtProducts_1(ProductMapper.toEntities(warehouse.getProducts_1(), true));
//            wrhWarehouse.setRcpPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toEntities(warehouse.getPurshaseOrderLineArcs(), true));
//            wrhWarehouse.setRcpPurshaseOrderLines(PurshaseOrderLineMapper.toEntities(warehouse.getPurshaseOrderLines(), true));
//            wrhWarehouse.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(warehouse.getReceptionLineArcs(), true));
//            wrhWarehouse.setRcpReceptionLines(ReceptionLineMapper.toEntities(warehouse.getReceptionLines(), true));
//            wrhWarehouse.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(warehouse.getReceptionStockArcs(), true));
//            wrhWarehouse.setRcpReceptionStocks(ReceptionStockMapper.toEntities(warehouse.getReceptionStocks(), true));
//            wrhWarehouse.setStkContainerArcs(ContainerArcMapper.toEntities(warehouse.getContainerArcs(), true));
//            wrhWarehouse.setStkContainers(ContainerMapper.toEntities(warehouse.getContainers(), true));
//            wrhWarehouse.setStkStockArcs(StockArcMapper.toEntities(warehouse.getStockArcs(), true));
//            wrhWarehouse.setStkStockReserveds(StockReservedMapper.toEntities(warehouse.getStockReserveds(), true));
//            wrhWarehouse.setStkStocks(StockMapper.toEntities(warehouse.getStocks(), true));
        }
        return wrhWarehouse;
    }

    public static List<Warehouse> toDtos(List<WrhWarehouse> wrhWarehouses, boolean lazy) {
        if (null == wrhWarehouses) {
            return null;
        }
        List<Warehouse> warehouses = new ArrayList<>();
        for (WrhWarehouse wrhWarehouse : wrhWarehouses) {
            warehouses.add(toDto(wrhWarehouse, lazy));
        }
        return warehouses;
    }

    public static List<Warehouse> toDtos(Iterable<WrhWarehouse> wrhWarehouses, boolean lazy) {
        if (null == wrhWarehouses) {
            return null;
        }
        List<Warehouse> warehouses = new ArrayList<>();
        for (WrhWarehouse wrhWarehouse : wrhWarehouses) {
            warehouses.add(toDto(wrhWarehouse, lazy));
        }
        return warehouses;
    }

    public static Set<WrhWarehouse> toEntities(Set<Warehouse> warehouses, boolean lazy) {
        if (null == warehouses) {
            return null;
        }
        Set<WrhWarehouse> wrhWarehouses = new HashSet<>();
        for (Warehouse warehouse : warehouses) {
            wrhWarehouses.add(toEntity(warehouse, lazy));
        }
        return wrhWarehouses;
    }

    public static Set<Warehouse> toDtos(Set<WrhWarehouse> wrhWarehouses, boolean lazy) {
        if (null == wrhWarehouses) {
            return null;
        }
        Set<Warehouse> warehouses = new HashSet<>();
        for (WrhWarehouse wrhWarehouse : wrhWarehouses) {
            warehouses.add(toDto(wrhWarehouse, lazy));
        }
        return warehouses;
    }

}
