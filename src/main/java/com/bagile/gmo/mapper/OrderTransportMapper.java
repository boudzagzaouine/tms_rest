package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.entities.TmsOrderTransport;


import java.util.*;

public class  OrderTransportMapper {
    public OrderTransportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportId");
        map.put("code", "tmsOrderTransportCode");

        map.put("vehicle", "tmsVehicle");
        map.put("company", "cmdCompany");
        map.put("date", "tmsOrderTransportDate");
        map.put("loadingType", "tmsOrderTransportLoadingType");

        map.put("transport", "trpTransport");
        map.put("turnType", "tmsOrderTransportType");
        map.put("turnStatus", "tmsTurnStatus");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsOrderTransport toEntity(OrderTransport orderTransport, boolean lazy) {
        if (null == orderTransport) {
            return null;
        }
        TmsOrderTransport tmsOrderTransport = new TmsOrderTransport();
        tmsOrderTransport.setTmsOrderTransportId(orderTransport.getId());
        tmsOrderTransport.setTmsOrderTransportCode(orderTransport.getCode());
        tmsOrderTransport.setTmsOrderTransportDate(orderTransport.getDate());
        tmsOrderTransport.setTmsOrderTransportPriceHT(orderTransport.getPriceHT());
        tmsOrderTransport.setTmsOrderTransportPriceTTC(orderTransport.getPriceTTC());
        tmsOrderTransport.setTmsOrderTransportPriceVat(orderTransport.getPriceVat());

        tmsOrderTransport.setTmsOrderTransportMarginRate(orderTransport.getMarginRate());
        tmsOrderTransport.setTmsOrderTransportMarginValue(orderTransport.getMarginValue());

        tmsOrderTransport.setTmsOrderTransportConsignment(orderTransport.getConsignment());
        tmsOrderTransport.setTmsOrderTransportPort(orderTransport.getPort());
        tmsOrderTransport.setTmsOrderTransportPalletResponsibility(orderTransport.getPalletResponsibility());

        tmsOrderTransport.setTmsOrderTransportTotalPriceHT(orderTransport.getTotalPriceHT());
        tmsOrderTransport.setTmsOrderTransportTotalPriceTTC(orderTransport.getTotalPriceTTC());
        tmsOrderTransport.setTmsOrderTransportTotalPriceVat(orderTransport.getTotalPriceVat());


        if (!lazy) {
            tmsOrderTransport.setCmdAccount(AccountMapper.toEntity(orderTransport.getAccount(), true));
            tmsOrderTransport.setTmsOrderTransportType(TurnTypeMapper.toEntity(orderTransport.getTurnType(), true));
            tmsOrderTransport.setTmsTurnStatus(TurnStatusMapper.toEntity(orderTransport.getTurnStatus(), true));
            tmsOrderTransport.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(orderTransport.getVehicleCategory(), true));
            tmsOrderTransport.setTmsOrderTransportLoadingType(LoadingTypeMapper.toEntity(orderTransport.getLoadingType(), true));
            tmsOrderTransport.setTmsVehicleTray(VehicleTrayMapper.toEntity(orderTransport.getVehicleTray(), true));
            tmsOrderTransport.setPrmVat(VatMapper.toEntity(orderTransport.getVat(), true));
            tmsOrderTransport.setPrmContact(ContactMapper.toEntity(orderTransport.getContact(), true));
            tmsOrderTransport.setTmsTrajet(TrajetMapper.toEntity(orderTransport.getTrajet(), false));
            tmsOrderTransport.setTmsOrderTransportPackagingType(PackagingTypeMapper.toEntity(orderTransport.getPackagingType(), true));
            tmsOrderTransport.setTmsOrderTransportMarchandiseType(MarchandiseTypeMapper.toEntity(orderTransport.getMarchandiseType(), true));
            tmsOrderTransport.setOrderTransportServiceCatalogs(TransportPlanServiceCatalogMapper.toEntities(orderTransport.getOrderTransportServiceCatalogs(), false));
            tmsOrderTransport.setTmsOrderTransportAccompaniments(OrderTransportAccompanimentMapper.toEntities(orderTransport.getOrderTransportAccompaniments(), false));

//           tmsOrderTransport.setTmsOrderTransportInfoAller(OrderTransportInfoMapper.toEntity(orderTransport.getOrderTransportInfoAller(), false));
         //  tmsOrderTransport.setTmsOrderTransportInfoRetour(OrderTransportInfoMapper.toEntity(orderTransport.getOrderTransportInfoRetour(), false));
  oneToMany(tmsOrderTransport);
        }
        return tmsOrderTransport;

    }

    private static void oneToMany(TmsOrderTransport tmsOrderTransport){
        tmsOrderTransport.getOrderTransportServiceCatalogs().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setTmsOrderTransport(tmsOrderTransport);
                }
        );
        tmsOrderTransport.getTmsOrderTransportAccompaniments().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setTmsOrderTransport(tmsOrderTransport);
                }
        );


    }


    public static OrderTransport toDto(TmsOrderTransport tmsOrderTransport, boolean lazy) {
        if (null == tmsOrderTransport) {
            return null;
        }
        OrderTransport orderTransport = new OrderTransport();
        orderTransport.setId( tmsOrderTransport.getTmsOrderTransportId());
        orderTransport.setDate(tmsOrderTransport.getTmsOrderTransportDate());
        orderTransport.setCode(tmsOrderTransport.getTmsOrderTransportCode());
        orderTransport.setPriceHT(tmsOrderTransport.getTmsOrderTransportPriceHT());
        orderTransport.setPriceTTC(tmsOrderTransport.getTmsOrderTransportPriceTTC());
        orderTransport.setPriceVat(tmsOrderTransport.getTmsOrderTransportPriceVat());

        orderTransport.setMarginRate(tmsOrderTransport.getTmsOrderTransportMarginRate());
        orderTransport.setMarginValue(tmsOrderTransport.getTmsOrderTransportMarginValue());

        orderTransport.setConsignment(tmsOrderTransport.getTmsOrderTransportConsignment());
        orderTransport.setPort(tmsOrderTransport.getTmsOrderTransportPort());
        orderTransport.setPalletResponsibility(tmsOrderTransport.getTmsOrderTransportPalletResponsibility());

        orderTransport.setTotalPriceHT(tmsOrderTransport.getTmsOrderTransportTotalPriceHT());
        orderTransport.setTotalPriceTTC(tmsOrderTransport.getTmsOrderTransportTotalPriceTTC());
        orderTransport.setTotalPriceVat(tmsOrderTransport.getTmsOrderTransportTotalPriceVat());

        if (!lazy) {
            orderTransport.setTurnType(TurnTypeMapper.toDto(tmsOrderTransport.getTmsOrderTransportType(), true));
            orderTransport.setTurnStatus(TurnStatusMapper.toDto(tmsOrderTransport.getTmsTurnStatus(), true));
            orderTransport.setAccount(AccountMapper.toDto(tmsOrderTransport.getCmdAccount(), false));
            orderTransport.setVehicleCategory(VehicleCategoryMapper.toDto(tmsOrderTransport.getGmoVehicleCategory(), true));
            orderTransport.setLoadingType(LoadingTypeMapper.toDto(tmsOrderTransport.getTmsOrderTransportLoadingType(), true));
            orderTransport.setVehicleTray(VehicleTrayMapper.toDto(tmsOrderTransport.getTmsVehicleTray(), true));
            orderTransport.setVat(VatMapper.toDto(tmsOrderTransport.getPrmVat(), true));
            orderTransport.setContact(ContactMapper.toDto(tmsOrderTransport.getPrmContact(), true));
            orderTransport.setTrajet(TrajetMapper.toDto(tmsOrderTransport.getTmsTrajet(), false));
            orderTransport.setPackagingType(PackagingTypeMapper.toDto(tmsOrderTransport.getTmsOrderTransportPackagingType(), true));
            orderTransport.setMarchandiseType(MarchandiseTypeMapper.toDto(tmsOrderTransport.getTmsOrderTransportMarchandiseType(), true));
            orderTransport.setOrderTransportServiceCatalogs(TransportPlanServiceCatalogMapper.toDtos(tmsOrderTransport.getOrderTransportServiceCatalogs(), false));
            orderTransport.setOrderTransportAccompaniments(OrderTransportAccompanimentMapper.toDtos(tmsOrderTransport.getTmsOrderTransportAccompaniments(), false));

          // orderTransport.setOrderTransportInfoAller(OrderTransportInfoMapper.toDto(tmsOrderTransport.getTmsOrderTransportInfoAller(), false));
           //orderTransport.setOrderTransportInfoRetour(OrderTransportInfoMapper.toDto(tmsOrderTransport.getTmsOrderTransportInfoRetour(), false));



        }
        return orderTransport;

    }



    public static List<OrderTransport> toDtos(Iterable<? extends TmsOrderTransport> tmsOrderTransports, boolean lazy) {
        if (null == tmsOrderTransports) {
            return null;
        }
        List<OrderTransport> turns = new ArrayList<>();
        for (TmsOrderTransport tmsOrderTransport : tmsOrderTransports) {
            turns.add(toDto(tmsOrderTransport, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderTransport> toEntities(Set<? extends OrderTransport> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderTransport> tmsOrderTransports = new HashSet<>();

        for (OrderTransport orderTransport : turns) {
            tmsOrderTransports.add(toEntity(orderTransport, lazy));
        }
        return tmsOrderTransports;
    }

    public static Set<OrderTransport> toDtos(Set<? extends TmsOrderTransport> tmsOrderTransports, boolean lazy) {
        if (null == tmsOrderTransports) {
            return null;
        }
        Set<OrderTransport> turns = new HashSet<>();
        for (TmsOrderTransport tmsOrderTransport : tmsOrderTransports) {
            turns.add(toDto(tmsOrderTransport, lazy));
        }
        return turns;
    }

}
