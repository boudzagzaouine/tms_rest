package com.sinno.ems.mapper;

import com.sinno.ems.dto.Kit;
import com.sinno.ems.entities.PdtKit;

import java.util.*;

public class KitMapper {
    private KitMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtKitId");
        map.put("product", "pdtProduct");
        map.put("component", "pdtKitComponent");
        map.put("quantity", "pdtKitQuantity");
        map.put("uom", "pdtUom");
        map.put("componentUom", "pdtKitComponentUom");
        map.put("version", "pdtKitVersion");
        map.put("marginfalling","pdtKitmarginfalling");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtKit toEntity(Kit kit, boolean lazy) {
        if (null == kit) {
            return null;
        }
        PdtKit pdtKit = new PdtKit();
        pdtKit.setPdtKitId(kit.getId());
        pdtKit.setPdtKitQuantity(kit.getQuantity());
        pdtKit.setPdtKitVersion(kit.getVersion());
        pdtKit.setPdtKitMarginFalling(kit.getMarginFalling());
        if (!lazy) {
            pdtKit.setPdtKitComponent(ProductMapper.toEntity(kit.getComponent(), true));
            pdtKit.setPdtKitComponentUom(UomMapper.toEntity(kit.getComponentUom(), true));
            pdtKit.setPdtProduct(ProductMapper.toEntity(kit.getProduct(), true));
            pdtKit.setPdtUom(UomMapper.toEntity(kit.getUom(), true));
        }
        return pdtKit;
    }

    public static Kit toDto(PdtKit pdtKit, boolean lazy) {
        if (null == pdtKit) {
            return null;
        }
        Kit kit = new Kit();
        kit.setId(pdtKit.getPdtKitId());
        kit.setQuantity( pdtKit.getPdtKitQuantity());
        kit.setVersion(pdtKit.getPdtKitVersion());
        if (!lazy) {
            kit.setComponent(ProductMapper.toDto(pdtKit.getPdtKitComponent(), true));
            kit.setComponentUom(UomMapper.toDto(pdtKit.getPdtKitComponentUom(), true));
            kit.setProduct(ProductMapper.toDto(pdtKit.getPdtProduct(), true));
            kit.setUom(UomMapper.toDto(pdtKit.getPdtUom(), true));
        }
        return kit;
    }

    public static List<Kit> toDtos(List<PdtKit> pdtKits, boolean lazy) {
        if (null == pdtKits) {
            return null;
        }
        List<Kit> kits = new ArrayList<>();
        for (PdtKit pdtKit : pdtKits) {
            kits.add(toDto(pdtKit, lazy));
        }
        return kits;
    }

    public static List<Kit> toDtos(Iterable<PdtKit> pdtKits, boolean lazy) {
        if (null == pdtKits) {
            return null;
        }
        List<Kit> kits = new ArrayList<>();
        for (PdtKit pdtKit : pdtKits) {
            kits.add(toDto(pdtKit, lazy));
        }
        return kits;
    }

    public static Set<PdtKit> toEntities(Set<Kit> kits, boolean lazy) {
        if (null == kits) {
            return null;
        }
        Set<PdtKit> pdtKits = new HashSet<>();
        for (Kit kit : kits) {
            pdtKits.add(toEntity(kit, lazy));
        }
        return pdtKits;
    }

    public static Set<Kit> toDtos(Set<PdtKit> pdtKits, boolean lazy) {
        if (null == pdtKits) {
            return null;
        }
        Set<Kit> kits = new HashSet<>();
        for (PdtKit pdtKit : pdtKits) {
            kits.add(toDto(pdtKit, lazy));
        }
        return kits;
    }
}
