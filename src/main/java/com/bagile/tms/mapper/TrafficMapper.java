package com.bagile.tms.mapper;

import com.bagile.tms.dto.Category;
import com.bagile.tms.entities.TmsCategory;

import java.util.HashMap;
import java.util.Map;

public class TrafficMapper  {
        private TrafficMapper() {

        }

        private static Map<String, String> map;

        static {
            map = new HashMap<>();
            map.put("id", "tmsTrafficId");
            map.put("active", "tmsTrafficAcive");
            map.put("date", "tmsTrafficDate");
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
    }


}
