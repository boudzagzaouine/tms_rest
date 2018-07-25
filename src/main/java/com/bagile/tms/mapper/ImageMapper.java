package com.bagile.tms.mapper;

import com.bagile.tms.dto.Image;
import com.bagile.tms.entities.PrmImage;

import java.util.*;

public class ImageMapper {
    private ImageMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmImageId");
        map.put("code", "prmImageCode");
        map.put("description", "prmImageDescription");
        map.put("byte", "prmImageBytes");
        map.put("product", "pdtProduct");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmImage toEntity(Image image, boolean lazy) {
        if (null == image) {
            return null;
        }
        PrmImage prmImage = new PrmImage();
        prmImage.setPrmImageId(image.getId());
        prmImage.setPrmImageBytes(image.getBytes());
        prmImage.setPrmImageCode(image.getCode());
        prmImage.setPrmImageDescription(image.getDescription());
        if (!lazy) {
            prmImage.setPdtProduct(ProductMapper.toEntity(image.getProduct(), true));
        }
        return prmImage;
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static Image toDto(PrmImage prmImage, boolean lazy) {
        if (null == prmImage) {
            return null;
        }
        Image image = new Image();
        image.setId(prmImage.getPrmImageId());
        image.setBytes(prmImage.getPrmImageBytes());
        image.setCode(prmImage.getPrmImageCode());
        image.setDescription(prmImage.getPrmImageDescription());
        if (!lazy) {
            image.setProduct(ProductMapper.toDto(prmImage.getPdtProduct(), true));
        }
        return image;
    }

    public static List<Image> toDtos(List<PrmImage> prmImages, boolean lazy) {
        if (null == prmImages) {
            return null;
        }
        List<Image> images = new ArrayList<>();
        for (PrmImage prmImage : prmImages) {
            images.add(toDto(prmImage, lazy));
        }
        return images;
    }

    public static List<Image> toDtos(Iterable<PrmImage> prmImages, boolean lazy) {
        if (null == prmImages) {
            return null;
        }
        List<Image> images = new ArrayList<>();
        for (PrmImage prmImage : prmImages) {
            images.add(toDto(prmImage, lazy));
        }
        return images;
    }

    public static Set<PrmImage> toEntities(Set<Image> images, boolean lazy) {
        if (null == images) {
            return null;
        }
        Set<PrmImage> prmImages = new HashSet<>();
        for (Image image : images) {
            prmImages.add(toEntity(image, lazy));
        }
        return prmImages;
    }

    public static Set<Image> toDtos(Set<PrmImage> prmImages, boolean lazy) {
        if (null == prmImages) {
            return null;
        }
        Set<Image> images = new HashSet<>();
        for (PrmImage prmImage : prmImages) {
            images.add(toDto(prmImage, lazy));
        }
        return images;
    }
}
