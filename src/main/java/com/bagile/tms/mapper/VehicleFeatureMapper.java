package com.bagile.tms.mapper;

import com.bagile.tms.dto.VehicleFeature;
import com.bagile.tms.entities.TmsVehicleFeature;

import java.util.*;

public class VehicleFeatureMapper {

    public VehicleFeatureMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsvehicleFeatureId");
        map.put ("code", "tmsvehicleFeatureCode");
        map.put ("description", "tmsvehicleFeatureDescription");
        map.put ("value", "tmsvehicleFeatureValue");
        map.put ("unit", "pdtUomunit");

        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static TmsVehicleFeature toEntity(VehicleFeature vehicleFeature, boolean lazy) {
        if (null == vehicleFeature) {
            return null;
        }

        TmsVehicleFeature tmsvehicleFeature = new TmsVehicleFeature ( );
        tmsvehicleFeature.setTmsVehicleFeatureId (vehicleFeature.getId ());
        tmsvehicleFeature.setTmsVehicleFeatureCode (vehicleFeature.getCode ( ) != null ? vehicleFeature.getCode ( ).toUpperCase ( ) : null);
        tmsvehicleFeature.setTmsVehicleFeatureDescription (vehicleFeature.getDescription ( ));
        tmsvehicleFeature.setTmsVehicleFeatureValue (vehicleFeature.getValue());

        
        tmsvehicleFeature.setCreatedBy (vehicleFeature.getCreatedBy ( ));
        tmsvehicleFeature.setUpdatedBy (vehicleFeature.getUpdatedBy ( ));

        if (!lazy) {
            tmsvehicleFeature.setPdtUomunit (UomMapper.toEntity (vehicleFeature.getUnit ( ), true));
        }

        return tmsvehicleFeature;

    }

    public static VehicleFeature toDto(TmsVehicleFeature tmsvehicleFeature, boolean lazy) {
        if (null == tmsvehicleFeature) {
            return null;
        }
        VehicleFeature vehicleFeature = new VehicleFeature ( );
        vehicleFeature.setId ((int) tmsvehicleFeature.getTmsVehicleFeatureId ());
        vehicleFeature.setCode (tmsvehicleFeature.getTmsVehicleFeatureCode ());
        vehicleFeature.setDescription (tmsvehicleFeature.getTmsVehicleFeatureDescription ());
        vehicleFeature.setValue (tmsvehicleFeature.getTmsVehicleFeatureValue ());

        vehicleFeature.setCreatedBy (tmsvehicleFeature.getCreatedBy ());
        vehicleFeature.setUpdatedBy (tmsvehicleFeature.getUpdatedBy ());
        vehicleFeature.setCreationDate (tmsvehicleFeature.getCreationDate ());
        vehicleFeature.setUpdateDate (tmsvehicleFeature.getUpdateDate ());

        if (!lazy) {
            vehicleFeature.setUnit (UomMapper.toDto (tmsvehicleFeature.getPdtUomunit(), true));
        }
        return vehicleFeature;

    }


    public static List<VehicleFeature> toDtos(Iterable<? extends TmsVehicleFeature> tmsvehicleFeatures, boolean lazy) {
        if (null == tmsvehicleFeatures) {
            return null;
        }
        List<VehicleFeature> vehicleFeatures = new ArrayList<> ( );

        for (TmsVehicleFeature tmsvehicleFeature : tmsvehicleFeatures) {
            vehicleFeatures.add (toDto (tmsvehicleFeature, lazy));
        }
        return vehicleFeatures;
    }

    public static Set<TmsVehicleFeature> toEntities(Set<VehicleFeature> vehicleFeatures, boolean lazy) {
        if (null == vehicleFeatures) {
            return null;
        }
        Set<TmsVehicleFeature> tmsvehicleFeatures = new HashSet<> ( );
        for (VehicleFeature vehicleFeature : vehicleFeatures) {
            tmsvehicleFeatures.add (toEntity (vehicleFeature, lazy));
        }
        return tmsvehicleFeatures;
    }

    public static Set<VehicleFeature> toDtos(Set<TmsVehicleFeature> tmsvehicleFeatures, boolean lazy) {
        if (null == tmsvehicleFeatures) {
            return null;
        }
        Set<VehicleFeature> vehicleFeatures = new HashSet<> ( );
        for (TmsVehicleFeature tmsvehicleFeature : tmsvehicleFeatures) {
            vehicleFeatures.add (toDto (tmsvehicleFeature, lazy));
        }
        return vehicleFeatures;
    }
}
