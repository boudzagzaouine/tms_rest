/**
 *
 */
package com.bagile.tms.mapper;

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
