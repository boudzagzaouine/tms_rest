package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ProductType;
import com.bagile.gmo.dto.VehicleProduct;
import com.bagile.gmo.dto.VehicleProductReference;
import com.bagile.gmo.entities.GmoVehicle;
import com.bagile.gmo.entities.GmoVehicleProduct;

import java.util.*;

public class VehicleProductMapper {
	public VehicleProductMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoVehicleProductId");
		map.put("code", "gmoVehicleProductCode");
		map.put("reference", "gmoVehicleProductReference");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoVehicleProduct toEntity(VehicleProduct vehicleProduct, boolean lazy) {
		if (null == vehicleProduct) {
			return null;
		}
		GmoVehicleProduct gmoVehicleProduct = new GmoVehicleProduct();
		gmoVehicleProduct.setGmoVehicleProductId(vehicleProduct.getId());



		if(!lazy){
			gmoVehicleProduct.setOwnOwner(OwnerMapper.toEntity(vehicleProduct.getOwner(),true));
			gmoVehicleProduct.setPdtProduct(ProductMapper.toEntity(vehicleProduct.getProduct(),false));
			gmoVehicleProduct.setPdtProductType(ProductTypeMapper.toEntity(vehicleProduct.getProductType(),false));

			gmoVehicleProduct.setGmoVehicle(VehicleMapper.toEntity(vehicleProduct.getVehicle(),false));

			gmoVehicleProduct.setGmoVehicleProductReferences(VehicleProductReferenceMapper.toEntities(vehicleProduct.getVehicleProductReferences(),false));
			oneToMany(gmoVehicleProduct);
		}
		return gmoVehicleProduct;
	}

	private static void oneToMany(GmoVehicleProduct gmoVehicleProduct) {
		gmoVehicleProduct.getGmoVehicleProductReferences().forEach(
				e -> {
					e.setCreationDate(new Date());
					e.setGmoVehicleProduct(gmoVehicleProduct);
				}
		);
	}

	public static VehicleProduct toDto(GmoVehicleProduct gmoVehicleProduct, boolean lazy) {
		if (null == gmoVehicleProduct) {
			return null;
		}
		VehicleProduct vehicleProduct = new VehicleProduct();
		vehicleProduct.setId(gmoVehicleProduct.getGmoVehicleProductId());


		if(!lazy){
			vehicleProduct.setProduct(ProductMapper.toDto(gmoVehicleProduct.getPdtProduct(),false));
			vehicleProduct.setVehicle(VehicleMapper.toDto(gmoVehicleProduct.getGmoVehicle(),true));
			vehicleProduct.setProductType(ProductTypeMapper.toDto(gmoVehicleProduct.getPdtProductType(),false));

			vehicleProduct.setOwner(OwnerMapper.toDto(gmoVehicleProduct.getOwnOwner(),true));
			vehicleProduct.setVehicleProductReferences(VehicleProductReferenceMapper.toDtos(gmoVehicleProduct.getGmoVehicleProductReferences(),true));

		}
		return vehicleProduct;

	}



	public static List<VehicleProduct> toDtos(Iterable<? extends GmoVehicleProduct> gmoVehicleProducts, boolean lazy) {
		if (null == gmoVehicleProducts) {
			return null;
		}
		List<VehicleProduct> vehicleProducts = new ArrayList<>();

		for (GmoVehicleProduct gmoVehicleProduct : gmoVehicleProducts) {
			vehicleProducts.add(toDto(gmoVehicleProduct, lazy));
		}
		return vehicleProducts;
	}

	public static Set<GmoVehicleProduct> toEntities(List<VehicleProduct> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoVehicleProduct> gmoVehicleProducts = new HashSet<>();
		for (VehicleProduct vehicleProduct : list) {
			gmoVehicleProducts.add(toEntity(vehicleProduct, lazy));
		}
		return gmoVehicleProducts;
	}

	public static List<VehicleProduct> toDtos(List<GmoVehicleProduct> gmoVehicleProducts, boolean lazy) {
		if (null == gmoVehicleProducts) {
			return null;
		}
		List<VehicleProduct> vehicleProducts = new ArrayList<>();
		for (GmoVehicleProduct gmoVehicleProduct : gmoVehicleProducts) {
			vehicleProducts.add(toDto(gmoVehicleProduct, lazy));
		}
		return vehicleProducts;
	}
}
