package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VehicleFeature;
import com.bagile.gmo.entities.GmoVehicleFeature;

import java.util.*;

public class VehicleFeatureMapper {

    public VehicleFeatureMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmovehicleFeatureId");
        map.put ("code", "gmovehicleFeatureCode");
        map.put ("description", "gmovehicleFeatureDescription");
        map.put ("value", "gmovehicleFeatureValue");
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

    public static GmoVehicleFeature toEntity(VehicleFeature vehicleFeature, boolean lazy) {
        if (null == vehicleFeature) {
            return null;
        }

        GmoVehicleFeature gmovehicleFeature = new GmoVehicleFeature ( );
        gmovehicleFeature.setGmoVehicleFeatureId (vehicleFeature.getId ());
        gmovehicleFeature.setGmoVehicleFeatureCode (vehicleFeature.getCode ( ) != null ? vehicleFeature.getCode ( ).toUpperCase ( ) : null);
        gmovehicleFeature.setGmoVehicleFeatureDescription (vehicleFeature.getDescription ( ));
        gmovehicleFeature.setGmoVehicleFeatureValue (vehicleFeature.getValue());

        
        gmovehicleFeature.setCreatedBy (vehicleFeature.getCreatedBy ( ));
        gmovehicleFeature.setUpdatedBy (vehicleFeature.getUpdatedBy ( ));

        if (!lazy) {
            gmovehicleFeature.setPdtUomunit (UomMapper.toEntity (vehicleFeature.getUnit ( ), true));
        }

        return gmovehicleFeature;

    }

    public static VehicleFeature toDto(GmoVehicleFeature gmovehicleFeature, boolean lazy) {
        if (null == gmovehicleFeature) {
            return null;
        }
        VehicleFeature vehicleFeature = new VehicleFeature ( );
        vehicleFeature.setId (gmovehicleFeature.getGmoVehicleFeatureId ());
        vehicleFeature.setCode (gmovehicleFeature.getGmoVehicleFeatureCode ());
        vehicleFeature.setDescription (gmovehicleFeature.getGmoVehicleFeatureDescription ());
        vehicleFeature.setValue (gmovehicleFeature.getGmoVehicleFeatureValue ());

        vehicleFeature.setCreatedBy (gmovehicleFeature.getCreatedBy ());
        vehicleFeature.setUpdatedBy (gmovehicleFeature.getUpdatedBy ());
        vehicleFeature.setCreationDate (gmovehicleFeature.getCreationDate ());
        vehicleFeature.setUpdateDate (gmovehicleFeature.getUpdateDate ());

        if (!lazy) {
            vehicleFeature.setUnit (UomMapper.toDto (gmovehicleFeature.getPdtUomunit(), true));
        }
        return vehicleFeature;

    }


    public static List<VehicleFeature> toDtos(Iterable<? extends GmoVehicleFeature> gmovehicleFeatures, boolean lazy) {
        if (null == gmovehicleFeatures) {
            return null;
        }
        List<VehicleFeature> vehicleFeatures = new ArrayList<> ( );

        for (GmoVehicleFeature gmovehicleFeature : gmovehicleFeatures) {
            vehicleFeatures.add (toDto (gmovehicleFeature, lazy));
        }
        return vehicleFeatures;
    }

    public static Set<GmoVehicleFeature> toEntities(Set<VehicleFeature> vehicleFeatures, boolean lazy) {
        if (null == vehicleFeatures) {
            return null;
        }
        Set<GmoVehicleFeature> gmovehicleFeatures = new HashSet<> ( );
        for (VehicleFeature vehicleFeature : vehicleFeatures) {
            gmovehicleFeatures.add (toEntity (vehicleFeature, lazy));
        }
        return gmovehicleFeatures;
    }

    public static Set<VehicleFeature> toDtos(Set<GmoVehicleFeature> gmovehicleFeatures, boolean lazy) {
        if (null == gmovehicleFeatures) {
            return null;
        }
        Set<VehicleFeature> vehicleFeatures = new HashSet<> ( );
        for (GmoVehicleFeature gmovehicleFeature : gmovehicleFeatures) {
            vehicleFeatures.add (toDto (gmovehicleFeature, lazy));
        }
        return vehicleFeatures;
    }
}
