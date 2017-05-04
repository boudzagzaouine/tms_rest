package com.sinno.ems.mapper;

import com.sinno.ems.entities.PdtProductForm;

import java.util.*;

/**
 * Created by Enissay on 13/03/2017.
 */
public class ProductFormMapper {
    private ProductFormMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductFormId");
        map.put("code", "pdtProductFormCode");
        map.put("creationDate", "pdtProductFormCreationDate");
        map.put("updateDate", "pdtProductFormUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }
    public static PdtProductForm toEntity(com.sinno.ems.dto.ProductForm productForm, boolean lazy) {
        if (null == productForm) {
            return null;
        }
        PdtProductForm prmProductForm = new PdtProductForm();
        prmProductForm.setPdtProductFormId(productForm.getId());
        prmProductForm.setPdtProductFormCode(productForm.getCode() != null ? productForm.getCode().toUpperCase() : null);
        prmProductForm.setPdtProductFormCreationDate(productForm.getCreationDate());
        prmProductForm.setPdtProductFormUpdateDate(productForm.getUpdateDate());

        if (!lazy) {
            // prmProductForm.setOrgOrganisation(OrganisationMapper.toEntity(productForm.getOrganisation(), true));
        }
        return prmProductForm;
    }

    public static com.sinno.ems.dto.ProductForm toDto(PdtProductForm prmProductForm, boolean lazy) {
        if (null == prmProductForm) {
            return null;
        }
        com.sinno.ems.dto.ProductForm productForm = new com.sinno.ems.dto.ProductForm();
        productForm.setId(prmProductForm.getPdtProductFormId());
        productForm.setCode(prmProductForm.getPdtProductFormCode());
        productForm.setCreationDate(prmProductForm.getPdtProductFormCreationDate());
        productForm.setUpdateDate(prmProductForm.getPdtProductFormUpdateDate());

        if (!lazy) {
            // productForm.setOrganisation(OrganisationMapper.toDto(prmProductForm.getOrgOrganisation(), true));
        }
        return productForm;
    }

    public static List<com.sinno.ems.dto.ProductForm> toDtos(List<PdtProductForm> pdtProductForms, boolean lazy) {
        if (null == pdtProductForms) {
            return null;
        }
        List<com.sinno.ems.dto.ProductForm> productForms = new ArrayList<>();
        for (PdtProductForm prmProductForm : pdtProductForms) {
            productForms.add(toDto(prmProductForm, lazy));
        }
        return productForms;
    }

    public static List<com.sinno.ems.dto.ProductForm> toDtos(Iterable<PdtProductForm> pdtProductForms, boolean lazy) {
        if (null == pdtProductForms) {
            return null;
        }
        List<com.sinno.ems.dto.ProductForm> productForms = new ArrayList<>();
        for (PdtProductForm prmProductForm : pdtProductForms) {
            productForms.add(toDto(prmProductForm, lazy));
        }
        return productForms;
    }

    public static Set<PdtProductForm> toEntities(Set<com.sinno.ems.dto.ProductForm> productForms, boolean lazy) {
        if (null == productForms) {
            return null;
        }
        Set<PdtProductForm> pdtProductForms = new HashSet<>();
        for (com.sinno.ems.dto.ProductForm productForm : productForms) {
            pdtProductForms.add(toEntity(productForm, lazy));
        }
        return pdtProductForms;
    }

    public static Set<com.sinno.ems.dto.ProductForm> toDtos(Set<PdtProductForm> pdtProductForms, boolean lazy) {
        if (null == pdtProductForms) {
            return null;
        }
        Set<com.sinno.ems.dto.ProductForm> productForms = new HashSet<>();
        for (PdtProductForm prmProductForm : pdtProductForms) {
            productForms.add(toDto(prmProductForm, lazy));
        }
        return productForms;
    }

}
