package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Responsability;
import com.bagile.gmo.entities.GmoResponsability;

import java.util.*;

public class ResponsabilityMapper {
    
    public ResponsabilityMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoResponsabilityId");
        map.put ("code", "gmoResponsabilityCode");
        map.put ("description", "gmoResponsabilityDescription");
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

    public static GmoResponsability toEntity(Responsability responsability, boolean lazy) {
        if (null == responsability) {
            return null;
        }

        GmoResponsability gmoResponsability = new GmoResponsability ( );
        gmoResponsability.setGmoResponsabilityId (responsability.getId ( ));
        gmoResponsability.setGmoResponsabilityCode (responsability.getCode ( ) != null ? responsability.getCode ( ).toUpperCase ( ) : null);
        gmoResponsability.setGmoResponsabilityDescription (responsability.getDescription ( ));
        
        gmoResponsability.setCreatedBy (responsability.getCreatedBy ( ));
        gmoResponsability.setUpdatedBy (responsability.getUpdatedBy ( ));

       

        return gmoResponsability;

    }

    public static Responsability toDto(GmoResponsability gmoResponsability, boolean lazy) {
        if (null == gmoResponsability) {
            return null;
        }
        Responsability responsability = new Responsability ( );
        responsability.setId (gmoResponsability.getGmoResponsabilityId ());
        responsability.setCode (gmoResponsability.getGmoResponsabilityCode ());
        responsability.setDescription (gmoResponsability.getGmoResponsabilityDescription ());

        responsability.setCreatedBy (gmoResponsability.getCreatedBy ());
        responsability.setUpdatedBy (gmoResponsability.getUpdatedBy ());
        responsability.setCreationDate (gmoResponsability.getCreationDate ());
        responsability.setUpdateDate (gmoResponsability.getUpdateDate ());

      
        return responsability;

    }


    public static List<Responsability> toDtos(Iterable<? extends GmoResponsability> gmoResponsabilitys, boolean lazy) {
        if (null == gmoResponsabilitys) {
            return null;
        }
        List<Responsability> responsabilitys = new ArrayList<> ( );

        for (GmoResponsability gmoResponsability : gmoResponsabilitys) {
            responsabilitys.add (toDto (gmoResponsability, lazy));
        }
        return responsabilitys;
    }

    public static Set<GmoResponsability> toEntities(Set<Responsability> responsabilitys, boolean lazy) {
        if (null == responsabilitys) {
            return null;
        }
        Set<GmoResponsability> gmoResponsabilitys = new HashSet<> ( );
        for (Responsability responsability : responsabilitys) {
            gmoResponsabilitys.add (toEntity (responsability, lazy));
        }
        return gmoResponsabilitys;
    }

    public static Set<Responsability> toDtos(Set<GmoResponsability> gmoResponsabilitys, boolean lazy) {
        if (null == gmoResponsabilitys) {
            return null;
        }
        Set<Responsability> responsabilitys = new HashSet<> ( );
        for (GmoResponsability gmoResponsability : gmoResponsabilitys) {
            responsabilitys.add (toDto (gmoResponsability, lazy));
        }
        return responsabilitys;
    }
}
