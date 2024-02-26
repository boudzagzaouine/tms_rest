package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Account;
import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.dto.PaymentRule;
import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;

import java.util.*;

public class OrderTransportInfoLineMapper {
    public OrderTransportInfoLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportInfoLineId");
        map.put("orderTransportInfo", "tmsOrderTransportInfo");

        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("turnLines", "tmsOrderTransportInfoLineLines");
        map.put("turnStatus", "tmsTurnStatus");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("dateArriver", "tmsOrderTranspotInfoLineDateArriver");
        map.put("dateCommancerChargement", "tmsOrderTranspotInfoLineDateCommancerChargement");
        map.put("dateCommancerDechargement", "tmsOrderTranspotInfoLineDateCommancerDechargement");
        map.put("dateFinChargement", "tmsOrderTranspotInfoLineDateFinChargement");
        map.put("dateFinDechargement", "tmsOrderTranspotInfoLineDateFinDechargement");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsOrderTransportInfoLine toEntity(OrderTransportInfoLine orderTransportInfoLine, boolean lazy) {
        if (null == orderTransportInfoLine) {
            return null;
        }
        TmsOrderTransportInfoLine tmsOrderTransportInfoLine = new TmsOrderTransportInfoLine();
        tmsOrderTransportInfoLine.setTmsOrderTransportInfoLineId(orderTransportInfoLine.getId());

        tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfoNumberOfPalletEnlevement(orderTransportInfoLine.getNumberOfPalletEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportWeightEnlevement(orderTransportInfoLine.getWeightEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportCapacityEnlevement(orderTransportInfoLine.getCapacityEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportCommentEnlevement(orderTransportInfoLine.getCommentEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportContreBlEnlevement(orderTransportInfoLine.getContreBlEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportContreFactureEnlevement(orderTransportInfoLine.getContreFactureEnlevement());

        tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfoNumberOfPalletLivraison(orderTransportInfoLine.getNumberOfPalletLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportWeightLivraison(orderTransportInfoLine.getWeightLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportCapacityLivraison(orderTransportInfoLine.getCapacityLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportCommentLivraison(orderTransportInfoLine.getCommentLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportContreBlLivraison(orderTransportInfoLine.getContreBlLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportContreFactureLivraison(orderTransportInfoLine.getContreFactureLivraison());

        tmsOrderTransportInfoLine.setTmsOrderTransportLineNumber(orderTransportInfoLine.getLineNumber());
        tmsOrderTransportInfoLine.setTmsPaymentAmountEnlevement(orderTransportInfoLine.getPaymentAmountEnlevement());
        tmsOrderTransportInfoLine.setTmsPaymentAmountLivraison(orderTransportInfoLine.getPaymentAmountLivraison());

        tmsOrderTransportInfoLine.setTmsOrderTransportDateEnlevement(orderTransportInfoLine.getDateEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportDateLivraison(orderTransportInfoLine.getDateLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTranspotInfoLineDateArriver(orderTransportInfoLine.getDateArriver());
        tmsOrderTransportInfoLine.setTmsOrderTranspotInfoLineDateCommancerChargement(orderTransportInfoLine.getDateCommancerChargement());
        tmsOrderTransportInfoLine.setTmsOrderTranspotInfoLineDateFinChargement(orderTransportInfoLine.getDateFinChargement());
        tmsOrderTransportInfoLine.setTmsOrderTranspotInfoLineDateCommancerDechargement(orderTransportInfoLine.getDateCommancerDechargement());
        tmsOrderTransportInfoLine.setTmsOrderTranspotInfoLineDateFinDechargement(orderTransportInfoLine.getDateFinDechargement());

        tmsOrderTransportInfoLine.setTmsOrderTransportLinePriceHT(orderTransportInfoLine.getPriceHT());
        tmsOrderTransportInfoLine.setTmsOrderTransportLinePriceTTC(orderTransportInfoLine.getPriceTTC());
        tmsOrderTransportInfoLine.setTmsOrderTransportCloseDate(orderTransportInfoLine.getCloseDate());


        if (!lazy) {

            tmsOrderTransportInfoLine.setCmdAccount(AccountMapper.toEntity(orderTransportInfoLine.getAccount(), true));
           // tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfo(AddressContactOrderTransportInfoMapper.toEntity(orderTransportInfoLine.getAddressContactDeliveryInfo(), true));
            tmsOrderTransportInfoLine.setAdrAddress(AddressMapper.toEntity(orderTransportInfoLine.getAddress(), false));
            tmsOrderTransportInfoLine.setPrmContact(ContactMapper.toEntity(orderTransportInfoLine.getContact(), false));

            tmsOrderTransportInfoLine.setTmsOrderTransportType(OrderTransportTypeMapper.toEntity(orderTransportInfoLine.getOrderTransportType(), true));
            tmsOrderTransportInfoLine.setTmsOrderTransportInfo(OrderTransportInfoMapper.toEntity(orderTransportInfoLine.getOrderTransportInfo(), true));
            tmsOrderTransportInfoLine.setTmsTurnStatus(TurnStatusMapper.toEntity(orderTransportInfoLine.getTurnStatus(), true));
            tmsOrderTransportInfoLine.setPrmPaymentTypeEnlevement(PaymentTypeMapper.toEntity(orderTransportInfoLine.getPaymentTypeEnlevement(), true));
            tmsOrderTransportInfoLine.setPrmPaymentTypeLivraison(PaymentTypeMapper.toEntity(orderTransportInfoLine.getPaymentTypeLivraison(), true));
            //tmsOrderTransportInfoLine.setTmsOrderTransportInfoLineDocumentSet(OrderTransportInfoLineDocumentMapper.toEntities(orderTransportInfoLine.getOrderTransportInfoLineDocuments(), false));

            tmsOrderTransportInfoLine.setTmsOrderTransportLineVat(VatMapper.toEntity(orderTransportInfoLine.getVat(), false));
           // oneToMany(tmsOrderTransportInfoLine);




        }
        return tmsOrderTransportInfoLine;

    }

    //private static void oneToMany(TmsOrderTransportInfoLine tmsOrderTransportInfoLine){
      //  tmsOrderTransportInfoLine.getTmsOrderTransportInfoLineDocumentSet().forEach(
         //       e->{
           //         if(0>=e.getTmsOrderTransportInfoLineDocumentId())
           //             e.setTmsOrderTransportInfoLineDocumentId(0L);
             //       e.setCreationDate(new Date());
               //     e.setTmsOrderTransportInfoLine(tmsOrderTransportInfoLine);
                //}
        //);}


    public static OrderTransportInfoLine toDto(TmsOrderTransportInfoLine tmsOrderTransportInfoLine, boolean lazy) {
        if (null == tmsOrderTransportInfoLine) {
            return null;
        }
        OrderTransportInfoLine orderTransportInfoLine = new OrderTransportInfoLine();
        orderTransportInfoLine.setId( tmsOrderTransportInfoLine.getTmsOrderTransportInfoLineId());

        orderTransportInfoLine.setNumberOfPalletEnlevement(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfoNumberOfPalletEnlevement());
        orderTransportInfoLine.setWeightEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportWeightEnlevement());
        orderTransportInfoLine.setCapacityEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportCapacityEnlevement());
       orderTransportInfoLine.setCommentEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportCommentEnlevement());
        orderTransportInfoLine.setContreBlEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportContreBlEnlevement());
        orderTransportInfoLine.setContreFactureEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportContreFactureEnlevement());

        orderTransportInfoLine.setNumberOfPalletLivraison(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfoNumberOfPalletLivraison());
        orderTransportInfoLine.setWeightLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportWeightLivraison());
        orderTransportInfoLine.setCapacityLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportCapacityLivraison());
        orderTransportInfoLine.setCommentLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportCommentLivraison());
        orderTransportInfoLine.setContreBlLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportContreBlLivraison());
        orderTransportInfoLine.setContreFactureLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportContreFactureLivraison());

        orderTransportInfoLine.setLineNumber(tmsOrderTransportInfoLine.getTmsOrderTransportLineNumber());
        orderTransportInfoLine.setPaymentAmountEnlevement(tmsOrderTransportInfoLine.getTmsPaymentAmountEnlevement());
        orderTransportInfoLine.setPaymentAmountLivraison(tmsOrderTransportInfoLine.getTmsPaymentAmountLivraison());

        orderTransportInfoLine.setDateEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportDateEnlevement());
        orderTransportInfoLine.setDateLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportDateLivraison());
        orderTransportInfoLine.setDateArriver(tmsOrderTransportInfoLine.getTmsOrderTranspotInfoLineDateArriver());
        orderTransportInfoLine.setDateCommancerChargement(tmsOrderTransportInfoLine.getTmsOrderTranspotInfoLineDateCommancerChargement());
        orderTransportInfoLine.setDateCommancerDechargement(tmsOrderTransportInfoLine.getTmsOrderTranspotInfoLineDateCommancerDechargement());
        orderTransportInfoLine.setDateFinChargement(tmsOrderTransportInfoLine.getTmsOrderTranspotInfoLineDateFinChargement());
        orderTransportInfoLine.setDateFinDechargement(tmsOrderTransportInfoLine.getTmsOrderTranspotInfoLineDateFinDechargement());

        orderTransportInfoLine.setPriceHT(tmsOrderTransportInfoLine.getTmsOrderTransportLinePriceHT());
        orderTransportInfoLine.setPriceTTC(tmsOrderTransportInfoLine.getTmsOrderTransportLinePriceTTC());
        orderTransportInfoLine.setCloseDate(tmsOrderTransportInfoLine.getTmsOrderTransportCloseDate());


        if (!lazy) {

            orderTransportInfoLine.setAccount(AccountMapper.toDto(tmsOrderTransportInfoLine.getCmdAccount(), true));

//            orderTransportInfoLine.setAddressContactDeliveryInfo(AddressContactOrderTransportInfoMapper.toDto(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfo(), true));
            orderTransportInfoLine.setAddress(AddressMapper.toDto(tmsOrderTransportInfoLine.getAdrAddress(), false));
            orderTransportInfoLine.setContact(ContactMapper.toDto(tmsOrderTransportInfoLine.getPrmContact(), false));

            orderTransportInfoLine.setOrderTransportType(OrderTransportTypeMapper.toDto(tmsOrderTransportInfoLine.getTmsOrderTransportType(), true));

            orderTransportInfoLine.setOrderTransportInfo(OrderTransportInfoMapper.toDto(tmsOrderTransportInfoLine.getTmsOrderTransportInfo(), true));
            orderTransportInfoLine.setTurnStatus(TurnStatusMapper.toDto(tmsOrderTransportInfoLine.getTmsTurnStatus(), true));
            orderTransportInfoLine.setPaymentTypeEnlevement(PaymentTypeMapper.toDto(tmsOrderTransportInfoLine.getPrmPaymentTypeEnlevement(), true));
            orderTransportInfoLine.setPaymentTypeLivraison(PaymentTypeMapper.toDto(tmsOrderTransportInfoLine.getPrmPaymentTypeLivraison(), true));
         //   orderTransportInfoLine.setOrderTransportInfoLineDocuments(OrderTransportInfoLineDocumentMapper.toDtos(tmsOrderTransportInfoLine.getTmsOrderTransportInfoLineDocumentSet(), false));

            orderTransportInfoLine.setVat(VatMapper.toDto(tmsOrderTransportInfoLine.getTmsOrderTransportLineVat(), false));

        }
        return orderTransportInfoLine;

    }


