package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VehicleProductReference;
import com.bagile.gmo.entities.GmoVehicleProductReference;

import java.util.*;

public class VehicleProductReferenceMapper {
	public VehicleProductReferenceMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoVehicleProductReferenceId");
		map.put("code", "gmoVehicleProductReferenceCode");
		map.put("reference", "gmoVehicleProductReferenceReference");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoVehicleProductReference toEntity(VehicleProductReference vehicleProductReference, boolean lazy) {
		if (null == vehicleProductReference) {
			return null;
		}
		GmoVehicleProductReference gmoVehicleProductReference = new GmoVehicleProductReference();
		gmoVehicleProductReference.setGmoVehicleProductReferenceId(vehicleProductReference.getId());
		gmoVehicleProductReference.setGmoVehicleProductReference(vehicleProductReference.getReference());


		if(!lazy){
			gmoVehicleProductReference.setOwnOwner(OwnerMapper.toEntity(vehicleProductReference.getOwner(),true));
			gmoVehicleProductReference.setGmoVehicleProduct(VehicleProductMapper.toEntity(vehicleProductReference.getVehicleProduct(),false));



		}
		return gmoVehicleProductReference;
	}

	public static VehicleProductReference toDto(GmoVehicleProductReference gmoVehicleProductReference, boolean lazy) {
		if (null == gmoVehicleProductReference) {
			return null;
		}
		VehicleProductReference vehicleProductReference = new VehicleProductReference();
		vehicleProductReference.setId(gmoVehicleProductReference.getGmoVehicleProductReferenceId());
		vehicleProductReference.setReference(gmoVehicleProductReference.getGmoVehicleProductReference());


		if(!lazy){
			vehicleProductReference.setVehicleProduct(VehicleProductMapper.toDto(gmoVehicleProductReference.getGmoVehicleProduct(),false));

			vehicleProductReference.setOwner(OwnerMapper.toDto(gmoVehicleProductReference.getOwnOwner(),true));

		}
		return vehicleProductReference;

	}



	public static List<VehicleProductReference> toDtos(Iterable<? extends GmoVehicleProductReference> gmoVehicleProductReferences, boolean lazy) {
		if (null == gmoVehicleProductReferences) {
			return null;
		}
		List<VehicleProductReference> vehicleProductReferences = new ArrayList<>();

		for (GmoVehicleProductReference gmoVehicleProductReference : gmoVehicleProductReferences) {
			vehicleProductReferences.add(toDto(gmoVehicleProductReference, lazy));
		}
		return vehicleProductReferences;
	}

	public static Set<GmoVehicleProductReference> toEntities(List<VehicleProductReference> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoVehicleProductReference> gmoVehicleProductReferences = new HashSet<>();
		for (VehicleProductReference vehicleProductReference : list) {
			gmoVehicleProductReferences.add(toEntity(vehicleProductReference, lazy));
		}
		return gmoVehicleProductReferences;
	}

	public static List<VehicleProductReference> toDtos(List<GmoVehicleProductReference> gmoVehicleProductReferences, boolean lazy) {
		if (null == gmoVehicleProductReferences) {
			return null;
		}
		List<VehicleProductReference> vehicleProductReferences = new ArrayList<>();
		for (GmoVehicleProductReference gmoVehicleProductReference : gmoVehicleProductReferences) {
			vehicleProductReferences.add(toDto(gmoVehicleProductReference, lazy));
		}
		return vehicleProductReferences;
	}
}
