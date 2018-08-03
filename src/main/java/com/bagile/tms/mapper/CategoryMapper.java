package com.bagile.tms.mapper;

import com.bagile.tms.dto.Category;
import com.bagile.tms.dto.DoorType;
import com.bagile.tms.entities.TmsCategory;
import com.bagile.tms.entities.TmsDoorType;

import java.util.*;


public class CategoryMapper {
    private CategoryMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsCategoryId");
        map.put("consumption", "tmsCategoryConsumption");
        map.put("weight", "tmsCategoryWeight");
        map.put("width", "tmsCategoryWidth");
        map.put("door","tmsCategoryDoor");
        map.put("depth","tmsCategoryDepth");
        map.put("tonnage", "tmsCategoryTonnage");
        map.put("emptyWeight", "tmsCategoryEmptyWeight");
        map.put("totalWeight", "tmsCategoryTotalWeight");
    }
    public static Map<String, String> getMap() {
        return map;
    }
    public String getField(String key) {
        return map.get(key);
    }
    public static TmsCategory toEntity(Category Category, boolean lazy) {
        if (null == Category) {
            return null;
        }
        TmsCategory tmsCategory = new TmsCategory();
        tmsCategory.setTmsCategoryId(Category.getId());
        tmsCategory.setTmsCategoryConsumption(Category.getConsumption());
        tmsCategory.setTmsCategoryWeight(Category.getWeight());
        tmsCategory.setTmsCategoryWidth(Category.getWidth());
        tmsCategory.setTmsCategoryDepth(Category.getDepth());
        tmsCategory.setTmsCategoryTonnage(Category.getTonnage());
        tmsCategory.setTmsCategoryEmptyWeight(Category.getEmptyWeight());
        tmsCategory.setTmsCategoryTotalWeight(Category.getTotalWeight());
        if (!lazy) {
            tmsCategory.setTmsCategoryDoor(DoorTypeMapper.toEntity(Category.getDoor(),true));
        }
        return tmsCategory;
    }

    public static Category toDto(TmsCategory tmsCategory, boolean lazy) {
        if (null == tmsCategory) {
            return null;
        }
        Category category = new Category();
        category.setId(tmsCategory.getTmsCategoryId());
        category.setConsumption(tmsCategory.getTmsCategoryConsumption());
        category.setDepth(tmsCategory.getTmsCategoryDepth());
        category.setWeight(tmsCategory.getTmsCategoryWeight());
        category.setWidth(tmsCategory.getTmsCategoryWidth());
        category.setTonnage(tmsCategory.getTmsCategoryTonnage());
        category.setTotalWeight(tmsCategory.getTmsCategoryTotalWeight());
        category.setEmptyWeight(tmsCategory.getTmsCategoryEmptyWeight());

        if (!lazy) {
            category.setDoor(DoorTypeMapper.toDto(tmsCategory.getTmsCategoryDoor(),true));
        }
        return category;
    }
    public static List<Category> toDtos(List<TmsCategory> tmsCategories, boolean lazy) {
        if (null == tmsCategories) {
            return null;
        }
        List<Category> categories= new ArrayList<>();
        for (TmsCategory tmsCategory : tmsCategories) {
            categories.add(toDto(tmsCategory, lazy));
        }
        return categories;
    }

    public static List<Category> toDtos(Iterable<TmsCategory> tmsCategories, boolean lazy) {
        if (null == tmsCategories) {
            return null;
        }
        List<Category> categories = new ArrayList<>();
        for (TmsCategory tmsCategory : tmsCategories) {
            categories.add(toDto(tmsCategory, lazy));
        }
        return categories;
    }

    public static Set<TmsCategory> toEntities(Set<Category> categories, boolean lazy) {
        if (null == categories) {
            return null;
        }
        Set<TmsCategory> TmsCategories = new HashSet<>();
        for (Category category : categories) {
            TmsCategories.add(toEntity(category, lazy));
        }
        return TmsCategories;
    }

    public static Set<Category> toDtos(Set<TmsCategory> TmsCategories, boolean lazy) {
        if (null == TmsCategories) {
            return null;
        }
        Set<Category> categories = new HashSet<>();
        for (TmsCategory tmsCategory : TmsCategories) {
            categories.add(toDto(tmsCategory, lazy));
        }
        return categories;
    }
}

