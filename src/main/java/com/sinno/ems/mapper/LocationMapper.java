/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.Location;
import com.sinno.ems.entities.LocLocation;

import java.util.*;

/**
 * @author aelguezzar
 */
public class LocationMapper {
    private LocationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "locLocationId");
        map.put("zone", "locZone");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "locLocationCode");
        map.put("active", "locLocationIsActive");
        map.put("creationDate", "locLocationCreationDate");
        map.put("updateDate", "locLocationUpdateDate");
        map.put("locationpicking", "locLocationpicking");
        map.put("locationreserve", "locLocationreserve");
        map.put("locationStatus", "prmLocationStatus");
        map.put("orderStatus", "prmOrderStatus");
        map.put("defaultLocation", "locLocationDefaultLocation");
        map.put("wmsId", "locLocationWmsId");


    }


    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static Location toDto(LocLocation locLocation, boolean lazy) {
        if (null == locLocation) {
            return null;
        }
        Location location = new Location();
        location.setActive(locLocation.getLocLocationIsActive());
        location.setCode(locLocation.getLocLocationCode());
        location.setCreationDate(locLocation.getLocLocationCreationDate());
        location.setId(locLocation.getLocLocationId());
        location.setUpdateDate(locLocation.getLocLocationUpdateDate());
        location.setPicking(locLocation.getLocLocationPicking());
        location.setReserve(locLocation.getLocLocationReserve());
        location.setWmsId(locLocation.getLocLocationWmsId());
        location.setDefaultLocation(locLocation.getLocLocationDefaultLocation());
        if (!lazy) {
            location.setProducts(ProductMapper.toDtos(locLocation.getPdtProducts(), true));
            location.setWarehouse(WarehouseMapper.toDto(locLocation.getWrhWarehouse(), true));
            location.setZone(ZoneMapper.toDto(locLocation.getLocZone(), true));
            location.setLocationStatus(LocationStatusMapper.toDto(locLocation.getPrmLocationStatus(), true));
            location.setOrderStatus(OrderStatusMapper.toDto(locLocation.getPrmOrderStatus(), true));
//            location.setContainerArcs(ContainerArcMapper.toDtos(locLocation.getStkContainerArcs(), true));
//            location.setContainers(ContainerMapper.toDtos(locLocation.getStkContainers(), true));
//            location.setPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toDtos(locLocation.getRcpPurshaseOrderLineArcs(), true));
//            location.setPurshaseOrderLines(PurshaseOrderLineMapper.toDtos(locLocation.getRcpPurshaseOrderLines(), true));
//            location.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(locLocation.getRcpReceptionLineArcs(), true));
//            location.setReceptionLines(ReceptionLineMapper.toDtos(locLocation.getRcpReceptionLines(), true));
//            location.setSaleOrderLineArcs(SaleOrderLineArcMapper.toDtos(locLocation.getCmdSaleOrderLineArcs(), true));
//            location.setSaleOrderLines(SaleOrderLineMapper.toDtos(locLocation.getCmdSaleOrderLines(), true));
//            location.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(locLocation.getCmdSaleOrderStockArcs(), true));
//            location.setSaleOrderStocks(SaleOrderStockMapper.toDtos(locLocation.getCmdSaleOrderStocks(), true));
//            location.setStockArcs(StockArcMapper.toDtos(locLocation.getStkStockArcs(), true));
//            location.setStocks(StockMapper.toDtos(locLocation.getStkStocks(), true));
        }
        return location;
    }

    public static LocLocation toEntity(Location location, boolean lazy) {
        if (null == location) {
            return null;
        }
        LocLocation locLocation = new LocLocation();
        locLocation.setLocLocationCode(location.getCode() != null ? location.getCode().toUpperCase() : null);
        locLocation.setLocLocationCreationDate(location.getCreationDate());
        locLocation.setLocLocationId(location.getId());
        locLocation.setLocLocationIsActive(location.getActive());
        locLocation.setLocLocationUpdateDate(location.getUpdateDate());
        locLocation.setLocLocationPicking(location.getPicking());
        locLocation.setLocLocationReserve(location.getReserve());
        locLocation.setLocLocationWmsId(location.getWmsId());
        locLocation.setLocLocationDefaultLocation(location.getDefaultLocation());
        if (!lazy) {
            locLocation.setPrmLocationStatus(LocationStatusMapper.toEntity(location.getLocationStatus(), true));
            locLocation.setPrmOrderStatus(OrderStatusMapper.toEntity(location.getOrderStatus(), true));
            locLocation.setLocZone(ZoneMapper.toEntity(location.getZone(), true));
            locLocation.setPdtProducts(ProductMapper.toEntities(location.getProducts(), true));
            locLocation.setWrhWarehouse(WarehouseMapper.toEntity(location.getWarehouse(), true));
            locLocation.setCmdSaleOrderLineArcs(SaleOrderLineArcMapper.toEntities(location.getSaleOrderLineArcs(), true));
            locLocation.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(location.getSaleOrderLines(), true));
            locLocation.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(location.getSaleOrderStockArcs(), true));
            locLocation.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(location.getSaleOrderStocks(), true));
            locLocation.setRcpPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toEntities(location.getPurshaseOrderLineArcs(), true));
            locLocation.setRcpPurshaseOrderLines(PurshaseOrderLineMapper.toEntities(location.getPurshaseOrderLines(), true));
            locLocation.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(location.getReceptionLineArcs(), true));
            locLocation.setRcpReceptionLines(ReceptionLineMapper.toEntities(location.getReceptionLines(), true));
            locLocation.setStkContainerArcs(ContainerArcMapper.toEntities(location.getContainerArcs(), true));
            locLocation.setStkContainers(ContainerMapper.toEntities(location.getContainers(), true));
            locLocation.setStkStockArcs(StockArcMapper.toEntities(location.getStockArcs(), true));
            locLocation.setStkStocks(StockMapper.toEntities(location.getStocks(), true));

        }
        return locLocation;
    }

    public static List<Location> toDtos(List<LocLocation> locLocations, boolean lazy) {
        if (null == locLocations) {
            return null;
        }
        List<Location> locations = new ArrayList<>();
        for (LocLocation locLocation : locLocations) {
            locations.add(toDto(locLocation, lazy));
        }
        return locations;
    }

    public static List<Location> toDtos(Iterable<LocLocation> locLocations, boolean lazy) {
        if (null == locLocations) {
            return null;
        }
        List<Location> locations = new ArrayList<>();
        for (LocLocation locLocation : locLocations) {
            locations.add(toDto(locLocation, lazy));
        }
        return locations;
    }

    public static Set<LocLocation> toEntities(Set<Location> locations, boolean lazy) {
        if (null == locations) {
            return null;
        }
        Set<LocLocation> locLocations = new HashSet<>();
        for (Location location : locations) {
            locLocations.add(toEntity(location, lazy));
        }
        return locLocations;
    }

    public static Set<Location> toDtos(Set<LocLocation> locLocations, boolean lazy) {
        if (null == locLocations) {
            return null;
        }
        Set<Location> locations = new HashSet<>();
        for (LocLocation locLocation : locLocations) {
            locations.add(toDto(locLocation, lazy));
        }
        return locations;
    }

}
