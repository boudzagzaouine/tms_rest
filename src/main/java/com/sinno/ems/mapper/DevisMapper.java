package com.sinno.ems.mapper;

import com.sinno.ems.dto.Devis;
import com.sinno.ems.entities.CmdDevis;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by Enissay on 06/12/2016.
 */
public class DevisMapper {

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdDevisId");
        map.put("account", "cmdAccount");
        map.put("owner", "ownOwner");
        map.put("addressByDevisDeliveryAddress", "adrAddressByCmdDevisDeliveryAddressId");
        map.put("orderStatus", "prmOrderStatus");
        map.put("orderType", "prmOrderType");
        map.put("code", "cmdDevisCode");
        map.put("remarks", "cmdDevisRemarks");
        map.put("customerCode", "cmdDevisCustomerCode");
        map.put("description", "cmdDevisDescription");
        map.put("creationDate", "cmdDevisCreationDate");
        map.put("updateDate", "cmdDevisUpdateDate");
        map.put("numberLine", "cmdDevisNumberLine");
        map.put("numberLineCmd", "cmdDevisNumberLineCmd");
        map.put("transportTel", "cmdDevisTransportTel");
        map.put("transfertCode", "cmdDevisTransferCode");
        map.put("totalPriceHT", "cmdDevisTotalPriceHT");
        map.put("totalPriceHT", "cmdDevisTotalPriceTTC");
        map.put("currency", "prmCurrency");
        map.put("expectedDate", "cmdDevisExpectedDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static Devis toDto(CmdDevis cmdDevis, boolean lazy) {
        if (null == cmdDevis) {
            return null;
        }
        Devis devis = new Devis();
        devis.setCode(cmdDevis.getCmdDevisCode());
        devis.setContainers(cmdDevis.getCmdDevisContainers());
        devis.setCreationDate(cmdDevis.getCmdDevisCreationDate());
        devis.setCustomerCode(cmdDevis.getCmdDevisCustomerCode());
        devis.setDescription(cmdDevis.getCmdDevisDescription());
        devis.setId(cmdDevis.getCmdDevisId());
        devis.setRemarks(cmdDevis.getCmdDevisRemarks());
        devis.setUpdateDate(cmdDevis.getCmdDevisUpdateDate());
        devis.setVersion(cmdDevis.getCmdDevisVersion());
        devis.setDiscount(cmdDevis.getCmdDevisDiscount());
        devis.setTotalPriceHT(cmdDevis.getCmdDevisTotalPriceHT());
        devis.setTotalPriceTTC(cmdDevis.getCmdDevisTotalPriceTTC());
        devis.setVat(cmdDevis.getCmdDevisVat());
        devis.setExpectedDate(cmdDevis.getCmdDevisExpectedDate());
        if (!lazy) {
            devis.setCurrency(CurrencyMapper.toDto(cmdDevis.getPrmCurrency(), true));
            devis.setLines(DevisLineMapper.toDtos(cmdDevis.getCmdDevisLines(), false));
            devis.setAccount(AccountMapper.toDto(cmdDevis.getCmdAccount(), true));
            devis.setOrderStatus(OrderStatusMapper.toDto(cmdDevis.getPrmOrderStatus(), true));
            devis.setOrderType(OrderTypeMapper.toDto(cmdDevis.getPrmOrderType(), true));
            devis.setOwner(OwnerMapper.toDto(cmdDevis.getOwnOwner(), true));
//            devis.setStockArcs(DevisStockArcMapper.toDtos(cmdDevis.getCmdDevisStockArcs(), true));
//            devis.setStockReserveds(StockReservedMapper.toDtos(cmdDevis.getStkStockReserveds(), true));
//            devis.setStocks(DevisStockMapper.toDtos(cmdDevis.getCmdDevisStocks(), true));
            devis.setAddressByDeliveryDeliveryAddress(AddressMapper.toDto(cmdDevis.getAdrAddressByCmdDevisDeliveryAddressId(), true));
        }
        return devis;
    }

