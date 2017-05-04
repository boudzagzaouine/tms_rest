package com.sinno.ems.mapper;

import com.sinno.ems.dto.Alias;
import com.sinno.ems.entities.PdtAlias;

import java.util.*;

public class AliasMapper {
    private AliasMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","pdtAliasId");
        map.put("owner","ownOwner");
        map.put("product","pdtProduct");
        map.put("uom","pdtUom");
        map.put("eanCode","pdtAliasEanCode");
        map.put("creationDate","pdtAliasCreationDate");
        map.put("updateDate","pdtAliasUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtAlias toEntity(Alias alias, boolean lazy) {
        if (null == alias) {
            return null;
        }
        PdtAlias pdtAlias = new PdtAlias();
        pdtAlias.setPdtAliasId(alias.getId());
        pdtAlias.setPdtAliasEanCode(alias.getEanCode());
        pdtAlias.setPdtAliasCreationDate(alias.getCreationDate());
        pdtAlias.setPdtAliasUpdateDate(alias.getUpdateDate());
        if (!lazy) {
            pdtAlias.setPdtUom(UomMapper.toEntity(alias.getUom(), true));
            pdtAlias.setPdtProduct(ProductMapper.toEntity(alias.getProduct(), true));
            pdtAlias.setOwnOwner(OwnerMapper.toEntity(alias.getOwner(), true));
            //pdtAlias.setPdtProductPacks(ProductPackMapper.toEntities(alias.getProductPacks(), true));
        }
        return pdtAlias;
    }

    public static Alias toDto(PdtAlias pdtAlias, boolean lazy) {
        if (null == pdtAlias) {
            return null;
        }
        Alias alias = new Alias();
        alias.setId(pdtAlias.getPdtAliasId());
        alias.setEanCode(pdtAlias.getPdtAliasEanCode());
        alias.setCreationDate(pdtAlias.getPdtAliasCreationDate());
        alias.setUpdateDate(pdtAlias.getPdtAliasUpdateDate());
        if (!lazy) {
            alias.setUom(UomMapper.toDto(pdtAlias.getPdtUom(), true));
            alias.setOwner(OwnerMapper.toDto(pdtAlias.getOwnOwner(), true));
            alias.setProduct(ProductMapper.toDto(pdtAlias.getPdtProduct(), true));
            //alias.setProductPacks(ProductPackMapper.toDtos(pdtAlias.getPdtProductPacks(), true));
        }
        return alias;
    }

    public static List<Alias> toDtos(List<PdtAlias> pdtAliass, boolean lazy) {
        if (null == pdtAliass) {
            return null;
        }
        List<Alias> aliass = new ArrayList<>();
        for (PdtAlias pdtAlias : pdtAliass) {
            aliass.add(toDto(pdtAlias, lazy));
        }
        return aliass;
    }

    public static List<Alias> toDtos(Iterable<PdtAlias> pdtAliass, boolean lazy) {
        if (null == pdtAliass) {
            return null;
        }
        List<Alias> aliass = new ArrayList<>();
        for (PdtAlias pdtAlias : pdtAliass) {
            aliass.add(toDto(pdtAlias, lazy));
        }
        return aliass;
    }

    public static Set<PdtAlias> toEntities(Set<Alias> aliass, boolean lazy) {
        if (null == aliass) {
            return null;
        }
        Set<PdtAlias> pdtAliass = new HashSet<>();
        for (Alias alias : aliass) {
            pdtAliass.add(toEntity(alias, lazy));
        }
        return pdtAliass;
    }

    public static Set<Alias> toDtos(Set<PdtAlias> pdtAliass, boolean lazy) {
        if (null == pdtAliass) {
            return null;
        }
        Set<Alias> aliass = new HashSet<>();
        for (PdtAlias pdtAlias : pdtAliass) {
            aliass.add(toDto(pdtAlias, lazy));
        }
        return aliass;
    }
}
