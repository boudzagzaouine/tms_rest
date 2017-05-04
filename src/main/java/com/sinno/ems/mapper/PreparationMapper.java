package com.sinno.ems.mapper;

import com.sinno.ems.dto.Preparation;
import com.sinno.ems.dto.Warehouse;
import com.sinno.ems.entities.CmdDelivery;
import com.sinno.ems.entities.CmdPreparation;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PreparationMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdPreparationId");
        map.put("code", "cmdPreparationCode");
        map.put("creationDate", "cmdPreparationCreationDate");
        map.put("updateDate", "cmdPreparationUpdateDate");
        map.put("preparationDate", "cmdPreparationDate");
        map.put("account", "cmdAccount");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("owner", "ownOwner");
        map.put("warehouse", "wrhWarehouse");
        map.put("orderType", "prmOrderType");
        map.put("orderStatus", "prmOrderStatus");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdPreparation toEntity(Preparation preparation, boolean lazy) {
        if (null == preparation) {
            return null;
        }
        CmdPreparation cmdPreparation = new CmdPreparation();
        cmdPreparation.setCmdPreparationCode(preparation.getCode());
        cmdPreparation.setCmdPreparationId(preparation.getId());
        cmdPreparation.setCmdPreparationDate(preparation.getPreparationDate());
        cmdPreparation.setCmdPreparationCreationDate(preparation.getCreationDate());
        cmdPreparation.setCmdPreparationUpdateDate(preparation.getUpdateDate());
        if (!lazy) {
            cmdPreparation.setPrmOrderType(OrderTypeMapper.toEntity(preparation.getOrderType(), true));
            cmdPreparation.setPrmOrderStatus(OrderStatusMapper.toEntity(preparation.getOrderStatus(), true));
            cmdPreparation.setCmdAccount(AccountMapper.toEntity(preparation.getAccount(), true));
            cmdPreparation.setCmdSaleOrder(SaleOrderMapper.toEntity(preparation.getSaleOrder(), true));
            cmdPreparation.setOwnOwner(OwnerMapper.toEntity(preparation.getOwner(), true));
            cmdPreparation.setWrhWarehouse(WarehouseMapper.toEntity(preparation.getWarehouse(), true));
            cmdPreparation.setCmdPreparationLines(PreparationLineMapper.toEntities(preparation.getPreparationLines(), false));
            oneToMany(cmdPreparation);
        }

        return cmdPreparation;
    }

    public static Preparation toDto(CmdPreparation cmdPreparation, boolean lazy) {
        if (null == cmdPreparation) {
            return null;
        }

        Preparation preparation = new Preparation();
        preparation.setCode(cmdPreparation.getCmdPreparationCode());
        preparation.setId(cmdPreparation.getCmdPreparationId());
        preparation.setPreparationDate(cmdPreparation.getCmdPreparationDate());
        preparation.setCreationDate(cmdPreparation.getCmdPreparationCreationDate());
        preparation.setUpdateDate(cmdPreparation.getCmdPreparationUpdateDate());

        if (!lazy) {
            preparation.setOrderStatus(OrderStatusMapper.toDto(cmdPreparation.getPrmOrderStatus(), true));
            preparation.setOrderType(OrderTypeMapper.toDto(cmdPreparation.getPrmOrderType(), true));
            preparation.setOwner(OwnerMapper.toDto(cmdPreparation.getOwnOwner(), true));
            preparation.setWarehouse(WarehouseMapper.toDto(cmdPreparation.getWrhWarehouse(), true));
            preparation.setAccount(AccountMapper.toDto(cmdPreparation.getCmdAccount(), true));
            preparation.setSaleOrder(SaleOrderMapper.toDto(cmdPreparation.getCmdSaleOrder(), true));
            preparation.setPreparationLines(PreparationLineMapper.toDtos(cmdPreparation.getCmdPreparationLines(), false));
        }

        return preparation;
    }

    public static List<Preparation> toDtos(List<CmdPreparation> cmdPreparations, boolean lazy) {
        if (null == cmdPreparations) {
            return null;
        }
        List<Preparation> preparations = new ArrayList<>();
        for (CmdPreparation cmdPreparation : cmdPreparations) {
            preparations.add(toDto(cmdPreparation, lazy));
        }
        return preparations;
    }

    public static List<Preparation> toDtos(Iterable<CmdPreparation> cmdPreparations, boolean lazy) {
        if (null == cmdPreparations) {
            return null;
        }
        List<Preparation> preparations = new ArrayList<>();
        for (CmdPreparation cmdPreparation : cmdPreparations) {
            preparations.add(toDto(cmdPreparation, lazy));
        }
        return preparations;
    }

    public static Set<CmdPreparation> toEntities(Set<Preparation> preparations, boolean lazy) {
        if (null == preparations) {
            return null;
        }
        Set<CmdPreparation> cmdPreparations = new HashSet<>();
        for (Preparation preparation : preparations) {
            cmdPreparations.add(toEntity(preparation, lazy));
        }
        return cmdPreparations;
    }

    public static Set<Preparation> toDtos(Set<CmdPreparation> cmdPreparations, boolean lazy) {
        if (null == cmdPreparations) {
            return null;
        }
        Set<Preparation> preparations = new HashSet<>();
        for (CmdPreparation cmdPreparation : cmdPreparations) {
            preparations.add(toDto(cmdPreparation, lazy));
        }
        return preparations;
    }

    public static void oneToMany(CmdPreparation cmdPreparation) {
        if (null != cmdPreparation.getCmdPreparationLines()) {
            cmdPreparation.getCmdPreparationLines().stream().forEach(rl -> {
                rl.setCmdPreparation(cmdPreparation);
//                if (null != rl.getCmdDevisLine())
//                    rl.setCmdDeliveryLineOrderQuantity(rl.getCmdDevisLine().getCmdSaleOrderLineQuantity());
                rl.setCmdPreparationLineUpdateDate(EmsDate.getDateNow());
                rl.setOwnOwner(cmdPreparation.getOwnOwner());
                rl.setWrhWarehouse(cmdPreparation.getWrhWarehouse());
                if (0 >= rl.getCmdPreparationLineId()) {
                    rl.setCmdPreparationLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }
}