    public static CmdDevis toEntity(Devis devis, boolean lazy) {
        if (null == devis) {
            return null;
        }
        CmdDevis cmdDevis = new CmdDevis();
        cmdDevis.setCmdDevisCode(devis.getCode() != null ? devis.getCode().toUpperCase() : null);
        cmdDevis.setCmdDevisContainers(devis.getContainers());
        cmdDevis.setCmdDevisCreationDate(devis.getCreationDate());
        cmdDevis.setCmdDevisCustomerCode(devis.getCustomerCode());
        cmdDevis.setCmdDevisDescription(devis.getDescription());
        cmdDevis.setCmdDevisId(devis.getId());
        cmdDevis.setCmdDevisRemarks(devis.getRemarks());
        cmdDevis.setCmdDevisUpdateDate(devis.getUpdateDate());
        cmdDevis.setCmdDevisDiscount(devis.getDiscount());
        cmdDevis.setCmdDevisVersion(devis.getVersion());
        cmdDevis.setCmdDevisTotalPriceHT(devis.getTotalPriceHT());
        cmdDevis.setCmdDevisTotalPriceTTC(devis.getTotalPriceTTC());
        cmdDevis.setCmdDevisVat(devis.getVat());
        cmdDevis.setCmdDevisExpectedDate(devis.getExpectedDate());
        if (!lazy) {
            cmdDevis.setPrmCurrency(CurrencyMapper.toEntity(devis.getCurrency(), true));
            cmdDevis.setCmdAccount(AccountMapper.toEntity(devis.getAccount(), true));
            cmdDevis.setCmdDevisLines(DevisLineMapper.toEntities(devis.getLines(), false));
            cmdDevis.setAdrAddressByCmdDevisDeliveryAddressId(AddressMapper.toEntity(devis.getAddressByDeliveryDeliveryAddress(), true));
            cmdDevis.setOwnOwner(OwnerMapper.toEntity(devis.getOwner(), true));
            cmdDevis.setPrmOrderStatus(OrderStatusMapper.toEntity(devis.getOrderStatus(), true));
            cmdDevis.setPrmOrderType(OrderTypeMapper.toEntity(devis.getOrderType(), true));
            oneToMany(cmdDevis);
        }
        return cmdDevis;
    }

    public static void oneToMany(CmdDevis devis) {
        if (null != devis.getCmdDevisLines()) {
            devis.getCmdDevisLines().stream().forEach(sl -> {
                sl.setCmdDevis(devis);
                sl.setCmdDevisLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getCmdDevisLineId()) {
                    sl.setCmdDevisLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<Devis> toDtos(List<CmdDevis> cmdDeviss, boolean lazy) {
        if (null == cmdDeviss) {
            return null;
        }
        List<Devis> deviss = new ArrayList<>();
        for (CmdDevis cmdDevis : cmdDeviss) {
            deviss.add(toDto(cmdDevis, lazy));
        }
        return deviss;
    }

    public static List<Devis> toDtos(Iterable<CmdDevis> cmdDeviss, boolean lazy) {
        if (null == cmdDeviss) {
            return null;
        }
        List<Devis> deviss = new ArrayList<>();
        for (CmdDevis cmdDevis : cmdDeviss) {
            deviss.add(toDto(cmdDevis, lazy));
        }
        return deviss;
    }

    public static Set<CmdDevis> toEntities(Set<Devis> deviss, boolean lazy) {
        if (null == deviss) {
            return null;
        }
        Set<CmdDevis> cmdDeviss = new HashSet<>();
        for (Devis devis : deviss) {
            cmdDeviss.add(toEntity(devis, lazy));
        }
        return cmdDeviss;
    }

    public static Set<Devis> toDtos(Set<CmdDevis> cmdDeviss, boolean lazy) {
        if (null == cmdDeviss) {
            return null;
        }
        Set<Devis> deviss = new HashSet<>();
        for (CmdDevis cmdDevis : cmdDeviss) {
            deviss.add(toDto(cmdDevis, lazy));
        }
        return deviss;
    }
}
