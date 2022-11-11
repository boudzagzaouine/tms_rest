package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.PackageDetail;
import com.bagile.gmo.entities.TmsPackageDetail;

import java.util.*;

public class PackageDetailMapper {
	public PackageDetailMapper() {
	}

	private static Map<String, String> map;

	static {
		map = new HashMap<>();

		map.put("id", "tmsPackageDetailId");
		map.put("code", "tmsPackageDetailCode");
		map.put("description", "tmsPackageDetailDescription");
	}

	public static Map<String, String> getMap() {
		return map;
	}

	public static String getField(String key) {
		return map.get(key);
	}

	public static TmsPackageDetail toEntity(PackageDetail packageDetail, boolean lazy) {
		if (null == packageDetail) {
			return null;
		}
		TmsPackageDetail tmsPackageDetail = new TmsPackageDetail();
		tmsPackageDetail.setTmsPackageDetailId(packageDetail.getId());

		tmsPackageDetail.setTmsPackageDetailnumberOfPackages(packageDetail.getNumberOfPackages());
		tmsPackageDetail.setTmsPackageDetailWeight(packageDetail.getWeight());
		tmsPackageDetail.setTmsPackageDetailLength(packageDetail.getLength());

		tmsPackageDetail.setTmsPackageDetailWidth(packageDetail.getWidth());
		tmsPackageDetail.setTmsPackageDetailHeight(packageDetail.getHeight());
		if(!lazy){
			//tmsPackageDetail.setOwnOwner(OwnerMapper.toEntity(packageDetail.getOwner(),true));
			tmsPackageDetail.setPrmContainerType(ContainerTypeMapper.toEntity(packageDetail.getContainerType(),true));
			tmsPackageDetail.setTmsOrderTransportInfo(OrderTransportInfoMapper.toEntity(packageDetail.getOrderTransportInfo(),true));


		}
		return tmsPackageDetail;
	}

	public static PackageDetail toDto(TmsPackageDetail tmsPackageDetail, boolean lazy) {
		if (null == tmsPackageDetail) {
			return null;
		}
		PackageDetail packageDetail = new PackageDetail();
		packageDetail.setId(tmsPackageDetail.getTmsPackageDetailId());

		packageDetail.setNumberOfPackages(tmsPackageDetail.getTmsPackageDetailnumberOfPackages());
		packageDetail.setWeight(tmsPackageDetail.getTmsPackageDetailWeight());
		packageDetail.setLength(tmsPackageDetail.getTmsPackageDetailLength());

		packageDetail.setWidth(tmsPackageDetail.getTmsPackageDetailWidth());
		packageDetail.setHeight(tmsPackageDetail.getTmsPackageDetailHeight());

		if(!lazy){
			packageDetail.setContainerType(ContainerTypeMapper.toDto(tmsPackageDetail.getPrmContainerType(),true));
			packageDetail.setOrderTransportInfo(OrderTransportInfoMapper.toDto(tmsPackageDetail.getTmsOrderTransportInfo(),true));

			//packageDetail.setOwner(OwnerMapper.toDto(tmsPackageDetail.getOwnOwner(),true));

		}
		return packageDetail;

	}

	


	public static List<PackageDetail> toDtos(Iterable<? extends TmsPackageDetail> tmsPackageDetails, boolean lazy) {
		if (null == tmsPackageDetails) {
			return null;
		}
		List<PackageDetail> packageDetails = new ArrayList<>();

		for (TmsPackageDetail tmsPackageDetail : tmsPackageDetails) {
			packageDetails.add(toDto(tmsPackageDetail, lazy));
		}
		return packageDetails;
	}

	public static Set<TmsPackageDetail> toEntities(List<PackageDetail> list, boolean lazy) {
		if (null == list) {
			return null;
		}
		Set<TmsPackageDetail> tmsPackageDetails = new HashSet<>();
		for (PackageDetail packageDetail : list) {
			tmsPackageDetails.add(toEntity(packageDetail, lazy));
		}
		return tmsPackageDetails;
	}

	public static List<PackageDetail> toDtos(List<TmsPackageDetail> tmsPackageDetails, boolean lazy) {
		if (null == tmsPackageDetails) {
			return null;
		}
		List<PackageDetail> packageDetails = new ArrayList<>();
		for (TmsPackageDetail tmsPackageDetail : tmsPackageDetails) {
			packageDetails.add(toDto(tmsPackageDetail, lazy));
		}
		return packageDetails;
	}
}
