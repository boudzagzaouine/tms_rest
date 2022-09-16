package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Sinister;
import com.bagile.gmo.entities.GmoSinister;
import com.bagile.gmo.entities.InvSupplierInvoice;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class SinisterMapper {
	public SinisterMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "gmoSinisterId");
		map.put("code", "gmoSinisterCode");
		map.put("description", "gmoSinisterDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static GmoSinister toEntity(Sinister sinister, boolean lazy) {
		if (null == sinister) {
			return null;
		}
		GmoSinister gmoSinister = new GmoSinister();
		gmoSinister.setGmoSinisterId(sinister.getId());
		gmoSinister.setGmoSinisterCode(sinister.getCode() != null ? sinister.getCode().toUpperCase() : null);
		gmoSinister.setGmoSinisterDescription(sinister.getDescription());
		gmoSinister.setGmoSinisterDate(sinister.getDate());
		gmoSinister.setGmoSinisterVenue(sinister.getVenue());
		gmoSinister.setGmoSinisterRepayment(sinister.getRepayment());



		if(!lazy){
			gmoSinister.setGmoVehicle(VehicleMapper.toEntity(sinister.getVehicle(),true));
			gmoSinister.setGmoDriver(DriverMapper.toEntity(sinister.getDriver(),true));
			gmoSinister.setRcpSupplier(SupplierMapper.toEntity(sinister.getSupplier(),false));
			gmoSinister.setGmoSinisterType(SinisterTypeMapper.toEntity(sinister.getSinisterType(),true));
			gmoSinister.setGmoDocumentSet(DocumentMapper.toEntities(sinister.getDocuments(),false));

			gmoSinister.setOwnOwner(OwnerMapper.toEntity(sinister.getOwner(),true));
      oneToMany(gmoSinister);

		}
		return gmoSinister;
	}

	public static void oneToMany(GmoSinister gmoSinister) {
		if (null != gmoSinister.getGmoDocumentSet()) {
			gmoSinister.getGmoDocumentSet().stream().forEach(sl -> {
				sl.setGmoSinister(gmoSinister);
				sl.setUpdateDate(EmsDate.getDateNow());
				if (0 >= sl.getGmoDocumentId()) {
					sl.setGmoDocumentId(0L);
					sl.setCreationDate(EmsDate.getDateNow());
				}
			});
		}
	}

	public static Sinister toDto(GmoSinister gmoSinister, boolean lazy) {
		if (null == gmoSinister) {
			return null;
		}
		Sinister sinister = new Sinister();
		sinister.setId(gmoSinister.getGmoSinisterId());
		sinister.setCode(gmoSinister.getGmoSinisterCode() != null ? gmoSinister.getGmoSinisterCode().toUpperCase() : null);
		sinister.setDescription(gmoSinister.getGmoSinisterDescription());
		sinister.setVenue(gmoSinister.getGmoSinisterVenue());
		sinister.setDate(gmoSinister.getGmoSinisterDate());
		sinister.setRepayment(gmoSinister.getGmoSinisterRepayment());
		if(!lazy){
			sinister.setVehicle(VehicleMapper.toDto(gmoSinister.getGmoVehicle(),true));
			sinister.setDriver(DriverMapper.toDto(gmoSinister.getGmoDriver(),true));
			sinister.setSupplier(SupplierMapper.toDto(gmoSinister.getRcpSupplier(),false));
			sinister.setSinisterType(SinisterTypeMapper.toDto(gmoSinister.getGmoSinisterType(),true));
			sinister.setDocuments(DocumentMapper.toDtos(gmoSinister.getGmoDocumentSet(),false));

			sinister.setOwner(OwnerMapper.toDto(gmoSinister.getOwnOwner(),true));

		}
		return sinister;

	}




	public static List<Sinister> toDtos(Iterable<? extends GmoSinister> gmoSinisters, boolean lazy) {
		if (null == gmoSinisters) {
			return null;
		}
		List<Sinister> sinisters = new ArrayList<>();

		for (GmoSinister gmoSinister : gmoSinisters) {
			sinisters.add(toDto(gmoSinister, lazy));
		}
		return sinisters;
	}

	public static Set<GmoSinister> toEntities(List<Sinister> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<GmoSinister> gmoSinisters = new HashSet<>();
		for (Sinister sinister : list) {
			gmoSinisters.add(toEntity(sinister, lazy));
		}
		return gmoSinisters;
	}

	public static List<Sinister> toDtos(List<GmoSinister> gmoSinisters, boolean lazy) {
		if (null == gmoSinisters) {
			return null;
		}
		List<Sinister> sinisters = new ArrayList<>();
		for (GmoSinister gmoSinister : gmoSinisters) {
			sinisters.add(toDto(gmoSinister, lazy));
		}
		return sinisters;
	}
}
