package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.entities.RcpSupplier;

import java.util.*;

public class SupplierMapper {


    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "rcpSupplierId");
        map.put("owner", "ownOwner");
        map.put("contact", "prmContact");
        map.put("code", "rcpSupplierCode");
        map.put("description", "rcpSupplierDescription");
        map.put("comment", "rcpSupplierComment");
        map.put("terms", "rcpSupplierTerms");
        map.put("creationDate", "rcpSupplierCreationDate");
        map.put("updateDate", "rcpSupplierUpdateDate");
        map.put("active", "rcpSupplierIsActive");
        map.put("gmao", "rcpSupplierGmao");
        map.put("supplierType", "gmoSupplierType");
        map.put("name", "gmoSupplierType");



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpSupplier toEntity(Supplier supplier, boolean lazy) {
        if (null == supplier) {
            return null;
        }
        RcpSupplier rcpSupplier = new RcpSupplier();
        rcpSupplier.setRcpSupplierId(supplier.getId());
        rcpSupplier.setRcpSupplierCode(supplier.getCode() != null ? supplier.getCode().toUpperCase() : null);
        rcpSupplier.setRcpSupplierDescription(supplier.getDescription());
        rcpSupplier.setRcpSupplierComment(supplier.getComment());
        rcpSupplier.setRcpSupplierTerms(supplier.getTerms());
        rcpSupplier.setRcpSupplierCreationDate(supplier.getCreationDate());
        rcpSupplier.setRcpSupplierUpdateDate(supplier.getUpdateDate());
        rcpSupplier.setRcpSupplierIsActive(supplier.getActive());
        rcpSupplier.setRcpSupplierGmao(supplier.getGmao());

        if (!lazy) {
            rcpSupplier.setOwnOwner(OwnerMapper.toEntity(supplier.getOwner(), true));
            rcpSupplier.setPrmContact(ContactMapper.toEntity(supplier.getContact(), true));
            rcpSupplier.setAdrAddress (AddressMapper.toEntity (supplier.getAddress (), true));
            rcpSupplier.setTmsPlannings (PlanningMapper.toEntities (supplier.getPlannings (), false));
            rcpSupplier.setGmoSupplierType (SupplierTypeMapper.toEntity (supplier.getSupplierType (), true));
            rcpSupplier.setTmsSupplierProducts (SupplierProductMapper.toEntities (supplier.getSupplierProducts (), false));

            oneToMany(rcpSupplier);

        }
        return rcpSupplier;
    }

    private static void oneToMany(RcpSupplier rcpSupplier){
        rcpSupplier.getTmsPlannings().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setRcpSupplier(rcpSupplier);
                }
        );

        rcpSupplier.getTmsSupplierProducts().forEach(
                e->{
                    e.setCreationDate(new Date());
                    e.setRcpSupplier(rcpSupplier);
                }
        );




    }

    public static Supplier toDto(RcpSupplier rcpSupplier, boolean lazy) {
        if (null == rcpSupplier) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setId(rcpSupplier.getRcpSupplierId());
        supplier.setCode(rcpSupplier.getRcpSupplierCode());
        supplier.setDescription(rcpSupplier.getRcpSupplierDescription());//
        supplier.setComment(rcpSupplier.getRcpSupplierComment());
        supplier.setTerms(rcpSupplier.getRcpSupplierTerms());
        supplier.setCreationDate(rcpSupplier.getRcpSupplierCreationDate());
        supplier.setUpdateDate(rcpSupplier.getRcpSupplierUpdateDate());
        supplier.setActive(rcpSupplier.getRcpSupplierIsActive());
        supplier.setGmao(rcpSupplier.getRcpSupplierGmao());

        if (!lazy) {
            supplier.setOwner(OwnerMapper.toDto(rcpSupplier.getOwnOwner(), true));
            supplier.setContact(ContactMapper.toDto(rcpSupplier.getPrmContact(), true));
            supplier.setAddress (AddressMapper.toDto (rcpSupplier.getAdrAddress (), true));
            supplier.setPlannings (PlanningMapper.toDtos (rcpSupplier.getTmsPlannings (), false));
            supplier.setSupplierType (SupplierTypeMapper.toDto (rcpSupplier.getGmoSupplierType (), true));
            supplier.setSupplierProducts (SupplierProductMapper.toDtos (rcpSupplier.getTmsSupplierProducts (), false));

        }
        return supplier;
    }

    public static List<Supplier> toDtos(Iterable<? extends RcpSupplier> rcpSuppliers, boolean lazy) {
        if (null == rcpSuppliers) {
            return null;
        }
        List<Supplier> suppliers = new ArrayList<>();
        for (RcpSupplier rcpSupplier : rcpSuppliers) {
            suppliers.add(toDto(rcpSupplier, lazy));
        }
        return suppliers;
    }

    public static Set<RcpSupplier> toEntities(Set<? extends Supplier> suppliers, boolean lazy) {
        if (null == suppliers) {
            return null;
        }
        Set<RcpSupplier> rcpSuppliers = new HashSet<>();
        for (Supplier supplier : suppliers) {
            rcpSuppliers.add(toEntity(supplier, lazy));
        }
        return rcpSuppliers;
    }

    public static Set<Supplier> toDtos(Set<? extends RcpSupplier> rcpSuppliers, boolean lazy) {
        if (null == rcpSuppliers) {
            return null;
        }
        Set<Supplier> suppliers = new HashSet<>();
        for (RcpSupplier rcpSupplier : rcpSuppliers) {
            suppliers.add(toDto(rcpSupplier, lazy));
        }
        return suppliers;
    }
}
