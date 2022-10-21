package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TurnStatus;

import com.bagile.gmo.entities.TmsTurnStatus;
import com.bagile.gmo.mapper.OwnerMapper;


import java.util.*;

public class TurnStatusMapper {
	public TurnStatusMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsTurnStatusId");
		map.put("code", "tmsTurnStatusCode");
		map.put("description", "tmsTurnStatusDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsTurnStatus toEntity(TurnStatus turnStatus, boolean lazy) {
		if (null == turnStatus) {
			return null;
		}
		TmsTurnStatus tmsTurnStatus = new TmsTurnStatus();
		tmsTurnStatus.setTmsTurnStatusId(turnStatus.getId());
		tmsTurnStatus.setTmsTurnStatusCode(turnStatus.getCode() != null ? turnStatus.getCode().toUpperCase() : null);
		tmsTurnStatus.setTmsTurnStatusDescription(turnStatus.getDescription());

		if(!lazy){
			tmsTurnStatus.setOwnOwner(OwnerMapper.toEntity(turnStatus.getOwner(),true));


		}
		return tmsTurnStatus;
	}

	public static TurnStatus toDto(TmsTurnStatus tmsTurnStatus, boolean lazy) {
		if (null == tmsTurnStatus) {
			return null;
		}
		TurnStatus turnStatus = new TurnStatus();
		turnStatus.setId(tmsTurnStatus.getTmsTurnStatusId());
		turnStatus.setCode(tmsTurnStatus.getTmsTurnStatusCode() != null ? tmsTurnStatus.getTmsTurnStatusCode().toUpperCase() : null);
		turnStatus.setDescription(tmsTurnStatus.getTmsTurnStatusDescription());

		if(!lazy){

			turnStatus.setOwner(OwnerMapper.toDto(tmsTurnStatus.getOwnOwner(),true));

		}
		return turnStatus;

	}




	public static List<TurnStatus> toDtos(Iterable<? extends TmsTurnStatus> tmsTurnStatuss, boolean lazy) {
		if (null == tmsTurnStatuss) {
			return null;
		}
		List<TurnStatus> turnStatuss = new ArrayList<>();

		for (TmsTurnStatus tmsTurnStatus : tmsTurnStatuss) {
			turnStatuss.add(toDto(tmsTurnStatus, lazy));
		}
		return turnStatuss;
	}

	public static Set<TmsTurnStatus> toEntities(List<TurnStatus> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsTurnStatus> tmsTurnStatuss = new HashSet<>();
		for (TurnStatus turnStatus : list) {
			tmsTurnStatuss.add(toEntity(turnStatus, lazy));
		}
		return tmsTurnStatuss;
	}

	public static List<TurnStatus> toDtos(List<TmsTurnStatus> tmsTurnStatuss, boolean lazy) {
		if (null == tmsTurnStatuss) {
			return null;
		}
		List<TurnStatus> turnStatuss = new ArrayList<>();
		for (TmsTurnStatus tmsTurnStatus : tmsTurnStatuss) {
			turnStatuss.add(toDto(tmsTurnStatus, lazy));
		}
		return turnStatuss;
	}
}
