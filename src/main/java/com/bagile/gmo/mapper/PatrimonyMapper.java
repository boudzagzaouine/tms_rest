package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Machine;
import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.entities.GmoMachine;
import com.bagile.gmo.entities.GmoPatrimony;
import com.bagile.gmo.entities.GmoVehicle;
import com.bagile.gmo.entities.GmoVehicleCategory;

import java.util.*;

public class PatrimonyMapper {

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoPatrimonyId");
		map.put("code", "gmoPatrimonyCode");
		map.put("registrationNumber", "gmoRegistrationNumber");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}






	public static GmoPatrimony toEntity(Patrimony patrimony, boolean lazy) {
		if(patrimony instanceof Vehicle) {
			return VehicleMapper.toEntity((Vehicle) patrimony, lazy);
		}
		else if(patrimony instanceof Machine) {
			return MachineMapper.toEntity((Machine) patrimony, lazy);
		}
		return null;
	}

	public static Patrimony toDto(GmoPatrimony gmoPatrimony, boolean lazy) {
		if(gmoPatrimony instanceof GmoVehicle ) {
			return VehicleMapper.toDto((GmoVehicle)gmoPatrimony, lazy);
		}
		else if(gmoPatrimony instanceof GmoMachine) {
			return MachineMapper.toDto((GmoMachine)gmoPatrimony, lazy);
		}
		return null;
	}
	public static List<Patrimony> toDtos(Iterable<? extends GmoPatrimony> gmoPatrimonies, boolean lazy) {
		if (null == gmoPatrimonies) {
			return null;
		}
		List<Patrimony> patrimonies = new ArrayList<>();

		for (GmoPatrimony gmoPatrimony : gmoPatrimonies) {
			patrimonies.add(toDto(gmoPatrimony, lazy));
		}
		return patrimonies;
	}
	public static Set<GmoPatrimony> toEntities(Set<Patrimony> patrimonies, boolean lazy) {
		if (null == patrimonies) {
			return null;
		}
		Set<GmoPatrimony> gmoPatrimonies = new HashSet<>();
		for (Patrimony patrimony : patrimonies) {
			gmoPatrimonies.add(toEntity(patrimony, lazy));
		}
		return gmoPatrimonies;
	}
	public static Set<Patrimony> toDtos(Set<GmoPatrimony> gmoPatrimonies, boolean lazy) {
		if (null == gmoPatrimonies) {
			return null;
		}
		Set<Patrimony> patrimonies = new HashSet<>();
		for (GmoPatrimony gmoPatrimony : gmoPatrimonies) {
			patrimonies.add(toDto(gmoPatrimony, lazy));
		}
		return patrimonies;
	}
























}
