package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceProduct;
import com.bagile.gmo.entities.GmoMaintenanceProduct;

public class MaintenanceProductMapper {
	public MaintenanceProductMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoMaintenanceProductid");
		map.put("product", "gmoMaintenanceProductProduct");
		map.put("quantity", "gmoMaintenanceProductQuantity");
		map.put("unitPrice", "gmoMaintenanceProductUnitPrice");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoMaintenanceProduct toEntity(MaintenanceProduct maintenanceProduct, boolean lazy) {
		if (null == maintenanceProduct) {
			return null;
		}
		GmoMaintenanceProduct gmoMaintenanceProduct = new GmoMaintenanceProduct();
		gmoMaintenanceProduct.setGmoMaintenanceProductId(maintenanceProduct.getId());
		gmoMaintenanceProduct.setGmoMaintenanceProductQuantity(maintenanceProduct.getQuantity());
		gmoMaintenanceProduct.setGmoMaintenanceProductUnitPrice(maintenanceProduct.getUnitPrice());
		if (!lazy) {
			gmoMaintenanceProduct
			.setGmoMaintenanceProductProduct(ProductMapper.toEntity(maintenanceProduct.getProduct(), false));
		}
		return gmoMaintenanceProduct;
	}

	public static MaintenanceProduct toDto(GmoMaintenanceProduct gmoMaintenanceProduct, boolean lazy) {
		if (null == gmoMaintenanceProduct) {
			return null;
		}
		MaintenanceProduct maintenanceProduct = new MaintenanceProduct();
		maintenanceProduct.setId(gmoMaintenanceProduct.getGmoMaintenanceProductId());
		maintenanceProduct.setQuantity(gmoMaintenanceProduct.getGmoMaintenanceProductQuantity());
		maintenanceProduct.setUnitPrice(gmoMaintenanceProduct.getGmoMaintenanceProductUnitPrice());

		if (!lazy) {
			maintenanceProduct.setProduct(ProductMapper.toDto(gmoMaintenanceProduct.getGmoMaintenanceProductProduct(), false));
		}
		return maintenanceProduct;
	}

	public static List<MaintenanceProduct> toDtos(Iterable<? extends GmoMaintenanceProduct> gmoMaintenanceProducts,
			boolean lazy) {
		if (null == gmoMaintenanceProducts) {
			return null;
		}
		List<MaintenanceProduct> maintenanceProducts = new ArrayList<>();

		for (GmoMaintenanceProduct gmoMaintenanceProduct : gmoMaintenanceProducts) {
			maintenanceProducts.add(toDto(gmoMaintenanceProduct, lazy));
		}
		return maintenanceProducts;
	}

	public static Set<MaintenanceProduct> toDtos(Set<? extends GmoMaintenanceProduct> gmoMaintenanceProducts,
			boolean lazy) {
		if (null == gmoMaintenanceProducts) {
			return null;
		}
		Set<MaintenanceProduct> maintenanceProducts = new HashSet<>();

		for (GmoMaintenanceProduct gmoMaintenanceProduct : gmoMaintenanceProducts) {
			maintenanceProducts.add(toDto(gmoMaintenanceProduct, lazy));
		}
		return maintenanceProducts;
	}

	public static Set<GmoMaintenanceProduct> toEntities(Iterable<? extends MaintenanceProduct> maintenanceProducts,
			boolean lazy) {
		if (null == maintenanceProducts) {
			return null;
		}
		Set<GmoMaintenanceProduct> gmoMaintenanceProducts = new HashSet<>();
		for (MaintenanceProduct maintenanceProduct : maintenanceProducts) {
			gmoMaintenanceProducts.add(toEntity(maintenanceProduct, lazy));
		}
		return gmoMaintenanceProducts;
	}
}
