package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Trajet;
import com.bagile.gmo.entities.TmsTrajet;

import java.util.*;

public class TrajetMapper {
	public TrajetMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsTrajetId");
		map.put("code", "tmsTrajetCode");
		map.put("company", "cmdCompany");
		map.put("loadingType", "tmsLoadingType");
		map.put("turnType", "tmsTurnType");
		map.put("vehicleCategory", "gmoVehicleCategory");
		map.put("vehicleTray", "tmsVehicleTray");
		map.put("villeSource", "tmsVilleSource");
		map.put("villeDestination", "tmsVilleDestination");


	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsTrajet toEntity(Trajet trajet, boolean lazy) {
		if (null == trajet) {
			return null;
		}
		TmsTrajet tmsTrajet = new TmsTrajet();
		tmsTrajet.setTmsTrajetId(trajet.getId());

		tmsTrajet.setTmsTrajetCode(trajet.getCode());


		if(!lazy){

			tmsTrajet.setPrmPaysSource(PaysMapper.toEntity(trajet.getPaysSource(),true));
			tmsTrajet.setTmsVilleSource(VilleMapper.toEntity(trajet.getVilleSource(),true));
			tmsTrajet.setPrmPaysDestination(PaysMapper.toEntity(trajet.getPaysDestination(),true));
			tmsTrajet.setTmsVilleDestination(VilleMapper.toEntity(trajet.getVilleDestination(),true));



			tmsTrajet.setOwnOwner(OwnerMapper.toEntity(trajet.getOwner(),true));




		}
		return tmsTrajet;
	}

	public static Trajet toDto(TmsTrajet tmsTrajet, boolean lazy) {
		if (null == tmsTrajet) {
			return null;
		}
		Trajet trajet = new Trajet();
		trajet.setId(tmsTrajet.getTmsTrajetId());

		trajet.setCode(tmsTrajet.getTmsTrajetCode());



		if(!lazy){

			trajet.setPaysSource(PaysMapper.toDto(tmsTrajet.getPrmPaysSource(),true));
			trajet.setVilleSource(VilleMapper.toDto(tmsTrajet.getTmsVilleSource(),true));
			trajet.setPaysDestination(PaysMapper.toDto(tmsTrajet.getPrmPaysDestination(),true));
			trajet.setVilleDestination(VilleMapper.toDto(tmsTrajet.getTmsVilleDestination(),true));

			trajet.setOwner(OwnerMapper.toDto(tmsTrajet.getOwnOwner(),true));

		}
		return trajet;

	}



	public static List<Trajet> toDtos(Iterable<? extends TmsTrajet> tmsTrajets, boolean lazy) {
		if (null == tmsTrajets) {
			return null;
		}
		List<Trajet> trajets = new ArrayList<>();

		for (TmsTrajet tmsTrajet : tmsTrajets) {
			trajets.add(toDto(tmsTrajet, lazy));
		}
		return trajets;
	}

	public static Set<TmsTrajet> toEntities(List<Trajet> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsTrajet> tmsTrajets = new HashSet<>();
		for (Trajet trajet : list) {
			tmsTrajets.add(toEntity(trajet, lazy));
		}
		return tmsTrajets;
	}

	public static List<Trajet> toDtos(List<TmsTrajet> tmsTrajets, boolean lazy) {
		if (null == tmsTrajets) {
			return null;
		}
		List<Trajet> trajets = new ArrayList<>();
		for (TmsTrajet tmsTrajet : tmsTrajets) {
			trajets.add(toDto(tmsTrajet, lazy));
		}
		return trajets;
	}
}
