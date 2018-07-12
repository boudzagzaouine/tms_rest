package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 24/01/2017.
 */
public class PromotionMapper {
    private PromotionMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductPackId");
        map.put("supplier", "pdtProductPackId");
        map.put("product", "ownOwner");
        map.put("quantity", "pdtAlias");
        map.put("price", "pdtProduct");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PmtPromotion toEntity(Promotion promotion, boolean lazy) {
        if (null == promotion) {
            return null;
        }
        PmtPromotion pmtPromotion = new PmtPromotion();
        pmtPromotion.setPmtPromotionId(promotion.getId());
        pmtPromotion.setPmtPromotionPrice(promotion.getPrice());
        pmtPromotion.setPmtPromotionQuantity(promotion.getQuantity());
        if (!lazy) {
            pmtPromotion.setPdtProduct(ProductMapper.toEntity(promotion.getProduct(), false));
            pmtPromotion.setPrmCurrency(CurrencyMapper.toEntity(promotion.getCurrency(), false));
            pmtPromotion.setRcpSupplier(SupplierMapper.toEntity(promotion.getSupplier(), false));

        }
        return pmtPromotion;
    }

    public static Promotion toDto(PmtPromotion pmtPromotion, boolean lazy) {
        if (null == pmtPromotion) {
            return null;
        }
        Promotion promotion = new Promotion();
        promotion.setId(pmtPromotion.getPmtPromotionId());
        promotion.setPrice(pmtPromotion.getPmtPromotionPrice());
        promotion.setQuantity(pmtPromotion.getPmtPromotionQuantity());
        if (!lazy) {
            promotion.setProduct(ProductMapper.toDto(pmtPromotion.getPdtProduct(), false));
            promotion.setCurrency(CurrencyMapper.toDto(pmtPromotion.getPrmCurrency(), false));
            promotion.setSupplier(SupplierMapper.toDto(pmtPromotion.getRcpSupplier(), false));

        }
        return promotion;
    }
    public static List<Promotion> toDtos(List<PmtPromotion> pmtPromotions, boolean lazy) {
        if (null == pmtPromotions) {
            return null;
        }
        List<Promotion> promotions = new ArrayList<>();
        for (PmtPromotion pmtPromotion : pmtPromotions) {
            promotions.add(toDto(pmtPromotion, lazy));
        }
        return promotions;
    }

    public static List<Promotion> toDtos(Iterable<PmtPromotion> pmtPromotions, boolean lazy) {
        if (null == pmtPromotions) {
            return null;
        }
        List<Promotion> promotions = new ArrayList<>();
        for (PmtPromotion pmtPromotion : pmtPromotions) {
            promotions.add(toDto(pmtPromotion, lazy));
        }
        return promotions;
    }

    public static Set<PmtPromotion> toEntities(Set<Promotion> promotions, boolean lazy) {
        if (null == promotions) {
            return null;
        }
        Set<PmtPromotion> pmtPromotions = new HashSet<>();
        for (Promotion promotion : promotions) {
            pmtPromotions.add(toEntity(promotion, lazy));
        }
        return pmtPromotions;
    }

    public static Set<Promotion> toDtos(Set<PmtPromotion> pmtPromotions, boolean lazy) {
        if (null == pmtPromotions) {
            return null;
        }
        Set<Promotion> promotions = new HashSet<>();
        for (PmtPromotion pmtPromotion : pmtPromotions) {
            promotions.add(toDto(pmtPromotion, lazy));
        }
        return promotions;
    }

}
