package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Patrimony;
import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.entities.GmoPatrimony;
import com.bagile.gmo.entities.GmoVehicle;

public class PatrimonyMapper {

	public static GmoPatrimony toEntity(Patrimony patrimony, boolean lazy) {
		if(patrimony instanceof Vehicle) {
			return VehicleMapper.toEntity((Vehicle) patrimony, lazy);
		}
		return null;
	}

	public static Patrimony toDto(GmoPatrimony gmoPatrimony, boolean lazy) {
		if(gmoPatrimony instanceof GmoVehicle ) {
			return VehicleMapper.toDto((GmoVehicle)gmoPatrimony, lazy);
		}
		return null;
	}

}