    public static List<OrderTransportInfoLine> toDtos(Iterable<? extends TmsOrderTransportInfoLine> tmsOrderTransportInfoLines, boolean lazy) {
        if (null == tmsOrderTransportInfoLines) {
            return null;
        }
        List<OrderTransportInfoLine> turns = new ArrayList<>();
        for (TmsOrderTransportInfoLine tmsOrderTransportInfoLine : tmsOrderTransportInfoLines) {
            turns.add(toDto(tmsOrderTransportInfoLine, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderTransportInfoLine> toEntities(List< OrderTransportInfoLine> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderTransportInfoLine> tmsOrderTransportInfoLines = new HashSet<>();

        for (OrderTransportInfoLine orderTransportInfoLine : turns) {
            tmsOrderTransportInfoLines.add(toEntity(orderTransportInfoLine, lazy));
        }
        return tmsOrderTransportInfoLines;
    }

    public static List<OrderTransportInfoLine> toDtos(List< TmsOrderTransportInfoLine> tmsOrderTransportInfoLines, boolean lazy) {
        if (null == tmsOrderTransportInfoLines) {
            return null;
        }
        List<OrderTransportInfoLine> turns = new ArrayList<>();
        for (TmsOrderTransportInfoLine tmsOrderTransportInfoLine : tmsOrderTransportInfoLines) {
            turns.add(toDto(tmsOrderTransportInfoLine, lazy));
        }
        return turns;
    }



}
